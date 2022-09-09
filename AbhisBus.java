package firstProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbhisBus {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\itmaint\\eclipse-workspace\\Seleniumnew\\src\\chromedrivernew\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.get("https://www.abhibus.com/");
	
	WebElement from =driver.findElement(By.xpath("(//*[@type='text'])[1]"));
	from.sendKeys("Chennai",Keys.ENTER);
	
	WebElement to =driver.findElement(By.xpath("(//*[@type='text'])[2]"));
	to.sendKeys("Mysore",Keys.ENTER);
	
	driver.findElement(By.id("datepicker1"));
	
	String selDate = "22";
	String selMonth = "September";
	String selYear = "2022";
	String month=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//following::span[@class='ui-datepicker-month']")).getText();
    String year = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']//following::span[@class='ui-datepicker-year'])[2]")).getText();
 
    if (month.equals(selMonth) && year.equals(selYear)) {
		List<WebElement> alldates=driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']//tbody//tr//td"));
		
		for (WebElement dates :alldates) {
			if (dates.getText().equals(selDate)) {
				dates.click();
				break;
				
			}
		}
	}













}
}
