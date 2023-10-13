import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class loginFalse {
    @Test
    public void failedLogin() {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();

        String baseUrl = "https://www.saucedemo.com/";

        // Membuka halaman https://www.saucedemo.com/
        driver.get(baseUrl);
        // Set window to Full Screen
        driver.manage().window().fullscreen();

        // Verifikasi halaman Login
        String ActualTitle = driver.findElement(By.className("login_logo")).getText();
        String ExpectedTitle = "Swag Labs";
        Assert.assertEquals(ActualTitle, ExpectedTitle);

        // Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user1");
        // Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click Login Button
        driver.findElement(By.id("login-button")).click();

        // Verifikasi notifikasi error ketika login dengan username yang salah
        String ActualFailedUserName = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        String ExpectedFailedUserName = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(ActualFailedUserName, ExpectedFailedUserName);

        driver.close();
    }

}
