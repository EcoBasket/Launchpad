package com.launchpad.demo.shopping;

import com.launchpad.demo.models.dynamodb.ShoppingList;

public class ShoppingListScoreHandler {
    private final ShoppingList shoppingList;

    public ShoppingListScoreHandler(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public Double getShoppingListScore() {
        return shoppingList.getItems().stream().mapToDouble(ItemScoreHandler::getItemScore).sum();
    }

}
