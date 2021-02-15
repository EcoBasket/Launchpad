package com.launchpad.demo.shopping;

import com.launchpad.demo.models.dynamodb.ItemType;

import java.util.Arrays;

public class FoodToItemTypeMapper {

    private static final ItemType DEFAULT_ITEM_TYPE = ItemType.builder()
            .name("Default")
            .category("DEFAULT")
            .defaultScore(ScoreProvider.buildScoreFrom(3.2))
            .build();

    public static ItemType stringToItemType(String string) {
        System.out.println(string);
        return Arrays.stream(string.split(" "))
                .filter(ItemTypeRegistry::doesItemTypeExistFor)
                .map(ItemTypeRegistry::getItemTypeFrom).findFirst()
                .orElse(DEFAULT_ITEM_TYPE);
    }
}
