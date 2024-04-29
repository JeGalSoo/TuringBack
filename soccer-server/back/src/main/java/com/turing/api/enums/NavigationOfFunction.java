//package com.turing.api.enums;
//
//import com.turing.api.account.AccountView;
//import com.turing.api.menu.MenuController;
//import com.turing.api.menu.MenuRouter;
//
//import java.sql.SQLException;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.function.Function;
//
//public enum NavigationOfFunction {
//    user("u", i -> {
//        while(true) {
//            try {
//                if (!UserRouterPredicate.getOperator(i)) break;
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            ;
//        }
//        return "True";
//    }),
//    review("r", i -> {
//        ReViewRouter.select(i);
//        return "true";
//    }),
//    account("a", i -> {
//        while(AccountView.main(i));
//        return "true";
//    }),
//    crawler("c", i -> {
//        while(!CrawlerRouter.select(i)) {
//        }
//        return "true";
//    }),
//    mk("mk", i -> {
//        while(true) {
//            try {
//                if (!MenuRouter.main()) break;
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            ;
//        }
//        return "true";
//    }),
//    exit("x", i->{return "False";})
//    ;
//    private final String menu;
//
//    private final Function<Scanner,String> function;
//    NavigationOfFunction(String menu, Function<Scanner,String> function) {
//        this.menu = menu;
//        this.function = function;
//    }
//    public static String select(Scanner sc) throws SQLException {
//        System.out.println(MenuController.munu("menus","category"));
//        String a = sc.next();
//        while (true) {
//            return Arrays.stream(values())
//                    .filter(i -> i.menu.equals(a))
//                    .findFirst().orElseThrow(() -> new IllegalArgumentException("error"))
//                    .function.apply(sc);
//        }
//    }
//}