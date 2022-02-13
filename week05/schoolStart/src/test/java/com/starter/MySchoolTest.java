package com.starter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = MySchool.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MySchoolTest {

    @Autowired
    MySchool mySchool;

    @Test
    public void test() {
        System.out.println(123);
        System.out.println(mySchool.toString());
    }

}
