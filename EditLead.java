package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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

		WebElement Element = driver.findElement(By.xpath("(//input[@name='firstName'])[3]"));
		Element.click();
		Element.sendKeys("kaviya");

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();

		//Get the title of the resulting Page
		String title = driver.getTitle();
		System.out.println(title);

		//Edit Company name and update
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();

		driver.findElement(By.id("updateLeadForm_companyName")).clear();

		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf");

		driver.findElement(By.className("smallSubmit")).click();

		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(text);
		if(text.contains("TestLeaf"))
		{
			System.out.println("Company name is changed to "+text);
		}

		//Close the browser
		driver.close();


	}

}
