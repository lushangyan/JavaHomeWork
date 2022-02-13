package com.starter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MySchoolTest {

    @Autowired
    MySchool mySchool;

    @Test
    public void test() {
        System.out.println(mySchool.toString());
    }
}
