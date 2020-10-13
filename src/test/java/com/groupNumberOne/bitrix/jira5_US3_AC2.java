package com.groupNumberOne.bitrix;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class jira5_US3_AC2 {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk23@cybertekschool.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void attachLink (){
        WebElement event = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        event.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement link = driver.findElement(By.xpath("(//span[@title='Link'])[2]"));
        link.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement linkText = driver.findElement(By.xpath("(//input[@id='linkoCalEditorcal_3Jcl-text'])"));
        linkText.sendKeys("Professor");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement linkUrl = driver.findElement(By.xpath("(//input[@id='linkoCalEditorcal_3Jcl-href'])"));
        linkUrl.sendKeys("https://www.youtube.com/watch?v=ZAXA1DV4dtI");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement save = driver.findElement(By.xpath("//input[@class='adm-btn-save']"));
        save.click();
        WebElement send = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        send.click();

    }
}
