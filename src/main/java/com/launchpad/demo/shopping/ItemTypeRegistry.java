package com.launchpad.demo.shopping;

import com.launchpad.demo.models.dynamodb.Amount;
import com.launchpad.demo.models.dynamodb.Item;
import com.launchpad.demo.models.dynamodb.ItemType;

import java.util.HashMap;
import java.util.Map;

public class ItemTypeRegistry {

    private static final Map<String, ItemType> hashMap = new HashMap<>();

    private static final Item BEEF_SPONSORED_ITEM = Item.builder()
            .name("Sainsbury's Beef")
            .price(375)
            .isBought(false)
            .isPromoted(true)
            .quantity(1)
            .size(Amount.builder().amount(5).amountType(Amount.KG).build())
            .build();

    private static final Item BEEF_SUGGESTION = Item.builder()
            .name("Local Cheap Beef")
            .price(300)
            .isBought(false)
            .isPromoted(false)
            .quantity(1)
            .size(Amount.builder().amount(5).amountType(Amount.KG).build())
            .build();

    private static final Item SALMON_SPONSORED_ITEM = Item.builder()
            .name("Sainsbury's Salmon")
            .price(550)
            .isBought(false)
            .isPromoted(true)
            .quantity(1)
            .size(Amount.builder().amount(230).amountType(Amount.G).build())
            .build();

    private static final Item SALMON_SUGGESTION = Item.builder()
            .name("Local Cheap Salmon")
            .price(450)
            .isBought(false)
            .isPromoted(false)
            .size(Amount.builder().amount(230).amountType(Amount.G).build())
            .build();

    private static final Item MILK_SPONSORED_ITEM = Item.builder()
            .name("Sainsbury's Milk")
            .price(550)
            .isBought(false)
            .isPromoted(true)
            .quantity(1)
            .size(Amount.builder().amount(230).amountType(Amount.L).build())
            .build();

    private static final Item MILK_SUGGESTION = Item.builder()
            .name("Almond Milk")
            .price(450)
            .isBought(false)
            .isPromoted(false)
            .size(Amount.builder().amount(230).amountType(Amount.G).build())
            .build();

    private static final Item EGG_SPONSORED_ITEM = Item.builder()
            .name("Sainsbury's Eggs")
            .price(170)
            .isBought(false)
            .isPromoted(true)
            .size(Amount.builder().amount(12).amountType(Amount.EGGS).build())
            .build();

    private static final Item EGG_SUGGESTION = Item.builder()
            .name("Cheap Local Eggs")
            .price(110)
            .isBought(false)
            .isPromoted(true)
            .size(Amount.builder().amount(12).amountType(Amount.EGGS).build())
            .build();

    static{
        hashMap.put("beef", ItemType.builder()
                .name("Beef")
                .category("BEEF")
                .defaultScore(ScoreProvider.buildScoreFrom(ItemScores.getItemScoreFrom("beef")))
                .sponsoredItem(BEEF_SPONSORED_ITEM)
                .suggestion(BEEF_SUGGESTION)
                .build());

        hashMap.put("salmon", ItemType.builder()
                .name("Salmon")
                .category("FISH")
                .defaultScore(ScoreProvider.buildScoreFrom(ItemScores.getItemScoreFrom("fish")))
                .sponsoredItem(SALMON_SPONSORED_ITEM)
                .suggestion(SALMON_SUGGESTION)
                .build());

        hashMap.put("milk", ItemType.builder()
                .name("Milk")
                .category("Milk")
                .defaultScore(ScoreProvider.buildScoreFrom(ItemScores.getItemScoreFrom("milk")))
                .sponsoredItem(MILK_SPONSORED_ITEM)
                .suggestion(MILK_SUGGESTION)
                .build());

        hashMap.put("eggs", ItemType.builder()
                .name("Eggs")
                .category("Eggs")
                .defaultScore(ScoreProvider.buildScoreFrom(ItemScores.getItemScoreFrom("egg")))
                .sponsoredItem(EGG_SPONSORED_ITEM)
                .suggestion(EGG_SUGGESTION)
                .build());
    }

    public static ItemType getItemTypeFrom(String string) { return hashMap.get(string.toLowerCase()); }

    public static boolean doesItemTypeExistFor(String string) {
        return hashMap.containsKey(string.toLowerCase());
    }
}
