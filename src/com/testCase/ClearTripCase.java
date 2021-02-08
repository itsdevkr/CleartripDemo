package com.testCase;

import java.io.IOException;
import java.sql.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.pages.ExcelReadPage;
import com.utilities.WrapperClass;

public class ClearTripCase extends WrapperClass {
	String sheetName = "clearTrip";

	@Test
	public void test() throws IOException, InterruptedException {
		// calling browser and opening website....................................
		
		launchBrowser("chrome", "https://www.cleartrip.com/flights");
        // selectong rpundTrip....................................................
		
		driver.findElement(By.xpath("//nav/ul/li[2]/label/input[@id='RoundTrip']")).click();
       //getting FROM city value from excel.......................................
		
		ExcelReadPage erp = new ExcelReadPage();
		String from = erp.getCellValue(sheetName, 0, 0);
		WebElement fromElement = driver.findElement(By.xpath("//input[@id='FromTag']"));
		fromElement.sendKeys(from);
		Thread.sleep(3000);
		fromElement.sendKeys(Keys.ENTER);
		
		//getting TO city value from excel..........................................
		
		String to = erp.getCellValue(sheetName, 0, 1);
		WebElement toElement = driver.findElement(By.xpath("//input[@id='ToTag']"));
		toElement.sendKeys(to);
		Thread.sleep(4000);
		toElement.sendKeys(Keys.ENTER);
		
		//selecting depart date......................................................

		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[5]")).click();
		Thread.sleep(2000);
		
		//selecting return Date......................................................
		
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[5]")).click();

		//selecting  adults as 2 ............................................................
		
		Select select = new Select(driver.findElement(By.id("Adults")));
		select.selectByValue("2");
		
		//clicking on search button.......................................................

		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		Thread.sleep(4000);
		
		//taking screenshot after getting the search results..................................

		screenshot();
		
		//closing browser......................................................................
		
		driver.close();

	}

}
