//package com.turing.api.enums;
//
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.function.Supplier;
//
//public enum NavigationOfSupplier {
//    user("u", () -> {
////        while(UserRouterPredicate.getOperator());
//        return "True";
//    }),
//    exit("x", ()->{return "False";})
//    ;
//    private final String menu;
//    private final Supplier<String> supplier;
//
//    NavigationOfSupplier(String menu, Supplier<String> supplier) {
//        this.menu = menu;
//        this.supplier = supplier;
//    }
//
//    public static String select() {
//        while (true) {
//            return Arrays.stream(values())
//                    .filter(i -> i.menu.equals(sc.next()))
//                    .findFirst().orElseThrow(() -> new IllegalArgumentException("error"))
//                    .supplier.get();
//        }
//    }
//}
