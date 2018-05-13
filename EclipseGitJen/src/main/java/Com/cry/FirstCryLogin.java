package Com.cry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

import net.bytebuddy.asm.Advice.Return;

public class FirstCryLogin {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\softwares\\x64\\seleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 
		driver.get("http://www.firstcry.com/");
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(2000);
		JavascriptExecutor Js= (JavascriptExecutor) driver;
		String str =Js.executeScript("return document.domain;").toString();
		System.out.println(str);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnSignUp']")));
		System.out.println("abcd");
		System.out.println(driver.getWindowHandles().size());
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@id='Mobile']")).sendKeys("abcd");
		System.out.println("check now");
		driver.findElement(By.xpath("//input[@id='btnSignUp']")).click();
		Thread.sleep(2000);
		driver.close();		
	}

}
