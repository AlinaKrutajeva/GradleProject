package lecture7;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTask1 {

    @Test
    public void ssLvTest() {
        String driverPath = "C:\\Users\\a_lin\\IdeaProjects\\MyFirstGradleProject\\src\\test\\resources\\chromedriver.exe";
//        Configure system for driver location in system
        System.setProperty("webdriver.chrome.driver", driverPath);
//        Create driver object using path from system location
        ChromeDriver driver = new ChromeDriver();
//        Open url using newly created object
        driver.get("https://www.ss.lv/");
//        Maximize screen
        driver.manage().window().maximize();
//        Find and click Suni un kuceni menu item
        driver.findElement(By.id("mtd_300")).click();
//        Get current url and save to String variable
        String currentUrl = driver.getCurrentUrl();
//        Validate current url
        assertThat(currentUrl).isEqualTo("https://www.ss.lv/lv/animals/dogs/");
//        Create select dropdown element
        Select citySide = new Select(driver.findElements(By.className("filter_sel")).get(1));
        citySide.selectByValue("riga_f");
//        Find element age and enter some data
        driver.findElement(By.id("f_o_1276_min")).sendKeys("1");
//        Find element meklet button by xpath
        driver.findElement(By.xpath("//input[@class='b s12']")).click();
//        Get textbox text
        String ageText = driver.findElement(By.id("f_o_1276_min")).getAttribute("value");
        assertThat(ageText).isEqualTo("1");
//        Wait for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Close driver
        driver.quit();
    }
}
