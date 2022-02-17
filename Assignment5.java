import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li/a[text()='Nested Frames']")).click();
		var Frame1=driver.findElement(By.cssSelector("frame[name='frame-top']"));
		 driver.switchTo().frame(Frame1);
	    int InnerFrame=driver.findElements(By.tagName("frame")).size();
	    for(int i=0;i<InnerFrame;i++) {
	    	
	    driver.switchTo().frame(i);
	     String ValidationFrame=driver.findElement(By.xpath("//body")).getText();
	    if(ValidationFrame.equals("MIDDLE")) {
	    	System.out.println(driver.findElement(By.xpath("//body")).getText());
	    }
         driver.switchTo().parentFrame();
	    	
	    }

	}

}
