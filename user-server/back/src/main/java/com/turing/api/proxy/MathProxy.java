package com.example.demo.proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    public static Function<Integer,Integer> absInt = Math :: abs;
    public static BiFunction<Integer,Integer,Integer> maxInt = Math :: max;
    public static BiFunction<Integer,Integer,Integer> minInt = Math :: min;
    public static BiFunction<Integer,Integer,Integer> randomInt = (a,b)-> (int)(Math.random() *(b-a)+a);
    public static Function<Double,Integer> ceilDouble = (a)-> (int) Math.ceil(a);
    public static Function<Double,Integer> floorDouble = (a)-> (int)Math.floor(a);
    public static Function<Double,Integer> roundDouble = (a)-> (int)Math.round(a);
    public static Function<Float,Integer> ceilFloat = (a)-> (int) Math.ceil(a);
    public static Function<Float,Integer> floorFloat = (a)-> (int)Math.floor(a);
    public static Function<Float,Integer> roundFloat = (a)-> (int)Math.round(a);


    public static Supplier<Double> randomDouble = Math :: random;
    public static Function<Double,Double> absDouble = Math :: abs;
    public static BiFunction<Double,Double,Double> maxDouble = Math :: max;
    public static BiFunction<Double,Double,Double> minDouble = Math :: min;


    public static BiFunction<Integer,Integer,Float> randomFloat = (a,b)-> (float)(Math.random() *(b-a)+a);
    public static Function<Float,Float> absFloate = Math :: abs;
    public static BiFunction<Float,Float,Float> maxFloat = Math :: max;
    public static BiFunction<Float,Float,Float> minFloat = Math :: min;





}
