package com.launchpad.demo.models.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBDocument
public class Amount {

    public static final String KG = "kg";

    public static final String G = "g";

    public static final String L = "l";

    public static final String ML = "ml";

    public static final String EGGS = "Eggs";

    @DynamoDBAttribute(attributeName = "amount")
    private Integer amount;

    @DynamoDBAttribute(attributeName = "amountType")
    private String amountType;

}
