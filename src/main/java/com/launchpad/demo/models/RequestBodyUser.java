package com.launchpad.demo.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestBodyUser {

    private String name;

    private String email;
}
