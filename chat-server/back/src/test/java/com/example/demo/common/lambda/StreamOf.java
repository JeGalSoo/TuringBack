package com.example.demo.common.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOf {


    @Test
    public void testSame() {
            // Creating an integer array
            int arr[] = {1, 2, 3, 4, 5};

            // --------- Using Arrays.stream() ---------
            // to convert int array into Stream
            IntStream intStream = Arrays.stream(arr);

            // Displaying elements in Stream
            intStream.forEach(str -> System.out.print(str + " "));

            // --------- Using Stream.of() ---------
            // to convert int array into Stream
            Stream<int[]> stream = Stream.of(arr);

            // Displaying elements in Stream
            stream.forEach(str -> System.out.print(str + " "));

            //결과 : 1 2 3 4 5 [I@75f32542
    }

    @Test
    public void testDifferent() {
            // Creating an integer array
            int arr[] = { 1, 2, 3, 4, 5 };

            // --------- Using Arrays.stream() ---------
            // to convert int array into Stream
            IntStream intStream = Arrays.stream(arr);

            // Displaying elements in Stream
            intStream.forEach(str -> System.out.print(str + " "));

            // --------- Using Stream.of() ---------
            // to convert int array into Stream
            Stream<int[]> stream = Stream.of(arr);

            // ***** Flattening of Stream<int[]> into IntStream *****
            // flattenning Stream<int[]> into IntStream
            // using flatMapToInt()
            IntStream intStreamNew = stream.flatMapToInt(Arrays::stream);

            // Displaying elements in IntStream
            intStreamNew.forEach(str -> System.out.print(str + " "));

            //결과 : 1 2 3 4 5 1 2 3 4 5
    }
}
