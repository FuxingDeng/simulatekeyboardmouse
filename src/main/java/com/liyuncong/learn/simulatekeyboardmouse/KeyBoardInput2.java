package com.liyuncong.learn.simulatekeyboardmouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.liyuncong.application.commontools.FileTools;

public class KeyBoardInput2 {
	public static void main(String[] args) throws InterruptedException {
		// The Firefox driver supports javascript
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		RemoteWebDriver driver = new InternetExplorerDriver();

        // Go to the Google Suggest home page
        driver.get("https://ebank.bankofbeijing.com.cn/bccbpb/accountLogon.jsp?language=zh_CN");
        
        driver.executeScript("window.focus();");
        
        Thread.sleep(5000);
        FileTools.writeStringToFile(driver.getPageSource(), "d:/test/test.html");
        
        driver.executeScript("document.form1.logonid_temp.focus()");
        
        try {
			Robot robot = new Robot();
			keyPress(robot, KeyEvent.VK_SHIFT);
			keyPress(robot, KeyEvent.VK_A);
			keyPress(robot, KeyEvent.VK_B);
			keyPress(robot, KeyEvent.VK_A);
			keyPress(robot, KeyEvent.VK_N);
			keyPress(robot, KeyEvent.VK_D);
			keyPress(robot, KeyEvent.VK_O);
			keyPress(robot, KeyEvent.VK_N);
		} catch (AWTException e) {
			e.printStackTrace();
		}
//        WebElement element = driver.findElement(By.id("su"));
//    	element.click();
        Thread.sleep(5000);
        driver.close();
	}
	
	// 单个 按键
	public static void keyPress(Robot r, int key) {
		r.keyPress(key);
		r.keyRelease(key);
		r.delay(1000);
	}
}
