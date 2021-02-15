package com.launchpad.demo.shopping;

import com.launchpad.demo.models.dynamodb.Score;

public class ScoreProvider {
    //one method
    //one parameter
    //returns score takes double
    //if between thing and thing, does shit whatever the fuck its meant to do ok
    //factory method in here
    public static Score buildScoreFrom(Double d){
        String type = scoreTypeFactory(d);
        return Score.builder().scoreAmount(d).scoreType(type).build();
    }

    public static String scoreTypeFactory(Double d){
     //if between this and this, its this type
        if(d<1) return("Very Low");
        else if(d<1.4) return("Low");
        else if(d<2.5) return("Average");
        else if(d<4) return("High");
        else return("Very High");
    }
}
