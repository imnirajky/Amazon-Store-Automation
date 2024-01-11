package apTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
///
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {
    RemoteWebDriver driver;

    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);


        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.amazon.in/");

        String title=driver.getTitle();
        if(driver.getCurrentUrl().contains("amazon")){
        System.out.println("the URL contain the expected title amazon");
        }
        System.out.println("the title of the page is"+title);

        System.out.println("end Test case: testCase01");
    }

    public void testCase02(String Laptop) throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        WebElement searchBar;
        searchBar=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBar.sendKeys("laptop");
        Thread.sleep(3000);
    
        driver.findElement(By.id("nav-search-submit-button")).click(); 
        Thread.sleep(2000);
     WebElement desc=driver.findElement(By.className("a-size-medium"));
       String lap=desc.getText();
       if(lap.contains("Laptop")){
        System.out.println("Product description contains the laptop");
       }
       
       System.out.println("End Test case : testCase02");
           
    }

    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        Thread.sleep(2000);
        WebElement NavigationMenu=driver.findElement(By.xpath("//*[@id='nav-xshop']/a[8]"));
        ////*[@id="nav-xshop"]/a[8]
        
        NavigationMenu.click();
        Thread.sleep(2000);
       if(driver.getCurrentUrl().contains("electronics")){
            System.out.println("URL contain the expected title");
         }
         Thread.sleep(2000);
        
         System.out.println("End Test case: testCase03");

    }

}