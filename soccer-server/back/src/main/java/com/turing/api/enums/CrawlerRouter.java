//package com.turing.api.enums;
//
//import com.turing.api.crawler.CrawlerController;
//import org.jsoup.nodes.Element;
//
//import javax.swing.*;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.function.Supplier;
//import java.util.stream.Stream;
//
//public enum CrawlerRouter {
//    EXIT(0, () -> {
//        System.out.println("종료");
//        return false;
//    }),
//    BUGS(1, () -> {
//        System.out.println("1-벅스뮤직");
//        Scanner sc = new Scanner(System.in); // Scanner 생성
//
//        Map<String, ?> map = null;
//        try {
//            map = CrawlerController.findBugsMusic(sc);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Iterator<Element> rank = (Iterator<Element>) map.get("rank");
//                    Iterator<Element> artist = (Iterator<Element>) map.get("artist");
//                    Iterator<Element> title = (Iterator<Element>) map.get("title");
//
//                    System.out.println("벅스뮤직 결과 : ");
//                    while(rank.hasNext()){
//                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
//                    }
//        return true;
//    });
//
//    private final int num;
//    private final Supplier<Boolean> supplier;
//
//    CrawlerRouter(int num, Supplier<Boolean> supplier) {
//        this.num = num;
//        this.supplier = supplier;
//    }
//
//    public static boolean select(Scanner sc) {
//        System.out.println("[사용자메뉴] 0-종료\n " + "1-벅스뮤직");
//        while (true) {
//            int foo = sc.nextInt();
//            return Stream.of(values())
//                    .filter(i -> i.num == foo)
//                    .findAny().orElseThrow()
//                    .supplier.get();
//        }
//    }
//}