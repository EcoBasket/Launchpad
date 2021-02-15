package com.launchpad.demo.services.impl;

import com.launchpad.demo.dao.ShoppingListDao;
import com.launchpad.demo.models.RequestBodyItem;
import com.launchpad.demo.models.dynamodb.Item;
import com.launchpad.demo.models.dynamodb.ShoppingList;
import com.launchpad.demo.models.dynamodb.User;
import com.launchpad.demo.services.ShoppingListService;
import com.launchpad.demo.services.UserService;
import com.launchpad.demo.shopping.ItemDecorator;
import com.launchpad.demo.shopping.ShoppingListItemUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    private final ShoppingListDao shoppingListDao;

    @Autowired
    public ShoppingListServiceImpl(ShoppingListDao shoppingListDao) {
        this.shoppingListDao = shoppingListDao;
    }

    @Override
    public ShoppingList addItem(String id, RequestBodyItem item) {
        ShoppingList shopping = getShoppingListAndHandleOptional(id);
        ShoppingList updatedShoppingList = new ShoppingListItemUpdater(shopping).addItem(ItemDecorator.decorate(item));
        return shoppingListDao.updateShoppingList(updatedShoppingList);
    }

    @Override
    public ShoppingList deleteItem(String id, String item) {
        ShoppingList shoppingList = getShoppingListAndHandleOptional(id);
        ShoppingList updatedShoppingList = new ShoppingListItemUpdater(shoppingList).removeItem(item);
        return shoppingListDao.updateShoppingList(updatedShoppingList);
    }

    @Override
    public Optional<ShoppingList> getShoppingList(String id) {
        return shoppingListDao.getShoppingList(id);
    }

    @Override
    public ShoppingList createShoppingList(String userId, String shoppingListId) {
        return shoppingListDao.createShoppingList(userId, shoppingListId);
    }


    private ShoppingList getShoppingListAndHandleOptional(String id) {
        Optional<ShoppingList> shoppingListOptional = shoppingListDao.getShoppingList(id);

        if (shoppingListOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return shoppingListOptional.get();
    }
}
