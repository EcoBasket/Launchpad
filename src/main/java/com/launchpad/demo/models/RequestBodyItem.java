package com.launchpad.demo.models;

import com.launchpad.demo.models.dynamodb.Amount;
import lombok.*;

/* VERY hacky solution to not enforcing that the person consuming the REST API has to fill in all the details for an item */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestBodyItem {

    private String name;

    private Integer quantity;

    private Integer price;

    private Amount size;
}
