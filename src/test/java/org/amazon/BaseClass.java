package org.amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	public static WebDriver driver;
	// Browser Initialisation

	public static void initiateBrowser(String browser) {

		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		default:
			System.out.println("Browser not initialized");
			break;
		}
	}
	// .......................GetUrl.................................

	public static void getUrl(String urlname) {
		driver.get(urlname);
	}
	// ....................getAttribute send keys
	// Value...................................
	//===========SendKeys======================
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	} 

	public static void getTextAtrribute(WebElement element) {

		String attribute = element.getAttribute("Value");
		System.out.println(attribute);
	}

	// ..................getTextValue...................................................
	public static void getTextValue(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}
	//====================Click Method========================================
	public static void buttonClick(WebElement element) {
		element.click();
	}

	// ..................select....................................
	public static void selectBasedOnIndexValue(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static void selectBasedOnValue(WebElement element, String value) {

		Select s = new Select(element);
		s.selectByValue(value);

	}

	public static void selectBasedOnVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	// ...............selectAllOption..........................
	public static void selectAllOption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();

		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
	}

	// .....................GetAllOptionFromDropDown.................................

	public static void getAllOptionFromDropDown(WebElement element) {

		Select s = new Select(element);
		List<WebElement> options = s.getOptions();

		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
	}
	// ....................Get DeSelected Options From Drop
	// Down................................

	public static void getselectedOptionFromDropDown(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();

		for (int i = 0; i < allSelectedOptions.size(); i++) {
			WebElement webElement = allSelectedOptions.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}

	}
	// ...........................De-select.....................

	public static void deselectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}

	public static void deselectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	public static void deselectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}

	// .........................Alert...................................

	// SimpleAlert
	public static void simpleAlert() {
		Alert simplealert = driver.switchTo().alert();
		simplealert.accept();
	}

	// Confirm and Cancel Alert

	public static void confirmAlert(String acceptOrDimiss) {
		Alert confirmAlert = driver.switchTo().alert();
		if (acceptOrDimiss.equalsIgnoreCase("Accept")) {
			confirmAlert.accept();
		}

		else if (acceptOrDimiss.equalsIgnoreCase("Dismiss")) {
			confirmAlert.dismiss();

		}
	}

	// Text Prompt Alert
	public static void textAlert(String commenttext, String acceptorDismiss) {

		Alert textAlert = driver.switchTo().alert();
		if (acceptorDismiss.equalsIgnoreCase("Accept")) {
			textAlert.accept();
		} else if (acceptorDismiss.equalsIgnoreCase("Dismiss")) {
			textAlert.dismiss();
		}
	}
	// ============Action=====================================

	// ================MouseHover===============================

	public static void movetoElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	// ===================Drag and Drop==============================

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
	}

	// ==================Right Click==================================
	public static void rightClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}
	// =================== Double Click===============================

	public static void doubleClick(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}

	// =====================TakesScreenShot============================
	public static void takesScreenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("D:\\ScreenShot\\" + name + ".jpeg");
		FileUtils.copyFile(source, target);
	}
	// =======================JavaScript SendKeys===================================

	public static void javaScriptSetAttribute(WebElement element, String textValue) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + textValue + "')", element);
	}

	// =======================JavaScript getSendKeys
	// Value===================================

	public static void javaScriptGetSendKeyValue(WebElement element, String textValue) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value','" + textValue + "')", element);
	}

	// =========================JavaScript Click=================================
	public static void javaScriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	// =========================ScrollUp and
	// ScrollDown===============================
	public static void javaScriptScrollUpandDown(WebElement element, boolean trueorfalse) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(" + trueorfalse + ")", element);

	}

	// ==============================Frames===============================================
	// SwitchToFrame
	public static void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	// Switch Back to Parent Frame
	public static void switchToParentframe(WebElement element) {
		driver.switchTo().parentFrame();
	}

	// Switch Back to Default frame
	public static void switchBackToDefaultFrame(WebElement element) {
		driver.switchTo().defaultContent();
	}
	//==============================windowsHandling=============================
	public static void mainWindowId() {
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		driver.switchTo().window(mainWindow);
	}
	//=========(for Only 2 window)=============================
	public static void allWindowId() {
		String mainWindow = driver.getWindowHandle();
		System.out.println("Main WindowId : "+mainWindow);
		Set<String> allwindowHandles = driver.getWindowHandles();
		System.out.println("All WindowId : "+allwindowHandles);
		for (String x : allwindowHandles) {
			if(!mainWindow.equals(x)) {
				driver.switchTo().window(x);
			}
		}

	}

	//=====================SwitchingToParentWindow=======================
	public static void switchToParentWindow(String mainWindow) {
		driver.switchTo().window(mainWindow);
	}
	
	//==========================switch to multipleWindow==================
	
	public static void switchtoChildWindowForMultiWindow(int SwitchWindowIndex) {

		Set<String> allwindowHandles = driver.getWindowHandles();

		List<String> li = new LinkedList<>();

		li.addAll(allwindowHandles);
		String windowHandles = li.get(SwitchWindowIndex);
		driver.switchTo().window(windowHandles);
	}
	// ----------------------Navigation-------------------------

		public static void navigateTo(String url) {

			driver.navigate().to(url);
		}

		public static void navigateBack() {
			driver.navigate().back();

		}

		public static void navigateForward() {
			driver.navigate().forward();

		}

		public void navigateRefresh() {
			driver.navigate().refresh();

		}

		// ------------------------wait---------------------------

		public static void implicitlyWait(int seconds) {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		}

		// --------------------Data Driven----------------------------

		public static String readExcelData(int rowN, int cellN) {

			String value = null;

			try {

				File file = new File("D:\\Book1.xlsx");
				FileInputStream stream = new FileInputStream(file);

				Workbook book = new XSSFWorkbook(stream);
				Sheet sheet = book.getSheet("Sheet1");
				Row row = sheet.getRow(rowN);
				Cell cell = row.getCell(cellN);

				CellType cellType = cell.getCellType();

				switch (cellType) {
				case STRING:

					value = cell.getStringCellValue();

					break;

				default:

					if (DateUtil.isCellDateFormatted(cell)) {

						Date dateCellValue = cell.getDateCellValue();

						SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");

						value = simple.format(dateCellValue);

					} else {

						double numericCellValue = cell.getNumericCellValue();
						long l = (long) numericCellValue;
						BigDecimal valueOf = BigDecimal.valueOf(l);
						value = valueOf.toString();

					}

					break;
				}

			} catch (Exception e) {
				
			}

			return value;

		}

	}



