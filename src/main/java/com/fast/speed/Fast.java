package com.fast.speed;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fast {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.get("https://fast.com");
		By speedLocator = By.xpath("//div[@id='speed-value']");
		By mbpsLocator = By.id("speed-units");
		//List<WebElement> el = driver.findElements(speedSucceed);
		String className;
		while(true)
		{
			WebElement speed = wait.until(ExpectedConditions.visibilityOfElementLocated(speedLocator));
			WebElement units = wait.until(ExpectedConditions.visibilityOfElementLocated(mbpsLocator));
			System.out.println(speed.getText()+" "+units.getText());
			String ans = speed.getAttribute("class");
			if(ans.contains("succeeded") && ans != null)
			{
				break;
			}
		}
		WebElement speed = wait.until(ExpectedConditions.visibilityOfElementLocated(speedLocator));
		WebElement units = wait.until(ExpectedConditions.visibilityOfElementLocated(mbpsLocator));
		System.out.println("-------Final Speed--------");
		System.out.println(speed.getText()+" "+units.getText());
	}

}
