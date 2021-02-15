package com.launchpad.demo.shopping;

import com.launchpad.demo.models.dynamodb.ShoppingList;

import java.util.List;
import java.util.function.BiFunction;

public class BlankShoppingListProvider {

    private static final BiFunction<String, String, ShoppingList> shoppingListProvider = (userId, shoppingListId) -> ShoppingList.builder()
                .name("Shopping List")
                .score(ScoreProvider.buildScoreFrom(0.0D))
                .items(List.of())
                .userId(userId)
                .shoppingListId(shoppingListId)
                .price(0)
                .build();

    public static ShoppingList provide(String userId, String shoppingListId) {
        return shoppingListProvider.apply(userId, shoppingListId);
    }
}
