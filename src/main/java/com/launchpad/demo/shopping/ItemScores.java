package com.launchpad.demo.shopping;

import java.util.HashMap;
import java.util.Map;

public class ItemScores {
    private static final Map<String, Double> hashMap = new HashMap<>(); //double contains kgco2 per kg of product in the UK

    static {
        hashMap.put("pork", 91.28/25.79);
        hashMap.put("poultry", 33.89/31.55);
        hashMap.put("beef", 559.15/18.12);
        hashMap.put("lamb", 157.24/4.49);
        hashMap.put("goat", 157.24/4.49);
        hashMap.put("fish", 24.73/15.49);
        hashMap.put("egg", 10.18/11.08);
        hashMap.put("eggs", 10.18/11.08);
        hashMap.put("milk", 330.75/232.20);
        hashMap.put("wheat", 18.81/98.63);
        hashMap.put("rice", 8.18/6.39);
        hashMap.put("soy", 0.02/0.05);
        hashMap.put("nuts", 7.40/4.18);
    }

    public static Double getItemScoreFrom(String string) {
        return hashMap.get(string.toLowerCase());
    }
}
