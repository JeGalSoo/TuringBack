package com.example.demo.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class SubstringDemo {

    @Test
    public void 문자열_분할() throws Exception {
        String str = "a,b,c";
        str = new StringBuilder()
                .append(str)
                .append(",d,e,f")
                .toString();
        System.out.println("str : " + str);
        String[] arr = str.split(",");

        assertThat(arr.length).isEqualTo(6);
    }

    @Test
    public void 주민번호로_성별_구분() throws Exception {
        String human1 = "970301-1";
        String human2 = "950101-2";
        String human3 = "020101-3";
        String human4 = "020101-4";
        String human5 = "730101-5";
        String human6 = "820101-6";
        String human7 = "120601-7";
        String human8 = "050424-8";
        String[] arr = {human1,human2,human3,human4,human5,human6,human7,human8};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("옛날나이 : %d, 나이 : %d, 성별 : %s\n",getOldAge(arr[i]),age(arr[i]),Gender(arr[i]));
        }
//            arr[i] = Change(arr[i]);
//            System.out.println(arr[i]);
//
//        }
    }

    private int oldAge(String a) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        return year-birthYear(a)+1;
    }
    private int age(String a) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        return (birthMonth(a)<=month&&birthDay(a)<=day)?year-birthYear(a): year - birthYear(a) - 1;
    }
    private String Gender(String a){
        String result = "";
        return result = switch (a.charAt(7)) {
            case '1','3'-> "남자";
            case '2','4'-> "여자";
            case '5','6','7','8' -> "외국인";
            default -> "";
        };
    }

    private void sample() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        assertThat(year).isEqualTo(2024);
        int month = now.getMonthValue();
        assertThat(month).isEqualTo(4);
        int day = now.getDayOfMonth();
        assertThat(day).isEqualTo(24);
    }
    public int birthYear(String ssn) {
        int birthYear = Integer.parseInt(ssn.substring(0,2));
        int a = se(ssn);
        return (a==1 && birthYear > 24) ? (birthYear +=  1900) : (birthYear += 2000);
    }
    public int birthMonth(String ssn) {
        return Integer.parseInt(ssn.substring(2,4));
    }
    public int birthDay(String ssn) {
        return Integer.parseInt(ssn.substring(4,6));
    }
    private int se(String a){
        int result = 0;
        return result = switch (a.charAt(7)) {
            case '1','2','5','6'-> 1;
            case '3','4','7','8'-> 2;
            default -> 0;
        };
    }


    public int getOldAge(String a){
        return oldAge(a);
    }


    @Test
    public void getAgeUsingLambda(){
        String ssn = "970301-1";
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        String human1 = "970301-1";
        String human2 = "950101-2";
        String human3 = "020101-3";
        String human4 = "020101-4";
        String human5 = "730101-5";
        String human6 = "820101-6";
        String human7 = "120601-7";
        String human8 = "050424-8";
//        String[] ssn = {human1,human2,human3,human4,human5,human6,human7,human8};
        int a = Stream.of(ssn)
                .map(birthYear->Integer.parseInt(ssn.substring(0,2)))
                .map(birthYear->switch (ssn.charAt(7)) {
                    case '1','2','5','6'-> birthYear+1900;
                    case '3','4','7','8'-> birthYear+2000;
                    default -> 0;
                })
//                .map(i->i+Integer.parseInt(ssn.substring(2,6)))
//                .map(gender->switch (ssn.charAt(7)){
//                    case '1','3'-> "남자";
//                    case '2','4'-> "여자";
//                    case '5','6','7','8' -> "외국인";
//                    default -> "";
//                })
                .findFirst()
                .get();
        assertThat(a).isEqualTo(1997);
    }
}