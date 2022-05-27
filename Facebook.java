package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		//setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("https://en-gb.facebook.com/");

		//maximizing window
		driver.manage().window().maximize();

		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Click on create new account button
		driver.findElement(By.xpath("(//input[@name='login_source']/following::a)[2]")).click();

		//enter the details
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Kaviya");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("M");
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9876543210");
		
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Kaiya@123");
		
		WebElement days = driver.findElement(By.xpath("//select[@id='day']"));
		Select days1=new Select(days);
		days1.selectByValue("18");
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select month1=new Select(month);
		month1.selectByIndex(2);
		
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select year1=new Select(year);
		year1.selectByVisibleText("1993");

		WebElement var = driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input"));
		var.click();
		System.out.println("Female radio button is selected:" +var.isSelected());

	}

}
