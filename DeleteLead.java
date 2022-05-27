package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		//maximizing window
		driver.manage().window().maximize();

		//Enter Username and password and click login button
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		//Click on the CRM/SFA link
		driver.findElementByLinkText("CRM/SFA").click();

		//Click on Leads & find Lead button
		driver.findElementByLinkText("Leads").click();

		driver.findElementByLinkText("Find Leads").click();

		driver.findElement(By.xpath("//span[@class='x-tab-strip-text 'and text()='Phone']")).click();

		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876543201");

		driver.findElement(By.xpath("//button[@class='x-btn-text 'or text()='Find Leads']")).click();

		//Capturing and clicking first resulting lead
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String attribute = element.getText();
		System.out.println(attribute);
		element.click();

		//Deleting the first resulting lead
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		driver.findElementByLinkText("Find Leads").click();

		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(attribute);

		driver.findElement(By.xpath("//button[@class='x-btn-text 'or text()='Find Leads']")).click();
        Thread.sleep(1000);
		boolean record = driver.findElement(By.xpath("//div[contains(text(),'No records')]")).isDisplayed();
		System.out.println(record);
		if(record==true)
			System.out.println("No records to display");

		driver.close();

	}

}
