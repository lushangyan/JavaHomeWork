package com.starter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySchoolTest {

    @Autowired
    private MySchool mySchool;


    @Test
    public void test() {
        System.out.println(123);
        System.out.println(mySchool.toString());
    }

}
