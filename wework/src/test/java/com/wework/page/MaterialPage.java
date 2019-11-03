package com.wework.page;

import org.openqa.selenium.By;

public class MaterialPage extends BasePage{

    public int upload(String file){
        findElement(By.partialLinkText("图片")).click();
        findElement(By.partialLinkText("添加图片")).click();
        findElement(By.id("js_upload_input"),0).sendKeys(file);
        findElement(By.linkText("完成")).click();
        return Integer.valueOf(findElement(By.className("js_list_total")).getText());
    }
    public int getNum(){
        return Integer.valueOf(findElement(By.className("js_list_total")).getText());
    }
}
