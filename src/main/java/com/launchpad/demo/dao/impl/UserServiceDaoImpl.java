package com.launchpad.demo.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.launchpad.demo.dao.UserServiceDao;
import com.launchpad.demo.models.dynamodb.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class UserServiceDaoImpl implements UserServiceDao {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public UserServiceDaoImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public Optional<User> getUser(String id) {
        return Optional.ofNullable(dynamoDBMapper.load(User.class, id));
    }

    @Override
    public User createUser(User user) {
        dynamoDBMapper.save(user);
        return user;
    }

    @Override
    public User updateUser(User updatedUser) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();

        expectedAttributeValueMap.put("id", new ExpectedAttributeValue(new AttributeValue().withS(updatedUser.getId())));

        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);

        dynamoDBMapper.save(updatedUser, saveExpression);

        return updatedUser;
    }
}
