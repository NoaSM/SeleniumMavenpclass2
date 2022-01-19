package HwClass9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Tests {
    private static WebDriver driver;
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Noa\\Downloads\\chromedriver_win32\\chromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/WebCalculator/");
    }
    @Test//Question1
    public void Print_7_Dimension() {
        WebElement numberElement7 = driver.findElement(By.id("seven"));
        System.out.println("Height: " + numberElement7.getRect().getHeight());
        System.out.println("Width: " + numberElement7.getRect().getWidth());
        System.out.println("X: " + numberElement7.getRect().getX());
        System.out.println("Y: " + numberElement7.getRect().getY());
    }
    @Test
    public void Check_6_Display() {
        WebElement numberElement6 = driver.findElement(By.id("six"));
        System.out.println("Is displayed: " + numberElement6.isDisplayed());
    }
    @Test
    public void Assertion_Test() {
        String answer = "8";
        //Scanner input = new Scanner((System.in));
        //System.out.println("Choose 2 numbers:");
        int num1 = 4;
        int num2 = 4;

        int result = num1 + num2;
        System.out.println(num1 + "+" + num2 + "=" + result);

        System.out.println("Actual result = " + result);
        System.out.println("Expaction result = " + answer);
        Assert.assertEquals(result,Integer.parseInt(answer));
    }
    @Test//Question2
    public void Assert_Website_Url(){
        //System.out.println(driver.getTitle());
        //System.out.println(driver.getCurrentUrl());
        String Title = "Calculator";
        String URL = "https://dgotlieb.github.io/WebCalculator/";
        Assert.assertEquals(URL,driver.getCurrentUrl());
    }
    @Test//Question3
    public void Assert_Title(){
        String Title = "Calculator";
        driver.getTitle();
        Assert.assertEquals(Title, driver.getTitle());
    }

}
