package com.launchpad.demo.services.impl;

import com.launchpad.demo.dao.UserServiceDao;
import com.launchpad.demo.models.RequestBodyUser;
import com.launchpad.demo.models.dynamodb.Score;
import com.launchpad.demo.models.dynamodb.User;
import com.launchpad.demo.services.ShoppingListService;
import com.launchpad.demo.services.UserService;
import com.launchpad.demo.user.UserDecorator;
import com.launchpad.demo.user.UserUpdater;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserServiceDao userServiceDao;

    private final ShoppingListService shoppingListService;

    public UserServiceImpl(UserServiceDao userServiceDao, ShoppingListService shoppingListService) {
        this.userServiceDao = userServiceDao;
        this.shoppingListService = shoppingListService;
    }

    @Override
    public User createUser(RequestBodyUser user) {
        User createdUser = userServiceDao.createUser(UserDecorator.decorate(user));
        shoppingListService.createShoppingList(createdUser.getId(), createdUser.getShoppingListId());
        return createdUser;
    }

    @Override
    public Optional<User> getUser(String id) {
        return userServiceDao.getUser(id);
    }

    @Override
    public User addFriend(String userId, String friendId) {
        User executingUser = getUserAndHandleOptional(userId);
        User targetUser = getUserAndHandleOptional(friendId);
        return addFriend(executingUser, targetUser);
    }

    private User addFriend(User executingUser, User targetUser) {
        User updatedExecutingUser = new UserUpdater(executingUser).addFriend(targetUser.getId());
        User updatedTargetUser = new UserUpdater(targetUser).addFriend(executingUser.getId());

        userServiceDao.updateUser(updatedTargetUser);
        userServiceDao.updateUser(updatedExecutingUser);

        return updatedExecutingUser;
    }

    @Override
    public User deleteFriend(String userId, String friendId) {
        User executingUser = getUserAndHandleOptional(userId);
        User targetUser = getUserAndHandleOptional(userId);
        return deleteFriend(executingUser, targetUser);
    }

    @Override
    public User updateScore(User user, Score score) {
        User updatedUser = new UserUpdater(user).updateScore(score);
        userServiceDao.updateUser(updatedUser);
        return updatedUser;
    }

    private User deleteFriend(User executingUser, User targetUser) {
        User updatedExecutingUser = new UserUpdater(executingUser).removeFriend(targetUser.getId());
        User updatedTargetUser = new UserUpdater(targetUser).removeFriend(executingUser.getId());

        userServiceDao.updateUser(updatedTargetUser);
        userServiceDao.updateUser(updatedExecutingUser);

        return updatedExecutingUser;
    }

    private User getUserAndHandleOptional(String id) {
        Optional<User> userOptional = userServiceDao.getUser(id);

        if (userOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return userOptional.get();
    }
}
