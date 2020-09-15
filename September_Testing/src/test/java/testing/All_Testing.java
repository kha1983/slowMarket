package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class All_Testing {

	/// Automate the following test case:
	// Scenario: CRM -> Add Contact - Add contact and validate contact added in List
	/// Contacts
	// 1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
	// 2. Enter username: techfiosdemo@gmail.com
	// 3. Enter password: abc123
	// 4. Click login button
	// 5. Click on CRM in the Side Navigation
	// 6. Click on Add Contact
	// 7. Fill in the Add Contact Form,
	// 8. Click submit,
	// 9. Go to CRM -> List Contact Page
	// 10. Search for the new contact in the search field,
	// 12. Validate contact created.

	WebDriver driver;

	@BeforeMethod
	public void UserWillAbleToOpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test(priority = 1)
	public void UserWillAbleToLoginPage() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);

		// Validation of dashboard page is displayed
//		boolean status=driver.findElement(By.linkText("Dashboard ")).isDisplayed();
//		if(status==true)           {
//			System.out.println("The dashboard page exixts and testing is passed");
//		}
//		else     {
//			System.out.println("Keep trying again");
//		}

		String expectedTitle = "Dashboard ";
		String actualTitle = driver.getTitle();
		System.out.println("Your assert starts here");

		try {
			Assert.assertEquals(actualTitle, expectedTitle);
		} catch (Throwable e) {
			System.out.println("YOur assert is finished");

		}

	}

	@Test(priority = 2)
	public void UserWillBeAbleToAddTheContact() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("CRM")).click();
		driver.findElement(By.linkText("Add Contact")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Add Contact')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("account")).sendKeys("Khadak Kathayat");
		driver.findElement(By.name("company")).sendKeys("Techfios");
		driver.findElement(By.name("email")).sendKeys("khadak.kathayat100@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9722158094");
		driver.findElement(By.name("address")).sendKeys("Irving, Texas");
		driver.findElement(By.id("city")).sendKeys("Irving");
		driver.findElement(By.name("state")).sendKeys("Texas");
		driver.findElement(By.id("zip")).sendKeys("75038");
		Thread.sleep(2000);
		driver.findElement(By.className("select2-search__field")).sendKeys("It is bad time going on");
		driver.findElement(By.id("submit")).click();
	}
	
	@Test(priority=3)
	public void UserWillBeAbleToValidateAddTheContact() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("CRM")).click();
		driver.findElement(By.linkText("List Contacts")).click();
		
		boolean status=driver.findElement(By.linkText("Khadak Kathayat")).isDisplayed();
		if(status==true)           {
			System.out.println("The testing is passed");
		}
		else            {
			System.out.println("The testing is failed");
		}
	
	}
	@AfterMethod
	public void UserWillAbleToCloseTheBrowser() {
		driver.close();
		driver.quit();
	}

}
