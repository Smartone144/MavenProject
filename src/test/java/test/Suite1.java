package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Suite1 {

	@Test (priority=1)
	public void register() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://magento.com/");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("Fakhar");
		driver.findElement(By.id("lastname")).sendKeys("muzzammil");
		driver.findElement(By.id("email_address")).sendKeys("fakhar144@gmail.com");
		
		
		Select cp = new Select(driver.findElement(By.id("company_type")));
		cp.selectByIndex(3);
		//cp.selectByValue("developmment");
		//cp.deselectByVisibleText("Provides deployment, customization and integtration to merchants");
		
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("India");
		
		
		driver.findElement(By.id("password")).sendKeys("Welcome@123");
		driver.findElement(By.id("password-confirmation")).sendKeys("Welcome@123");
	
		
		
		if(!driver.findElement(By.id("agree_terms")).isSelected())
		{
			driver.findElement(By.id("agree_terms")).click();
		}
		driver.quit();
		
	}


	@Test (priority=2,enabled=false)
	public static void login() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://magento.com");
		
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		
		driver.findElement(By.id("email")).sendKeys("fakhar144@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Welcome123");
		
		driver.findElement(By.id("send2")).click();
		
		Thread.sleep(5000);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText());
		
		
		driver.quit();
	}
	
	}

