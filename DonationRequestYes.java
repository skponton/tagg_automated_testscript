

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DonationRequestYes {
  
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "http://localhost/tagg/public/";
    ChromeOptions options = new ChromeOptions();
	options.addArguments("disable-infobars");
	driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testExport() throws Exception {
	
    driver.get(baseUrl);
    driver.findElement(By.linkText("RequestDonation")).click();
    driver.findElement(By.id("requester")).clear();
    driver.findElement(By.id("requester")).sendKeys("University Of Nebraska Omaha");
    new Select(driver.findElement(By.name("requester_type"))).selectByVisibleText("Education K-12");
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Punyasha");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Roul");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("Punyasha.pradhan@gmail.com");
    driver.findElement(By.id("phonenumber")).clear();
    driver.findElement(By.id("phonenumber")).sendKeys("hagsduahsgdjh");
    driver.findElement(By.id("address1")).clear();
    driver.findElement(By.id("address1")).sendKeys("1305 North St");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("Omaha");
    new Select(driver.findElement(By.name("state"))).selectByVisibleText("Nebraska");
    driver.findElement(By.id("zipcode")).clear();
    driver.findElement(By.id("zipcode")).sendKeys("68154");
    
    driver.findElement(By.id("yesCheck")).click();
    driver.findElement(By.name("attachment")).clear();
    driver.findElement(By.name("attachment")).sendKeys("C:\\Users\\Punyasha\\Desktop\\MIS\\Fall 2017\\layout.txt");
    new Select(driver.findElement(By.name("item_requested"))).selectByVisibleText("Cash/Check");
    driver.findElement(By.id("dollar_amount")).clear();
    driver.findElement(By.id("dollar_amount")).sendKeys("500.00");
    new Select(driver.findElement(By.name("item_purpose"))).selectByVisibleText("Online Auction");
    //driver.findElement(By.id("datepicker")).click();
    //driver.findElement(By.id("needed_by_date")).clear();
    //driver.findElement(By.id("needed_by_date")).sendKeys("10/18/2017");
    driver.findElement(By.id("eventname")).clear();
    driver.findElement(By.id("eventname")).sendKeys("Auction");
    //driver.findElement(By.id("startdate")).clear();
    //driver.findElement(By.id("startdate")).sendKeys("10/01/2017");
    //driver.findElement(By.id("enddate")).clear();
    //driver.findElement(By.id("enddate")).sendKeys("10/10/2017");
    new Select(driver.findElement(By.name("event_type"))).selectByVisibleText("Fundraiser/Gala");
    driver.findElement(By.id("formAttendees")).clear();
    driver.findElement(By.id("formAttendees")).sendKeys("34");
    driver.findElement(By.id("venue")).clear();
    driver.findElement(By.id("venue")).sendKeys("301 N Omaha");
    driver.findElement(By.id("marketingopportunities")).clear();
    driver.findElement(By.id("marketingopportunities")).sendKeys("The marketing opportunities are really good !");
    driver.findElement(By.cssSelector("#attachment > div:nth-child(28) > div > button")).click();
    //Alert alert = driver.switchTo().alert();
    //alert.getText();
    String msg_in_alert=driver.switchTo().alert().getText();
    Assert.assertEquals("Please match the requested format. Enter your 10 digit Phone Number", msg_in_alert);
    System.out.println(msg_in_alert);
    
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
