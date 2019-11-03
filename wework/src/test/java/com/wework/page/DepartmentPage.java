package com.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class DepartmentPage extends BasePage{

    public DepartmentPage add(String dempartName,String parentName){
        findElement(By.name("name")).sendKeys(dempartName);
        findElement(By.linkText("选择所属部门")).click();
        findElement(By.xpath("//div[contains(@class,'qui_dropdownMenu')]//a[text()='"+parentName+"']")).click();
        findElement(By.linkText("确定")).click();
        return this;
    }
    public void delete(String dempartName){
        //findElement(By.linkText(dempartName),10).click();
        WebElement element = driver.findElement(By.linkText(dempartName));
        (new Actions(driver)).moveToElement(element).build().perform();
        findElement(By.xpath("//a[text()='"+dempartName+"']//following-sibling::span")).click();
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确定")).click();
    }

    public void up(String dempartName){
        findElement(By.linkText(dempartName),15).click();
        findElement(By.xpath("//a[text()='"+dempartName+"']//following-sibling::span")).click();
        findElement(By.linkText("上移")).click();
    }
    public void down(String dempartName){
        findElement(By.linkText(dempartName),15).click();
        findElement(By.xpath("//a[text()='"+dempartName+"']//following-sibling::span")).click();
        findElement(By.linkText("下移")).click();
    }
    public void  getList(){
        List<String> list=new ArrayList<String>();
       // driver.findElements(By.xpath("//ul[@role='treeitem']"))
        List<WebElement>  elements = driver.findElements(By.cssSelector("[role='treeitem']"));
        for (WebElement element:elements){
            //element.getText()
        }
    }
    public String update(String oldname,String newname){
        findElement(By.id("memberSearchInput"),10).sendKeys(oldname);
        findElement(By.linkText("修改名称")).click();
        findElement(By.name("name")).sendKeys(newname);
        findElement(By.linkText("保存")).click();
        String msg =  findElement(By.id("js_tips")).getText();
        findElement(By.id("clearMemberSearchInput")).click();
        return msg;
    }

}
