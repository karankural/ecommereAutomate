package com.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchCriteria extends Base{
	
	public static void main(String[] arg) {
		new SearchCriteria();
		driver.get("http://automationpractice.com/index.php");
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='search_query form-control ac_input']")); 
		searchBox.sendKeys("printed");
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		WebElement dropdown = driver.findElement(By.id("selectProductSort"));
		Select se = new Select(dropdown);
		se.selectByVisibleText("Price: Lowest first");
		List<WebElement> price = driver.findElements(By.xpath("//div[@class=\"right-block\"]//span[@class=\"price product-price\"]"));	
		List<String> newPrices = new ArrayList<String>();
		for(WebElement e : price) {
			System.out.println("get price -> "+e.getText());
			newPrices.add(e.getText());
		}
		System.out.println(sorting(newPrices));			
	}
	
	public static boolean sorting(List<String> list) {
		List<String> fetchedPrice = list;
		List<String> sortedPrices = new ArrayList<String>(fetchedPrice);
		Collections.sort(sortedPrices);
		for(String price1 : sortedPrices) {
			System.out.println("sorted price -> "+price1);
		}
		return sortedPrices.equals(fetchedPrice);
	}
}
