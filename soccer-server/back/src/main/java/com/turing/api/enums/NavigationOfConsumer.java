//package com.turing.api.enums;
//
//import java.sql.SQLException;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//public enum NavigationOfConsumer {
//    user("u", i -> {
//        while(true) {
//            try {
//                if (!UserRouterPredicate.getOperator(i)) break;
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            ;
//        }
//        return ;
//    }),
//    exit("x", i->{return ;})
//    ;
//    private final String menu;
//    private final Consumer<Scanner> consumer;
//
//    NavigationOfConsumer(String menu, Consumer<Scanner> consumer) {
//        this.menu = menu;
//        this.consumer = consumer;
//    }
//
//    public static void select(Scanner sc) {
//        String a = sc.next();
//        while (true) {
//            Arrays.stream(values())
//                    .filter(i -> i.menu.equals(a))
//                    .findFirst().orElseThrow(() -> new IllegalArgumentException("error"))
//                    .consumer.accept(sc);
//            return;
//        }
//    }
//}
