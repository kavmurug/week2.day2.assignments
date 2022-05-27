package week2.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyperlinks {

	public static void main(String[] args) throws InterruptedException {
		//setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("http://www.leafground.com/pages/Link.html");

		//maximizing window
		driver.manage().window().maximize();

		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Go to Home page
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.linkText("HyperLink")).click();

		//Find where i am supposed to go 
		String page = driver.findElement(By.xpath("//a[contains(text(),'Find where am')]")).getAttribute("href");
		System.out.println(page);

		//verify am i broken
		String broken = driver.findElement(By.xpath("//a[contains(text(),'Verify am')]")).getAttribute("href");
		System.out.println(broken);

		//Interact with same link
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Interact with')]/preceding-sibling::a")).click();
		driver.findElement(By.linkText("HyperLink")).click();

		//How many links are available in the page
		driver.findElement(By.xpath("//a[contains(text(),'How many links')]")).click();
		List<WebElement> nooflinks = driver.findElements(By.xpath("//div/a"));
		System.out.println("No of links in the page is "+nooflinks.size());


	}

}
