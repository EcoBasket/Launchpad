package com.launchpad.demo.dao;

import com.launchpad.demo.models.dynamodb.ShoppingList;

import java.util.Optional;

public interface ShoppingListDao {

    Optional<ShoppingList> getShoppingList(String id);

    ShoppingList updateShoppingList(ShoppingList shoppingList);

    ShoppingList createShoppingList(String userId, String shoppingListId);
}
