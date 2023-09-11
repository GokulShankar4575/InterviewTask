package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;

	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	public static void sendData(WebElement ele, String data) {
		ele.sendKeys(data);
	}

	public static void clcikElement(WebElement ele) {
		ele.click();
	}

	public static void jsClcikElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
	}

	public static void browserClose() throws InterruptedException {
		Thread.sleep(500);
		driver.quit();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void robotTab(int count) throws AWTException {
		Robot robot = new Robot();
		for (int i = 1; i <= count; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
	}

	public static void robotEnter(int count) throws AWTException {
		Robot robot = new Robot();
		for (int i = 1; i <= count; i++) {
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
	}

	public static void fileUploadRobot(String path) throws AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(1000);
		String filePath = path;
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(filePath);
		clipboard.setContents(stringSelection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void selectDDNText(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);

	}

}
