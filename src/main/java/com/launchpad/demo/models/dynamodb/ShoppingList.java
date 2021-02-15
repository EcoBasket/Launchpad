package com.launchpad.demo.models.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBTable(tableName = "shopping-dev")
public class ShoppingList {

    @DynamoDBHashKey(attributeName = "shoppingListId")
    private String shoppingListId;

    @DynamoDBAttribute(attributeName = "userId")
    private String userId;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "score")
    private Score score;

    @DynamoDBAttribute(attributeName = "price")
    private Integer price;

    @DynamoDBAttribute(attributeName = "items")
    private List<Item> items;
}
