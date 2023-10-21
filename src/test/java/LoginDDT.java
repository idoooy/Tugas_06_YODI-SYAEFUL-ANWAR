import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginDDT {
    @Test
    public void testLoginDDT() {

        WebDriver driver;

        String baseUrl = "https://www.saucedemo.com/";

        // WebDriverManager.chromedriver().setup(); //Versi chrome v.14
        WebDriverManager.firefoxdriver().setup();
        // ChromeOptions opt = new ChromeOptions(); //Versi chrome v.14
        FirefoxOptions opt = new FirefoxOptions();
        opt.addArguments("--headless=old");

        String fileDir = System.getProperty("user.dir") + "/src/test/data/test-data.csv";

        try (CSVReader reader = new CSVReader(new FileReader(fileDir))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) { // loop for all row data in csv
                String username = nextLine[0]; // read column 1 for username
                String password = nextLine[1]; // read column 2 for password
                String status = nextLine[2]; // read column 3 for expected login status

                // driver = new ChromeDriver(opt); //Versi chrome v.14
                driver = new FirefoxDriver(opt);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().window().fullscreen();
                driver.get(baseUrl);

                // Input Username
                driver.findElement(By.id("user-name")).sendKeys(username);
                // Input Password
                driver.findElement(By.id("password")).sendKeys(password);

                // Click Login Button
                driver.findElement(By.id("login-button")).click();

                if (status.equals("success")) { // assert success login
                    String ActualProducts = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"))
                            .getText();
                    String ExpectedProducts = "Products";
                    Assert.assertEquals(ActualProducts, ExpectedProducts);
                } else { // assert error message
                    String ActualFailedUserName = driver
                            .findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
                    String ExpectedFailedUserName = "Epic sadface: Username and password do not match any user in this service";
                    Assert.assertEquals(ActualFailedUserName, ExpectedFailedUserName);
                }
                driver.close();
            }

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
