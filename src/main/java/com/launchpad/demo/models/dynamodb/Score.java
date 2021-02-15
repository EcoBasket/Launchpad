package com.launchpad.demo.models.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBDocument
public class Score {

    @DynamoDBAttribute(attributeName = "scoreAmount")
    private Double scoreAmount;

    @DynamoDBAttribute(attributeName = "scoreType")
    private String scoreType;
}
