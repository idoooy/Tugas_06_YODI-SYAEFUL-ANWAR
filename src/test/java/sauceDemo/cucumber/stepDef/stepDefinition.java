package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class stepDefinition {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Login page saucedemo")
    public void loginPageSauceDemo() {

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
    }

    @When("User input username")
    public void userInputUserName() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input password")
    public void userInputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("User input invalid username")
    public void userInputInvalidUserName() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user1");
    }

    @Then("User in product page")
    public void userInProductPage() {
        String ActualProducts = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        String ExpectedProducts = "Products";
        Assert.assertEquals(ActualProducts, ExpectedProducts);
    }

    @Then("User get error message")
    public void userGerErrorMessage() {
        String ActualFailedUserName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        String ExpectedFailedUserName = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(ActualFailedUserName, ExpectedFailedUserName);

        driver.close();
    }

    @When("User click button add to cart")
    public void userClickAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User click button cart")
    public void userClickCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("User in cart page")
    public void userInCartPage() {
        String ActualTitle = driver.findElement(By.className("title")).getText();
        String ExpectedTitle = "Your Cart";
        Assert.assertEquals(ActualTitle, ExpectedTitle);

        driver.close();
    }

    @When("User click sidebar menu")
    public void userClickSideBar() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User click menu about")
    public void userClickMenuAbout() {
        driver.findElement(By.id("about_sidebar_link")).click();
    }

    @Then("User in about page")
    public void userInAboutPage() {
        String ActualSignIn = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[1]/a/button")).getText();
        String ExpectedSignIn = "Sign in";
        Assert.assertEquals(ActualSignIn, ExpectedSignIn);

        driver.close();
    }

    @And("User click logout")
    public void userClickLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User in login page")
    public void userInLoginPage() {
        String ActualLogin = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[1]/h4")).getText();
        String ExpectedLogin = "Accepted usernames are:";
        Assert.assertEquals(ActualLogin, ExpectedLogin);

        driver.close();
    }

    @When("User input (.*) as username$")
    public void userInputUserNameDDT(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("User input (.*) as password$")
    public void userInputPasswordDDT(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("User verify (.*) login result$")
    public void userVerifyStatus(String status) {
        if (status.equals("success")) { // assert success login
            String ActualProducts = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
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

}
