package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		//maximizing window
		driver.manage().window().maximize();

		//Enter username and password and click login button
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();

		//Navigate to Create Contacts and enter the details
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.linkText("Create Contact")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("Kaviya");
		
		driver.findElement(By.id("lastNameField")).sendKeys("M");
		
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("KAVIYA");
		
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("MURUGESAN");
		
		driver.findElement(By.name("departmentName")).sendKeys("QA/Analyst");
		
		driver.findElement(By.id("createContactForm_description")).sendKeys("3 years of experience");
		
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("kaviya@domain.com");
		
		WebElement state = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select obj=new Select(state);
		obj.selectByVisibleText("New York");

		//Click on create button
		driver.findElement(By.name("submitButton")).click();

		//Edit the details
		driver.findElement(By.xpath("//a[text()='Deactivate Contact']/preceding-sibling::a")).click();
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("manual testing");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

		//Get the title of the resulting Page
		String title = driver.getTitle();
		System.out.println(title);

	}

}
