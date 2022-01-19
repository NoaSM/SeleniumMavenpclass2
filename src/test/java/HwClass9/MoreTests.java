package HwClass9;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class MoreTests {
    private static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Noa\\Downloads\\chromedriver_win32\\chromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/Actions");
    }

    @Test//Question 5
    public void elementScreenshotTest() {
        takeElementScreenshot(driver.findElement(By.id("div1")));
    }

    private void takeElementScreenshot(WebElement element) {
        File screenShotFile = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("element-screenshot.png")); // save screenshot to disk
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DoubleClickAndAssert() {
        WebElement myElement = driver.findElement(withTagName("p").below(By.id("drag1")));
        //System.out.println(driver.findElement(withTagName("p").below(By.id("drag1"))).getText());
        Actions myAction = new Actions(driver);
        myAction.doubleClick(myElement);
        myAction.perform();

    }

    @Test
    public void MouseHover() {
        Actions hoverAction = new Actions(driver);
        WebElement myElement = driver.findElement(By.id("close"));
        hoverAction.moveToElement(myElement).perform();
    }

    @Test
    public void SelectTwoItems() {
        List<WebElement> elementList = driver.findElements(By.name("kind"));
        Actions myAction = new Actions(driver);
        myAction.clickAndHold(elementList.get(0)).clickAndHold(elementList.get(1));
        //System.out.println(elementList.get(0));
        myAction.build().perform();

    }

    @Test
    public void UploadAFile() {
        driver.findElement(By.name("pic")).sendKeys("C:\\Users\\Noa\\Downloads\\SeleniumMavenClass2\\SeleniumMavenpclass2\\src\\test\\java\\ActionsTest.java");
    }

    @Test
    public void ScrollToElement() {
        WebElement element = driver.findElement(By.id("clickMe"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }
    @Test
    public void ScrollToLocation() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(300,400)");
    }
}
