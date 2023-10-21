package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class stepDefinition2 {

    //stepDefinition2 page Product dibuat sebagai Given
    //Mencoba fungsi .sleep()

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Product page saucedemo2")
    public void productPageSauceDemo2() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions opt = new FirefoxOptions();
        opt.addArguments("--headless=old");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get(baseUrl);

        String ActualTitle = driver.findElement(By.className("login_logo")).getText();
        String ExpectedTitle = "Swag Labs";
        Assert.assertEquals(ActualTitle, ExpectedTitle);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        Thread.sleep(5000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String ActualProducts = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        String ExpectedProducts = "Products";
        Assert.assertEquals(ActualProducts, ExpectedProducts);
    }

    @When("User click sidebar menu2")
    public void userClickSideBar2() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User click menu about2")
    public void userClickMenuAbout2() {
        driver.findElement(By.id("about_sidebar_link")).click();
    }

    @Then("User in about page2")
    public void userInAboutPage2() {
        String ActualSignIn = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[1]/a/button")).getText();
        String ExpectedSignIn = "Sign in";
        Assert.assertEquals(ActualSignIn, ExpectedSignIn);

        driver.close();
    }
}
