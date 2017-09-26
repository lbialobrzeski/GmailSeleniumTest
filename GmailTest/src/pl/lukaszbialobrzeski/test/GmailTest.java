package pl.lukaszbialobrzeski.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailTest {
	

		
	public String baseUrl = "http://gmail.com";
	String driverPath = "geckodriver.exe";
	public WebDriver driver;
	public WebDriverWait myWaitVar;

	@BeforeTest
	public void launchBrowser(){
	System.setProperty("webdriver.firefox.geckodriver", driverPath);
	driver = new FirefoxDriver();
	driver.get(baseUrl);
	myWaitVar = new WebDriverWait(driver, 30);
	}

	  
	@Test(priority = 0)
	  public void weryfikacjaStrony() {
		  String expectedTitle = "Gmail";
		  String actualTitle = driver.getTitle();
		  Assert.assertEquals(actualTitle, expectedTitle);
	  }

	@Test(priority = 1)
	public void loginGmail() {
		//wpisanie loginu i klikniêcie dalej
		driver.findElement(By.id("identifierId")).sendKeys("jan153678@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
	}

	@Test(priority = 2)
	public void passwordGmail() {
		//wpisanie has³a i klikniêcie dalej
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("Test123456789");
		driver.findElement(By.id("passwordNext")).click();
	}

	@Test(priority = 3)
	public void clickCreateMessageGmail() {
		//klikniêcie utwórz
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id(":ig")));
		driver.findElement(By.xpath("//div[@id=':i6']/div/div")).click();
	}

	@Test(priority = 4)
	public void writeAdressGmail() {
		//wpisanie adresu email na który ma byæ wys³ana wiadomoœæ
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id(":oj")));
		driver.findElement(By.id(":nz")).sendKeys("lbialobrzeski1@gmail.com");
	}

	@Test(priority = 5)
	public void writeThemeGmail() {
		//wpisanie tematu wiadomoœci
		driver.findElement(By.id(":ni")).sendKeys("Test message");
	}

	@Test(priority = 6)
	public void writeMessageGmail() {
		//wpisanie treœci wiadomoœci
		driver.findElement(By.id(":oj")).sendKeys("Test message");
	}

	@Test(priority = 7)
	public void sendMessageGmail() {
		//wys³anie wiadomoœci
		driver.findElement(By.id(":n8")).click();
	}

	@Test(priority = 8)
	public void refreshGmail() {
		//oœwie¿enie strony
		driver.navigate().refresh();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
	}
