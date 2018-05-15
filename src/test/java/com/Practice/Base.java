package com.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Base {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor scripts;
	protected static SoftAssert sAssert; 
	
	public Base() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		scripts = (JavascriptExecutor) driver;
		sAssert = new SoftAssert();
	}
	
	/**
	 * Login method
	 * @param username
	 * @param password
	 * @throws InterruptedException
	 */
	public static void login(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='login']")).click();
		WebElement element = driver.findElement(By.xpath("//form[@class='box']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		scrollBy(300);
		Thread.sleep(500);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(500);
		scrollBy(-200);
		driver.findElement(By.xpath("//a/img[@alt='My Store']")).click();
	}
	
	/**
	 * Scroll by function to scroll by given pixels.
	 * @param pixels
	 */
	public static void scrollBy(int pixels) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, "+pixels+")", "");	
	}
}
