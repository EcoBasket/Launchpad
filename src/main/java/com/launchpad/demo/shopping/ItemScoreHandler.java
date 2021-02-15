package com.launchpad.demo.shopping;

import com.launchpad.demo.models.dynamodb.Item;
import com.launchpad.demo.models.dynamodb.ItemType;

import java.text.DecimalFormat;
import java.util.Objects;

public class ItemScoreHandler {

    public static Double getItemScore(Item item) {
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.valueOf(df.format(
                ItemScores.getItemScoreFrom(item.getItemType().getCategory())/item.getQuantity()));
    }
}
