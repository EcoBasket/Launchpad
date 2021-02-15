package com.launchpad.demo.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.launchpad.demo.dao.ShoppingListDao;
import com.launchpad.demo.models.dynamodb.ShoppingList;
import com.launchpad.demo.shopping.BlankShoppingListProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ShoppingListDaoImpl implements ShoppingListDao {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public ShoppingListDaoImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public Optional<ShoppingList> getShoppingList(String id) {
        return Optional.ofNullable(dynamoDBMapper.load(ShoppingList.class, id));
    }

    @Override
    public ShoppingList updateShoppingList(ShoppingList shoppingList) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();

        expectedAttributeValueMap.put("shoppingListId", new ExpectedAttributeValue(new AttributeValue().withS(shoppingList.getShoppingListId())));

        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);

        dynamoDBMapper.save(shoppingList, saveExpression);

        return shoppingList;
    }

    @Override
    public ShoppingList createShoppingList(String userId, String shoppingListId) {
        ShoppingList shoppingList = BlankShoppingListProvider.provide(userId, shoppingListId);
        dynamoDBMapper.save(shoppingList);
        return shoppingList;
    }
}
