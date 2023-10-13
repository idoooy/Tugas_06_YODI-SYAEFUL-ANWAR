import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class loginTrue {
    @Test
    public void successLogin() {

        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();

        String baseUrl = "https://www.saucedemo.com/";

        //Membuka halaman https://www.saucedemo.com/
        driver.get(baseUrl);
        //Set window to Full Screen
        driver.manage().window().fullscreen();

        //Verifikasi halaman Login
        String ActualTitle = driver.findElement(By.className("login_logo")).getText();
        String ExpectedTitle = "Swag Labs";
        Assert.assertEquals(ActualTitle, ExpectedTitle);

        //Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click Login Button
        driver.findElement(By.id("login-button")).click();

        //Verifikasi halaman Products
        String ActualProducts = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        String ExpectedProducts = "Products";
        Assert.assertEquals(ActualProducts, ExpectedProducts);

        driver.close();

    }

}
