//package com.turing.api.enums;
//
//import com.turing.api.review.ReViewController;
//
//import java.sql.SQLException;
//import java.util.Scanner;
//import java.util.function.Consumer;
//import java.util.stream.Stream;
//
//public enum ReViewRouter {
//    exit(0, i-> System.out.println("exit")),
//    show(1,i-> {
//        System.out.println("ehla");
//    })
//    ;
//    private final int num;
//    private final Consumer<Integer> consumer;
//
//    ReViewRouter(int num, Consumer<Integer> consumer) {
//        this.num = num;
//        this.consumer = consumer;
//    }
//    public static void select(Scanner sc){
//        System.out.println("0:종료\n" +
//                            "1:출력");
//        boolean bar=true;
//        while (bar) {
//            int foo = sc.nextInt();
//            bar = foo != 0;
//            Stream.of(values())
//                    .filter(i -> i.num == foo)
//                    .findAny()
//                    .orElseThrow()
//                    .consumer.accept(foo);
//
//        }
//    }
//}
