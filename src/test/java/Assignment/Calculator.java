package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calculator {
	WebDriver driver;
	@BeforeTest
	public void login() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		driver.manage().window().maximize();
		
	}
	@Test(priority=0)
	public void fillingForm() {
		driver.findElement(By.xpath("//label[contains(text(),'Single')]")).click();
		WebElement dependantsdropdown=driver.findElement(By.xpath("//select[@title='Number of dependants']"));
		Select select = new Select(dependantsdropdown);
		select.selectByVisibleText("0");
		driver.findElement(By.xpath("//label[@for='borrow_type_home']")).click();
		driver.findElement(By.xpath("//input[@aria-describedby='q2q1i1 q2q1i2']")).sendKeys("80,000");
		driver.findElement(By.xpath("//input[@aria-labelledby='q2q2']")).sendKeys("10,000");
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).sendKeys("500");
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q2']")).sendKeys("0");
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q3']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q4']")).sendKeys("0");
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q5']")).sendKeys("10,000");
		driver.findElement(By.id("btnBorrowCalculater")).click();
		
		}
	@Test(priority=1)
	public void startOver() {
		driver.findElement(By.xpath("(//button[@aria-label='Start over'])[1]")).click();
	}
	@Test(priority=2)
	public void verifying() {
		driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).sendKeys("1");
		driver.findElement(By.id("btnBorrowCalculater")).click();
		
		
	}
	

}
