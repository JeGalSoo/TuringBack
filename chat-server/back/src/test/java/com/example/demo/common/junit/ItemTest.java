package com.example.demo.common.junit;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class ItemTest {

    @Test
    void testAdd(){

    }

    @Test
    public void testPrint() {
        Item s = new Item();
        String s3 = s.print();
        System.out.println("-->"+s3);
        String s2 = "Hello";
        Assertions.assertEquals(s.print(), "Hello");
    }
}