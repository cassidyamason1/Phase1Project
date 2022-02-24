package projectPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement textBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		WebElement submit = driver.findElement(By.xpath("//input[contains(@id,'submit-button')]"));
		textBox.sendKeys("iPhone 12");
		submit.click();
		
		
		List<WebElement> iphones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<WebElement> fraction = driver.findElements(By.xpath("//span[@class='a-price-fraction']"));
		
		
		System.out.println("Search Results: " +iphones.size());
		
		for (int i =0; i<iphones.size(); i++) {
			System.out.println("Phone name: " + iphones.get(i).getText()+ ", Price: $" +price.get(i).getText() +"."+fraction.get(i).getText());
		}
		
		
		driver.close();
		

	}

}
