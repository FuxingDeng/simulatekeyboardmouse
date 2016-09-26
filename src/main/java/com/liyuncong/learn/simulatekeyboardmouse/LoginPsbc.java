package com.liyuncong.learn.simulatekeyboardmouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.MessageFormat;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPsbc {
	public static void main(String[] args) {
		// The Firefox driver supports javascript
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		RemoteWebDriver driver = new InternetExplorerDriver();

		// Go to the Google Suggest home page
//		driver.get("https://pbank.psbc.com/pweb/prelogin.do?_locale=zh_CN&BankId=9999");
		
		driver.get("https://www.baidu.com/");
		
//		driver.executeScript("document.getElementById('UserId').value=" + "");
		
//        driver.executeScript("document.getElementById('powerpass').focus()");
        try {
			Robot robot = new Robot();
			keyPress(robot, KeyEvent.VK_SHIFT);
			keyPress(robot, KeyEvent.VK_Y);
			keyPress(robot, KeyEvent.VK_Y);
			keyPress(robot, KeyEvent.VK_A);
			keyPress(robot, KeyEvent.VK_G);
			keyPress(robot, KeyEvent.VK_U);
			keyPress(robot, KeyEvent.VK_1);
			keyPress(robot, KeyEvent.VK_2);
			keyPress(robot, KeyEvent.VK_6);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		driver.close();
		killIe();
	}
	
	// 单个 按键
	public static void keyPress(Robot r, int key) {
		r.keyPress(key);
		r.keyRelease(key);
		r.delay(1000);
	}
	
	public static void killIe() {
		Runtime runTime = Runtime.getRuntime();
	    //如果使用了ie浏览器和driver     
	    try {
			runTime.exec("tskill iexplore");
			runTime.exec("tskill IEDriverServer");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
