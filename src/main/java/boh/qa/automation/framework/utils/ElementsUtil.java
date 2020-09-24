package boh.qa.automation.framework.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementsUtil {

	WebDriver driver;

	public ElementsUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used for creating a WebElement by taking the input of an By
	 * locator
	 * 
	 * @param locator
	 * @return element
	 */
	public WebElement getElement(By locator) {

		WebElement element = null;
		try {
			System.out.println("Locator is... " + locator);
			element = driver.findElement(locator);
			System.out.println("WebElement created successfully... " + locator);
		} catch (Exception e) {
			System.out.println("Exception occured with locator... " + locator);
			System.out.println(e.getMessage());
		}
		return element;
	}

	/**
	 * This method is used for creating WebElements List by taking the input of an
	 * By locator
	 * 
	 * @param locator
	 * @return elementsList
	 */
	public List<WebElement> getElements(By locator) {
		List<WebElement> elementsList = null;
		try {
			System.out.println("Locator is... " + locator);
			elementsList = driver.findElements(locator);
			System.out.println("WebElement created successfully... " + locator);
		} catch (Exception e) {
			System.out.println("Exception occured with locator... " + locator);
			System.out.println(e.getMessage());
		}

		return elementsList;
	}

	/**
	 * This method is used for typing an input in a text box
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	/**
	 * This method is used for clearing on the supplied By locator
	 * 
	 * @param locator
	 */
	public void doClear(By locator) {
		getElement(locator).clear();
	}

	/**
	 * This method is used for clicking on the supplied By locator
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	/**
	 * This method is used for getting the text/label on the By locator supplied
	 * 
	 * @param locator
	 * @return String
	 */
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	/**
	 * This method is used for finding whether the supplied By locator is visible or
	 * not
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	/**
	 * This method is used to select a value in drop down based on the By locator
	 * and the text to be selected using SelectByvisibleText selenium method
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	/**
	 * This method is used to select a value in drop down based on the By locator
	 * and the index to be selected using SelectByIndex selenium method
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	/**
	 * This method is used to select a value in drop down based on the By locator
	 * and the value to be selected using SelectByValue selenium method
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	/**
	 * This method is used to get the list of options in a drop down as an ArrayList
	 * 
	 * @param locator
	 * @return dropDownOptionsList, ArrayList
	 */
	public ArrayList<String> doGetDropDownOptions(By locator) {
		ArrayList<String> dropDownOptionsList = new ArrayList<String>();

		Select select = new Select(getElement(locator));
		List<WebElement> ddOptionsList = select.getOptions();

		for (int i = 0; i < ddOptionsList.size(); i++) {
			String text = ddOptionsList.get(i).getText();
			dropDownOptionsList.add(text);
		}
		return dropDownOptionsList;
	}

	/**
	 * This method is used for getting the total number of options available in a
	 * drop down
	 * 
	 * @param locator
	 * @return int
	 */

	public int doDropDownOptionsCount(By locator) {
		return doGetDropDownOptions(locator).size();
	}

	/**
	 * This method is used for selecting a value in the drop down without using the
	 * inbuilt selenium select methods
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> dropDownOptionsList = select.getOptions();

		for (int i = 0; i < dropDownOptionsList.size(); i++) {
			String text = dropDownOptionsList.get(i).getText();

			if (text.equals(value)) {
				dropDownOptionsList.get(i).click();
				break;
			}
		}
	}

	/**
	 * This method is used for selecting a value in the drop down without using the
	 * select method
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSelectDropDownValueWithoutSelect(By locator, String Value) {
		List<WebElement> dropDownOptionsList = getElements(locator);

		// System.out.println("Size..." + dropDownOptionsList.size());
		for (int i = 0; i < dropDownOptionsList.size(); i++) {
			String text = dropDownOptionsList.get(i).getText();
			// System.out.println("text..." + text);
			if (text.equals(Value)) {
				dropDownOptionsList.get(i).click();
				break;
			}

		}
	}

	/**
	 * This method is used for selecting values (single, multiple, all) in a drop
	 * down
	 * 
	 * @param ddClickLocator - locator of drop down to click
	 * @param ddListLocator  - locator of the drop down to get the list of options
	 * @param value          - array of values/options to select
	 */
	public void selectingMultipleOptionsInDropDown(By ddClickLocator, By ddListLocator, String... value) {
		getElement(ddClickLocator).click();
		List<WebElement> dropDownOptionsList = getElements(ddListLocator);

		if (!value[0].equalsIgnoreCase("all")) {
			for (int i = 0; i < dropDownOptionsList.size(); i++) {
				String text = dropDownOptionsList.get(i).getText();
				// System.out.println(text);

				for (int j = 0; j < value.length; j++) {
					if (text.equalsIgnoreCase(value[j])) {
						dropDownOptionsList.get(i).click();
						break;
					}
				}

			}

		} else {
			try {
				for (int all = 0; all < dropDownOptionsList.size(); all++) {
					dropDownOptionsList.get(all).click();
				}
			} catch (Exception e) {

			}

		}

	}

	/**
	 * This method is used when selecting a value in the drop down when the drop
	 * down element does not have select tag
	 * 
	 * @param ddClickLocator - locator of the drop down to click
	 * @param ddListLocator  - locator of the drop down to get the list of options
	 * @param value
	 */
	public void selectAnOptionInDropDown(By ddClickLocator, By ddListLocator, String value) {
		getElement(ddClickLocator).click();
		List<WebElement> dropDownOptionsList = getElements(ddListLocator);

		System.out.println("Size..." + dropDownOptionsList.size());
		
		for (int i = 0; i < dropDownOptionsList.size(); i++) {
			String text = dropDownOptionsList.get(i).getText();
			System.out.println("text..."+ i + "..." + text);
			
			if (!text.isEmpty() && text.equalsIgnoreCase(value)) {
				dropDownOptionsList.get(i).click();
				break;
			}
		}
	}

	// ********* Actions Class Element Utils ************************
	/***
	 * This method is used for dragging and dropping an element
	 * 
	 * @param srcLocator
	 * @param tgtLocator
	 */
	public void doDragAndDrop(By srcLocator, By tgtLocator) {

		Actions actions = new Actions(driver);
		actions.dragAndDrop(getElement(srcLocator), getElement(tgtLocator)).build().perform();

		// don't forget to do build & perform for any actions you do.
		// below is the code for drag and drop without using the inbuilt dragAndDrop
		// method
		// actions.clickAndHold(getElement(srcLocator)).moveToElement(getElement(tgtLocator)).release().build().perform();

	}

	public void doMoveElement(ArrayList<By> locatorsList) {
		System.out.println(locatorsList.size());

		Actions actions = new Actions(driver);
		actions.moveToElement(getElement(locatorsList.get(0))).build().perform();

		for (int i = 1; i < locatorsList.size(); i++) {
			System.out.println(locatorsList.get(i));
			getElement(locatorsList.get(i)).click();
		}
	}

	public void doSendKeyUsingActions(By locator, String Value) {
		Actions actions = new Actions(driver);
		actions.sendKeys(getElement(locator), Value).perform();
	}
	//*******************************

}
