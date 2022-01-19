package HwClass9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Question7 {
    private static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Noa\\Downloads\\chromedriver_win32\\chromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/WebCalculator/");
    }
    @Test
    public void HeightAndWidth(){
        System.out.println("Height: " + driver.findElement(By.id("two")).getRect().getHeight());
        System.out.println("Height: " + driver.findElement(By.id("six")).getRect().getWidth());
    }
}
