package genericUtility;

import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	

	// Launch Browser


	// Implicit Wait
	public void genericWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	// Explicit Wait - Visibility
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Explicit Wait - Clickable
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Enter value into disabled element
	public void enterValueUsingJS(WebDriver driver, WebElement element, String value) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value='" + value + "';", element);
	}

	// Click disabled element
	public void clickUsingJS(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);
	}

	// Scroll to element
	public void scrollToElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Scroll by x and y coordinates
	public void scrollBy(WebDriver driver, int x, int y) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(" + x + "," + y + ");");
	}

	// Right Click
	public void rightClick(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);

		actions.contextClick(element).perform();
	}

	// Drag and Drop by Offset
	public void dragAndDrop(WebDriver driver, WebElement element, int x, int y) {

		Actions actions = new Actions(driver);

		actions.clickAndHold(element).moveByOffset(x, y).release().build().perform();
	}

	// Scroll using Actions class
	public void scrollUsingActions(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);

		actions.scrollToElement(element).perform();
	}

	// Handle Multiple Windows
	public void switchToWindow(WebDriver driver, String expectedWindowTitle) {

		Set<String> windows = driver.getWindowHandles();

		for (String win : windows) {

			driver.switchTo().window(win);

			System.out.println("Title : " + driver.getTitle());

			if (driver.getTitle().contains(expectedWindowTitle)) {
				break;
			}
		}
	}

	public void switchToTabOnURL(WebDriver driver, String partialURL) {

	    Set<String> set = driver.getWindowHandles();
	    Iterator<String> it = set.iterator();

	    while (it.hasNext()) {

	        String windowID = it.next();

	        driver.switchTo().window(windowID);

	        String actURL = driver.getCurrentUrl();

	        if (actURL.contains(partialURL)) {
	            break;
	        }
	    }
	}

	// Switch Frame using ID
	public void switchToFrame(WebDriver driver, String id) {

		driver.switchTo().frame(id);
	}

	// Switch Frame using Name
	public void switchToFrame(String name, WebDriver driver) {

		driver.switchTo().frame(name);
	}

	// Switch Frame using WebElement
	public void switchToFrame(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);
	}

	// Switch Frame using Index
	public void switchToFrame(WebDriver driver, int index) {

		driver.switchTo().frame(index);
	}

	// Switch back to Parent Frame
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	// Switch back to Main Page
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * Takes screenshot and saves it at the given path
	 */
	public void takeScreenshot(WebDriver driver, String filePath) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File(filePath);

		FileHandler.copy(src, dest);
	}

	/*
	 * Using Select class
	 * 
	 */
	// Select dropdown by visible text
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// Select dropdown by value
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// Select dropdown by index
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// Get selected option
	public String getSelectedOption(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	// Get all selected options
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions();
	}

	// Get all options
	public List<WebElement> getAllOptions(WebElement element) {
		Select select = new Select(element);
		return select.getOptions();
	}

	// Check whether dropdown supports multiple selection
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}

	// Deselect by visible text
	public void deselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// Deselect by value
	public void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	// Deselect by index
	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// Deselect all options
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public void switchToAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}
}