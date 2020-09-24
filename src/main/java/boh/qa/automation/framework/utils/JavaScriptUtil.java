package boh.qa.automation.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	WebDriver driver;
	ElementsUtil elementsUtil;
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
	}
	
//	public void clickElementByJS(WebElement element) {
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].click();", element);
//
//	}

	public void clickElementByJS(By locator) {
		elementsUtil = new ElementsUtil(driver);
		WebElement element = elementsUtil.getElement(locator);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public void sendKeysUsingJSWithID(String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}
	
}
