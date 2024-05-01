package com.turing.api.proxy;

import java.util.Objects;
import java.util.function.Function;

public class typeProxy {
    public static Function<Objects,String> string = String :: valueOf;
    public static Function<String,Integer> integer = Integer :: valueOf;
    public static Function<String,Double> doubleOf = Double :: valueOf;
    public static Function<String,Float> floatOf = Float :: valueOf;



}