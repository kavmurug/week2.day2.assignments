package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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

		driver.findElement(By.xpath("//span[@class='x-tab-strip-text ' and text()='Email']")).click();

		driver.findElement(By.xpath("//input[contains(@name,'emailAddress')]")).sendKeys("kaviya@domain.com");

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(1000);
		String name = driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a")).getText();
		System.out.println(name);

		//Capturing and clicking first resulting lead
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		element.click();

		//Duplicating Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();

		String text = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		System.out.println(text);

		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		String text2 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(name.equals(text2))
			System.out.println("duplicate lead name is same as captured lead name");

		driver.close();

	}

}
