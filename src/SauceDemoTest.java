import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Open website
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Enter login details
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click login
        driver.findElement(By.id("login-button")).click();

        // Add item to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Click on cart
        driver.findElement(By.className("shopping_cart_link")).click();

        String cartItem = driver.findElement(By.className("inventory_item_name")).getText();

        // Check if the correct item is in the cart
        if(cartItem.contains("Backpack")) {
            System.out.println("Product added to cart successfully");
        } else {
            System.out.println("Cart test failed");
        }
        
        // Check if login succeeded
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.contains("inventory")) {
            System.out.println("Login Test Passed");
        } else {
            System.out.println("Login Test Failed");
        }

        // Close browser
        Thread.sleep(3000);
        driver.quit();
    }
}