import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


 public class LoginTestJumia {

    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver();
        //2. Input your Jumia page URL (https://www.jumia.com.ng)
        driver.get("https://www.jumia.com.ng/");
        if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/")) {
            System.out.println("correct webpage");
        } else {
            System.out.println("incorrect webpage");
        }


        Thread.sleep(5000);
        //3. Maximize the window
        driver.manage().window().maximize();

        //4. Click on the Account button
        driver.findElement(By.xpath("//html/body/div[1]/header/section/div/div[2]/div[1]/label")).click();

        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void clickSigninButton() throws InterruptedException {
        //5. Click on the sign-in button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div/div[2]/div[1]/div/div/div/a")).click();
        //verify the user is on the right sign in page
        String expectedUrl = "https://www.jumia.com.ng/customer/account/login/?return=%2F";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("correct Webpage");
        }
        else {
            System.out.println("incorrect Webpage");
        }
        Thread.sleep(5000);
    }



    @Test (priority = 1)
    public void positiveLogin() throws InterruptedException {
        //Verify that a user can login with correct email and password
        //6. Input your email address
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/div[1]/div[1]/input")).sendKeys("obeprincenoel@gmailnator.com");
        //7. Input your password
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/div[1]/div[2]/input")).sendKeys("123456");
        //8. Click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void clickAccountbutton() throws InterruptedException {
        //9. Click on the "Hi Prince" button
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div/div[2]/div[1]/label")).click();

        Thread.sleep(5000);
    }
        
    @Test (priority = 3)
     public void logout() throws InterruptedException {
        //10. Logout from the account
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div/div[2]/div[1]/div/div/form/button")).click();
        //verify that the user successfully logged out
        Thread.sleep(5000);
     }



     @Test (priority = 4)
     public void negativeLogin() throws InterruptedException {
         //Click on the Account button
         driver.findElement(By.xpath("//html/body/div[1]/header/section/div/div[2]/div[1]/label")).click();
         Thread.sleep(5000);
         //Click on the sign-in button
         driver.findElement(By.xpath("/html/body/div[1]/header/section/div/div[2]/div[1]/div/div/div/a")).click();
         //Verify that a user can login with incorrect email and password
         //6. Input your email address
         driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/div[1]/div[1]/input")).sendKeys("princenoel@.com");
         //7. Input your password
         driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/div[1]/div[2]/input")).sendKeys("123");
         //8. Click on the login button
         driver.findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/button")).click();
         Thread.sleep(5000);
     }

    @AfterTest
    public void closeBrowser() {
        //11. Quit the browser.
        driver.quit();
    }
}

