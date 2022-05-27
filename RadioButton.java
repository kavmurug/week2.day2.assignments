package week2.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		//setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("http://www.leafground.com/pages/radio.html");

		//maximizing window
		driver.manage().window().maximize();

		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement element = driver.findElement(By.xpath("//input[@id='yes']"));
		boolean selected = element.isSelected();
		System.out.println(selected);
		if(selected==false)
		{
			element.click();
		}
		else
			System.out.println("yes is already selected");

		//Finding default selected radio button
		boolean default1 = driver.findElement(By.xpath("//label[text()='Find default selected radio button']/following-sibling::input")).isSelected();
		if(default1==true)
			System.out.println("The default selected radio button is unchecked");
		else
			System.out.println("The default selected radio button is checked");

		//Selecting age group
		List<WebElement> ages = driver.findElementsByXPath("//label[contains(text(),'Select your age group')]/following-sibling::input");
		int size = ages.size();
		int count=0;
		for(int i=0;i<size;i++)
		{
			if(ages.get(i).isSelected())
			{
				count++;
			}
		}
		if(count==0)
		{
			driver.findElement(By.xpath("//label[contains(text(),'Select your age group')]/following-sibling::input[2]")).click();
			System.out.println("age group between 21-40 years is selected");
		}
		else
			System.out.println("age is defaultly selected");
	}

}
