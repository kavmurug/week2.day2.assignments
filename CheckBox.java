package week2.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		//setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("http://www.leafground.com/pages/checkbox.html");

		//maximizing window
		driver.manage().window().maximize();

		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//label[contains(text(),'Select the')]/following-sibling::input")).click();

		boolean selected = driver.findElement(By.xpath("//label[contains(text(),'Confirm')]/following-sibling::input")).isSelected();
		System.out.println("Is Selenium selected: "+selected);

		//Deselect only selected
		WebElement element1 = driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input"));
		boolean value1 = element1.isSelected();
		
		WebElement element2 = driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[2]"));
		if(value1==true)
			element1.click();
		else
			element2.click();

		//selecting all checkboxes
		List<WebElement> elements = driver.findElements(By.xpath("//label[contains(text(),'Select all')]/following-sibling::input"));
		int size = elements.size();
		for(int i=0;i<size;i++)
		{
			elements.get(i).click();
		}


	}

}
