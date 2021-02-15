package com.launchpad.demo.models;


import lombok.Data;

@Data // Getter setter constructors of all args.
public class HelloWorld {
    private int length;
    private String units;

    public HelloWorld(int length, String units) {
        this.length = length;
        this.units = units;
    }
}
