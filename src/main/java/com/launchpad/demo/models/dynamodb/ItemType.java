package com.launchpad.demo.models.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBDocument
public class ItemType {
    
    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "category")
    private String category;

    @DynamoDBAttribute(attributeName = "score")
    private Score defaultScore;

    @Singular
    @DynamoDBAttribute(attributeName = "sponsoredItems")
    private List<Item> sponsoredItems;

    @Singular
    @DynamoDBAttribute(attributeName = "suggestions")
    private List<Item> suggestions;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public Score getDefaultScore(){
        return defaultScore;
    }

    public void setDefaultScore(Score score){
        this.defaultScore = score;
    }

    public List<Item> getSponsoredItems(){
        return sponsoredItems;
    }

    public void setSponsoredItems(List<Item> items){
        this.sponsoredItems = items;
    }

    public List<Item> getSuggestions(){
        return suggestions;
    }

    public void setSuggestions(List<Item> suggestions){
        this.suggestions = suggestions;
    }
}
