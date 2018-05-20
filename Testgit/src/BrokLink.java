

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokLink {
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "F:\\softwares\\x64\\seleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		driver.get("https://www.freecrm.com/index.html");
		List<WebElement> list = new LinkedList<WebElement>();
		list=driver.findElements(By.tagName("a"));
		list.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println(list.size());
		
		List<WebElement> activelist = new LinkedList<WebElement>();
	
		for(int i=0;i<list.size();i++){
			
			if(list.get(i).getAttribute("href")!=null && (!list.get(i).getAttribute("href").contains("java")))
			{
				activelist.add(list.get(i));
//				System.out.println("adding "+list.get(i).getAttribute("href"));
//				System.out.println("adding "+list.get(i));
				}
		}
		System.out.println(activelist.size());

		
		for(int j=0;j<activelist.size();j++){
			System.out.println(j+"th link   "+activelist.get(j).getAttribute("href"));
			HttpURLConnection connection = null;
				connection = (HttpURLConnection)new URL(activelist.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String s=connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activelist.get(j).getAttribute("href")+"----------"+ " "+s);
		}
		driver.close();
	}
	}
