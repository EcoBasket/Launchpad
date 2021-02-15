package com.launchpad.demo.services;

import com.launchpad.demo.models.RequestBodyItem;
import com.launchpad.demo.models.dynamodb.ShoppingList;

import java.util.Optional;

public interface ShoppingListService {

    ShoppingList addItem(String id, RequestBodyItem item);

    ShoppingList deleteItem(String id, String item);

    Optional<ShoppingList> getShoppingList(String id);

    ShoppingList createShoppingList(String userId, String shoppingListId);
}
