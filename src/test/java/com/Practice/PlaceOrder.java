package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaceOrder extends Base{
		
	public static void main(String[] args) throws Exception {
		new PlaceOrder();
		driver.get("http://automationpractice.com/index.php");
		Base.login("karan123@mailinator.com", "qwe123");
		addProductToCart();
		checkout();
		Thread.sleep(2000);
		driver.quit();
	}
	
	/**
	 * Add to products Method
	 * @throws Exception
	 */
	public static void addProductToCart() throws Exception{
		scrollBy(750);
		WebElement product = driver.findElement(By.xpath("//ul[@id='homefeatured']//img[@title='Blouse']"));
		Actions action = new Actions(driver);
		action.moveToElement(product).build().perform();
		action.click(driver.findElement(
				By.xpath("//img[@title='Blouse']//ancestor::ul[@id='homefeatured']//li[2]//a[@title='Add to cart']/span")))
		.build().perform();
		 scripts.executeScript("return !!window.jQuery && window.jQuery.active == 0");
		 //http://automationpractice.com/index.phpdriver.switchTo().alert();
		 scrollBy(100);
		 Thread.sleep(100);
		 WebElement addToCart = driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']/span"));
		 wait.until(ExpectedConditions.visibilityOf(addToCart));
		addToCart.click();
	}
	
	/**
	 * Checkout method
	 */
	public static void checkout() {
		scrollBy(700);
		driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/a")).click();
		scrollBy(700);
		driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']//span/i")).click();
		scrollBy(400);
		driver.findElement(By.xpath("//div[@class='checker']//input")).click();
		driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']//span/i")).click();
		scrollBy(500);
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		scrollBy(700);
		driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']//span/i")).click();	
	}
	
	
}
