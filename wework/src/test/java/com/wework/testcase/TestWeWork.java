package com.wework.testcase;

import com.wework.page.App;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestWeWork {


    public static App app;
    @BeforeClass
    public static void beforeAll(){

        app=new App();
        app.loginWithCookie();
        /*String phone ="18888888885";
        app.toContact().delete(phone);*/
    }

    @Test
    public void  add(){


       String phone ="18888888883";
        app.toMemberAdd().add(phone,phone,phone);
    }

    @Test
    public void delete(){
        String phone ="18888888885";
        app.toMemberAdd().add(phone,phone,phone).delete(phone);
    }
    @Test
    public void deleteCurePage(){
        app.toContact().deleteCurrentPage();
    }

    @Test
    public void importFromFile(){
        app.toContact().importFromFile();
    }
    @AfterClass
    public static void  afterAll(){
        app.quit();
    }
}
