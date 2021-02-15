package com.launchpad.demo.util;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;

@UtilityClass
public class ComparatorUtils {

    public <T> Comparator<T> comparingDoubleInReverseOrderUsingKeyExtraction(ToDoubleFunction<? super T> keyExtractor) {
        return (k1, k2) -> Double.compare(keyExtractor.applyAsDouble(k2), keyExtractor.applyAsDouble(k1));
    }
}
