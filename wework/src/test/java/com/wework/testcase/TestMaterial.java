package com.wework.testcase;

import com.wework.page.App;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestMaterial {
    public static App app;
    @BeforeClass
    public static void beforeAll(){

        app=new App();
        app.loginWithCookie();

    }

    @Test
    public void upload(){
        String file = "D:\\girl.jpg";
       int old = app.toMaterial().getNum();
        int  num = app.toMaterial().upload(file);
        assertThat(num,equalTo(old+1));
    }
    @AfterClass
    public static void  afterAll(){
        app.quit();
    }
}
