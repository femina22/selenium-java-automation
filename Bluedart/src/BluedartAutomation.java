import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BluedartAutomation {

	public static void main(String[] args) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://www.bluedart.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		js.executeScript("scrollBy(0, 500)");  
		//driver.findElement(By.xpath("//button[@id='portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_cookies']/div/div[2]/div/div/div/div/div[2]/button[1]")).click();
		driver.findElement(By.xpath("//textarea[@id='trackingNoTrackDart']")).sendKeys("16112696261");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='goBtnTrackDart']")).click();
		js.executeScript("scrollBy(0, 500)"); 
		
		
		Date currentdate=new Date();
		String screenshotfilename=currentdate.toString().replace(" ", "-").replace(":", "-");
		//System.out.println(screenshotfilename);
		
		File screenshotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotfilename + ".png"));
	
	}

}
