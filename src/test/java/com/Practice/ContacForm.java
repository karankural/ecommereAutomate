package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContacForm extends Base{
	
	public static void main(String[] ar) throws InterruptedException {
		new ContacForm();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//div[@id='contact-link']/a")).click();
		scrollBy(600);
		WebElement selectDropdown = driver.findElement(By.id("id_contact"));
		Select se = new Select(selectDropdown);
		se.selectByVisibleText("Customer service");
		driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Testing prospective");
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='submit']/button")).click();
		Thread.sleep(500);
		String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']//li")).getText();
		sAssert.assertEquals(errorMessage, "Invalid email address.");
		Thread.sleep(2000);
		driver.quit();
	}
}
