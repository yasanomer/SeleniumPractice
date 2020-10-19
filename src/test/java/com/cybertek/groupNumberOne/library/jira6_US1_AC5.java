package com.cybertek.groupNumberOne.library;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class jira6_US1_AC5 {
  /*
  AC#5
Given As a library member
When I click on a "Book Categories" dropdown
And I select one genre.
Then the category table show change to the selected genre.
    */

    @BeforeMethod
    public void setup () throws InterruptedException {
        Driver.getDriver().get("http://library2.cybertekschool.com");

        WebElement email=  Driver.getDriver().findElement(By.xpath("//input[@id='inputEmail']"));
        email.sendKeys("student93@library");

        WebElement password=  Driver.getDriver().findElement(By.xpath("//input[@id='inputPassword']"));
        password.sendKeys("QU5745l5");

        WebElement sign =  Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
        sign.click();
        BrowserUtils.wait(3);

    }
    @Test
    public void bookCategories (){
        WebElement categories = Driver.getDriver().findElement(By.xpath("//div[@class='col-md-6']"));
        categories.click();
        WebElement selection = Driver.getDriver().findElement(By.xpath("//select[@id='book_categories']"));
        Select select =new Select(selection);
        select.selectByVisibleText("Romance");
        selection.click();
        System.out.println(selection.getText());
        Assert.assertTrue(selection.isDisplayed());
    }

    @Test
    public void bookCategories2(){
// Find book categories link and click
        WebElement categories = Driver.getDriver().findElement(By.xpath("//div[@class='col-md-6']"));
        categories.click();
// Click on dropDown
        WebElement dropdown = Driver.getDriver().findElement(By.id("book_categories"));
        Select select = new Select(dropdown);
// Select genre

        String genre = "Classic";

        select.selectByVisibleText(genre);

        dropdown.click();


//Expend number of visible books
        WebElement showButton = Driver.getDriver().findElement(By.xpath("//select[@name='tbl_books_length']"));
        showButton.click();

        Select select1 = new Select(showButton);
        select1.selectByVisibleText("500");

        // Finding if category table show change to the selected genre
        //Locating all elements
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//tbody//tr/td[5]"));

// Assert if expect meat actual
        for (int i = 0; i <list.size()-1 ; i++) {
            Assert.assertTrue(list.get(i).getText().equals(genre));
        }
    /*
    for ( WebElement each : list ) {
        System.out.println("Each categories: " + each.getText());
    }


     */



    }

    @Test
    public void borrowedBy(){
        WebElement booksModule = Driver.getDriver().findElement(By.xpath("(//span[@class='title'])[3]"));
        booksModule.click();
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@class='form-control input-sm input-small input-inline']"));
        searchBox.sendKeys("Test Student 93");
        BrowserUtils.wait(2);
        WebElement result = Driver.getDriver().findElement(By.xpath("//div[@id='tbl_books_info']"));
        System.out.println("result.getText() = " + result.getText());
        String actual = "No entries found";
        Assert.assertTrue(actual.equals(result.getText()));
    }

}
