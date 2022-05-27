package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeSystem {

	public static void main(String[] args) throws InterruptedException {
		// setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("https://acme-test.uipath.com/login");

		//maximizing window
		driver.manage().window().maximize();

		//Enter the details and Login
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");

		driver.findElement(By.id("password")).sendKeys("leaf@12");

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		//Get the title of the page
		String title = driver.getTitle();
		System.out.println(title);

		//Logout and close the browser
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();

		Thread.sleep(3000);
		driver.close();
	}
}
