package HwClass9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Question6 {
    private static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Noa\\Downloads\\chromedriver_win32\\chromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/Controllers/");
    }
    @Test
    public void ClickOnCheese(){
        driver.findElement(By.cssSelector("input[value=Cheese]")).click();
    }
    @Test
    public void selectFoodByVisbleText() {
        Select mySelection = new Select(driver.findElement(By.name("dropdownmenu")));
        mySelection.selectByVisibleText("Milk");
        System.out.println(mySelection.getFirstSelectedOption().getText());
    }
    @Test
    public void PrintDropDownElements() {
        Select mySelection = new Select(driver.findElement(By.name("dropdownmenu")));
        mySelection.selectByVisibleText("Milk");
        System.out.println(mySelection.getFirstSelectedOption().getText());
        mySelection.selectByVisibleText("Cheese");
        System.out.println(mySelection.getFirstSelectedOption().getText());
        mySelection.selectByVisibleText("Butter");
        System.out.println(mySelection.getFirstSelectedOption().getText());
    }
}
