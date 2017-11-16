

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RuleEngine2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "http://localhost/tagg/public/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRuleEngine2() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("lisa@gmail.com");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.linkText("My Organization")).click();
    driver.findElement(By.linkText("Donation Preference")).click();
    driver.findElement(By.name("builder-plugins_rule_0_value_0")).clear();
    driver.findElement(By.name("builder-plugins_rule_0_value_0")).sendKeys("0.01");
    driver.findElement(By.name("builder-plugins_rule_0_value_0")).clear();
    driver.findElement(By.name("builder-plugins_rule_0_value_0")).sendKeys("500");
    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
    driver.findElement(By.xpath("//li[8]/a/span")).click();
    new Select(driver.findElement(By.name("builder-plugins_rule_0_operator"))).selectByVisibleText("greater or equal");
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
    driver.findElement(By.xpath("//body/div[2]/div/ul/li[5]/a/span")).click();
    new Select(driver.findElement(By.name("builder-plugins_rule_1_filter"))).selectByVisibleText("Tax Exempt");
    driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
    driver.findElement(By.xpath("//body/div[2]/div/ul/li/a/span")).click();
    driver.findElement(By.id("builder-plugins_rule_1_value_0_0")).click();
    driver.findElement(By.id("btnSave")).click();
    new Select(driver.findElement(By.id("ddlRuleType"))).selectByVisibleText("Pre-Accept");
    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
    driver.findElement(By.xpath("//div[2]/div/ul/li[6]/a/span")).click();
    new Select(driver.findElement(By.name("builder-plugins_rule_0_operator"))).selectByVisibleText("less or equal");
    driver.findElement(By.name("builder-plugins_rule_0_value_0")).clear();
    driver.findElement(By.name("builder-plugins_rule_0_value_0")).sendKeys("100");
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
    driver.findElement(By.xpath("//div[2]/div/ul/li[3]/a/span")).click();
    new Select(driver.findElement(By.name("builder-plugins_rule_1_filter"))).selectByVisibleText("Requester Name");
    driver.findElement(By.name("builder-plugins_rule_1_value_0")).clear();
    driver.findElement(By.name("builder-plugins_rule_1_value_0")).sendKeys("uno");
    driver.findElement(By.id("btnSave")).click();
    driver.findElement(By.id("btnRun")).click();
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
