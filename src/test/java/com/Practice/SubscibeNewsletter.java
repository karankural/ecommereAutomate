package com.Practice;

import org.openqa.selenium.By;

public class SubscibeNewsletter extends Base{

	public static void main(String[] args) throws InterruptedException {
		new SubscibeNewsletter();
		driver.get("http://automationpractice.com/index.php");
		scrollBy(1200);
		driver.findElement(By.id("newsletter-input")).sendKeys("karan123@mailinator.com");		
		driver.findElement(By.xpath("//button[@name='submitNewsletter']")).click();
		Thread.sleep(2000);
	}

}
