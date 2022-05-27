package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) throws InterruptedException {
		//setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("http://www.leafground.com/pages/Image.html");

		//maximizing window
		driver.manage().window().maximize();

		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//label[contains(text(),'Click on this image')]/following-sibling::img")).click();

		driver.findElement(By.xpath("//h5[text()='Image']/following-sibling::img[contains(@class,'svg-image')]")).click();

		String broken = driver.findElement(By.xpath("//label[contains(text(),'Am I')]/following-sibling::img")).getAttribute("src");
		System.out.println(broken);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Click me')]/following-sibling::img")).click();
	}

}
