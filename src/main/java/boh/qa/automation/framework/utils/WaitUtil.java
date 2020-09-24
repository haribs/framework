package boh.qa.automation.framework.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	WebDriver driver;
	
	public WaitUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElementToBeVisible(By locator, int waitTime) {
		ElementsUtil elementUtil = new ElementsUtil(driver);
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elementUtil.getElement(locator)));
		return element;
	}
	
	public WebElement waitForElementToBePresent(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}
	
	public WebElement waitForElementToBeClickable(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	public void waitForElementAndClick(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public List<WebElement> waitForAllElementsToBeAvailable(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}
	
	public void staticWait(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
