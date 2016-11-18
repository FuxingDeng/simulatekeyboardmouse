package com.liyuncong.learn.simulatekeyboardmouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class KeyBoardInput {
	public static void main(String[] args) throws InterruptedException {
		// The Firefox driver supports javascript
		RemoteWebDriver driver = new FirefoxDriver();

        // Go to the Google Suggest home page
        driver.get("https://pbank.psbc.com/pweb/prelogin.do?_locale=zh_CN&BankId=9999");
        
        driver.executeScript("window.focus();");
        
        Thread.sleep(5000);
        
        driver.executeScript("document.getElementById('kw').blur();");
        
        Thread.sleep(5000);
        
        driver.executeScript("document.getElementById('kw').focus();");
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
        WebElement element = driver.findElement(By.id("su"));
    	element.click();
	}
	
	// 单个 按键
	public static void keyPress(Robot r, int key) {
		r.keyPress(key);
		r.keyRelease(key);
		r.delay(1000);
	}
	
	// win + d 最小化所有窗口
	public static void dPressWithWin(Robot r) {
		r.keyPress(KeyEvent.VK_WINDOWS);
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_WINDOWS);
		r.delay(100);
	}
	
	@Test
	public void test() {
		
		try {
			Robot robot = new Robot();
			dPressWithWin(robot);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过java Robot类输入模拟键盘输入密码
	 * @param password 
	 */
	private void keyboardSendKeysByRobot(String password) {
		
		try {
			Robot robot = new Robot();
//			minimizeAllWindows();
			for(int i = 0; i < password.length(); i++) {
				switch (password.substring(i, i + 1)) {
				case "0":
					keyPress(robot, KeyEvent.VK_0);
					break;
				case "1":
					keyPress(robot, KeyEvent.VK_1);
					break;
				case "2":
					keyPress(robot, KeyEvent.VK_2);
					break;
				case "3":
					keyPress(robot, KeyEvent.VK_3);
					break;
				case "4":
					keyPress(robot, KeyEvent.VK_4);
					break;
				case "5":
					keyPress(robot, KeyEvent.VK_5);
					break;
				case "6":
					keyPress(robot, KeyEvent.VK_6);
					break;
				case "7":
					keyPress(robot, KeyEvent.VK_7);
					break;
				case "8":
					keyPress(robot, KeyEvent.VK_8);
					break;
				case "9":
					keyPress(robot, KeyEvent.VK_9);
					break;
				case "a":
					keyPress(robot, KeyEvent.VK_A);
					break;
				case "b":
					keyPress(robot, KeyEvent.VK_B);
					break;
				case "c":
					keyPress(robot, KeyEvent.VK_C);
					break;
				case "d":
					keyPress(robot, KeyEvent.VK_D);
					break;
				case "e":
					keyPress(robot, KeyEvent.VK_E);
					break;
				case "f":
					keyPress(robot, KeyEvent.VK_F);
					break;
				case "g":
					keyPress(robot, KeyEvent.VK_G);
					break;
				case "h":
					keyPress(robot, KeyEvent.VK_H);
					break;
				case "i":
					keyPress(robot, KeyEvent.VK_I);
					break;
				case "j":
					keyPress(robot, KeyEvent.VK_J);
					break;
				case "k":
					keyPress(robot, KeyEvent.VK_K);
					break;
				case "l":
					keyPress(robot, KeyEvent.VK_L);
					break;
				case "m":
					keyPress(robot, KeyEvent.VK_M);
					break;
				case "n":
					keyPress(robot, KeyEvent.VK_N);
					break;
				case "o":
					keyPress(robot, KeyEvent.VK_O);
					break;
				case "p":
					keyPress(robot, KeyEvent.VK_P);
					break;
				case "q":
					keyPress(robot, KeyEvent.VK_Q);
					break;
				case "r":
					keyPress(robot, KeyEvent.VK_R);
					break;
				case "s":
					keyPress(robot, KeyEvent.VK_S);
					break;
				case "t":
					keyPress(robot, KeyEvent.VK_T);
					break;
				case "u":
					keyPress(robot, KeyEvent.VK_U);
					break;
				case "v":
					keyPress(robot, KeyEvent.VK_V);
					break;
				case "w":
					keyPress(robot, KeyEvent.VK_W);
					break;
				case "x":
					keyPress(robot, KeyEvent.VK_X);
					break;
				case "y":
					keyPress(robot, KeyEvent.VK_Y);
					break;
				case "z":
					keyPress(robot, KeyEvent.VK_Z);
					break;
				case "A":
					keyPressWithShift(robot, KeyEvent.VK_A);
					break;
				case "B":
					keyPressWithShift(robot, KeyEvent.VK_B);
					break;
				case "C":
					keyPressWithShift(robot, KeyEvent.VK_C);
					break;
				case "D":
					keyPressWithShift(robot, KeyEvent.VK_D);
					break;
				case "E":
					keyPressWithShift(robot, KeyEvent.VK_E);
					break;
				case "F":
					keyPressWithShift(robot, KeyEvent.VK_F);
					break;
				case "G":
					keyPressWithShift(robot, KeyEvent.VK_G);
					break;
				case "H":
					keyPressWithShift(robot, KeyEvent.VK_H);
					break;
				case "I":
					keyPressWithShift(robot, KeyEvent.VK_I);
					break;
				case "J":
					keyPressWithShift(robot, KeyEvent.VK_J);
					break;
				case "K":
					keyPressWithShift(robot, KeyEvent.VK_K);
					break;
				case "L":
					keyPressWithShift(robot, KeyEvent.VK_L);
					break;
				case "M":
					keyPressWithShift(robot, KeyEvent.VK_M);
					break;
				case "N":
					keyPressWithShift(robot, KeyEvent.VK_N);
					break;
				case "O":
					keyPressWithShift(robot, KeyEvent.VK_O);
					break;
				case "P":
					keyPressWithShift(robot, KeyEvent.VK_P);
					break;
				case "Q":
					keyPressWithShift(robot, KeyEvent.VK_Q);
					break;
				case "R":
					keyPressWithShift(robot, KeyEvent.VK_R);
					break;
				case "S":
					keyPressWithShift(robot, KeyEvent.VK_S);
					break;
				case "T":
					keyPressWithShift(robot, KeyEvent.VK_T);
					break;
				case "U":
					keyPressWithShift(robot, KeyEvent.VK_U);
					break;
				case "V":
					keyPressWithShift(robot, KeyEvent.VK_V);
					break;
				case "W":
					keyPressWithShift(robot, KeyEvent.VK_W);
					break;
				case "X":
					keyPressWithShift(robot, KeyEvent.VK_X);
					break;
				case "Y":
					keyPressWithShift(robot, KeyEvent.VK_Y);
					break;
				case "Z":
					keyPressWithShift(robot, KeyEvent.VK_Z);
					break;	
				default:
					keyPress(robot, KeyEvent.VK_0);
					break;
				}
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}
	
	// shift+ 按键
	public static void keyPressWithShift(Robot r, int key) {
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(key);
		r.keyRelease(key);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.delay(100);
	}
	
	private void keyboardSendKeys(String password, WebDriver driver) {
		if (password == null || password.length() == 0) {
			return;
		}
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.id("ocxEdit")));
		for(int i = 0; i < password.length(); i++) {
			switch (Integer.parseInt(password.substring(i, i + 1))) {
			case 0:
				action.sendKeys(Keys.NUMPAD0);
				break;
			case 1:
				action.sendKeys(Keys.NUMPAD1);
				break;
			case 2:
				action.sendKeys(Keys.NUMPAD2);
				break;
			case 3:
				action.sendKeys(Keys.NUMPAD3);
				break;
			case 4:
				action.sendKeys(Keys.NUMPAD4);
				break;
			case 5:
				action.sendKeys(Keys.NUMPAD5);
				break;
			case 6:
				action.sendKeys(Keys.NUMPAD6);
				break;
			case 7:
				action.sendKeys(Keys.NUMPAD7);
				break;
			case 8:
				action.sendKeys(Keys.NUMPAD8);
				break;
			case 9:
				action.sendKeys(Keys.NUMPAD9);
				break;
						
			default:
				action.sendKeys(Keys.NUMPAD9);
				break;
			}
		}
	}
}
