//package com.turing.api.enums;
//
//import com.turing.api.menu.MenuController;
//import com.turing.api.user.UserController;
//
//import java.sql.SQLException;
//import java.util.Scanner;
//import java.util.function.Function;
//import java.util.stream.Stream;
//
//public enum UserRouterPredicate {
//    exit("x",i-> {
//        return false;
//    }),
//    find_id("cat",i-> {
//        try {
//            System.out.println(UserController.getInstance().findUsername(i));
//        } catch (SQLException e) {
//            System.out.println("wrong");
//        }
//        return true;
//    }),
//    find_by_name("ls-n",i->{
//        try {
//            System.out.println(UserController.getInstance().findUsersByName(i));
//        } catch (SQLException e) {
//            System.out.println("wrong");
//        }
//        return true;
//    }),
//    count("cnt",i-> {
//        try {
//            System.out.println(UserController.getInstance().count());
//        } catch (SQLException e) {
//            System.out.println("wrong");
//        }
//        return true;
//    }),
//    save("joi",i-> {
//        try {
//            System.out.println(UserController.getInstance().save1(i));
//            return true;
//        } catch (SQLException e) {
//            System.out.println("wrong");
//        }
//        return true;
//    }),
//    login("log",i-> {
//        try {
//            System.out.println(UserController.getInstance().login(i));
//        } catch (SQLException e) {
//            System.out.println("wrong");
//        }
//        return true;
//    }),
//    touch("mk",i-> {
//        try {
//            System.out.println(UserController.getInstance().touch());
//            return true;
//        } catch (SQLException e) {
//            System.out.println("wrong");
//        }
//        return true;
//    }),
//    rm("rm",i-> {
//        try {
//            System.out.println(UserController.getInstance().rm());
//            return true;
//        } catch (SQLException e) {
//            System.out.println("wrong");
//        }
//        return true;
//    }),
//    cat("ls-a",i-> {
//        try {
//            System.out.println(UserController.getInstance().findAll());
//        } catch (SQLException e) {
//            System.out.println("wrong");
//        }
//        return true;
//    }),
//    find_by_job("ls-job",i-> {
//        try {
//            System.out.println(UserController.getInstance().findUsersByJobFromMap(i));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }),
//    cp("ch-pw",i-> {
//        try {
//            System.out.println(UserController.getInstance().updatePassword(i));
//        } catch (SQLException e) {
//            System.out.println("wrong");
//        }
//        return true;
//    });
//    private final String num;
//    private final Function<Scanner, Boolean> function;
//
//    UserRouterPredicate(String num, Function<Scanner,Boolean> predicate) {
//        this.num = num;
//        this.function = predicate;
//    }
//    public static boolean getOperator(Scanner sc) throws SQLException {
//        System.out.println(MenuController.munu("menus where category='user'","item"));
//        String a = sc.next();
//        return Stream.of(values()).filter(i -> i.num.equals(a))
//                .findAny().orElse(UserRouterPredicate.exit)
//                .function
//                .apply(sc);
//    }
//}
//ch-pw 비밀번호 번경, ls-n:find by name, ls-job:find by job