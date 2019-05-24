package mavenDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kitabisa_TC2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Launch website
		driver.get("https://www.kitabisa.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//section[@id='public-campaign']//div[@class='container']//div[1]//div[1]//a[1]")).click();
		
		//Campaign details page
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement Donasi= driver.findElement(By.xpath("//a[@class='btn btn--block btn--large btn--round btn-contribute btn--pink']"));
		action.doubleClick(Donasi).perform();
		
		//Contribution page
		driver.findElement(By.xpath("//div[@class='btn--vform']")).click();
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Nominal donasi tidak boleh kosong.')]")).getText());
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Metode Pembayaran tidak boleh kosong.')]")).getText());
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Nama lengkap tidak boleh kosong.')]")).getText());
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Nomor WhatsApp atau Email tidak boleh kosong.')]")).getText());
				
		driver.navigate().refresh();
		
		//validation with various amounts
		driver.findElement(By.id("target-donasi")).sendKeys("1");
		System.out.println(driver.findElement(By.xpath("//p[@class='align-left__i label-input-error']")).getText());
		driver.navigate().refresh();
		
		driver.findElement(By.id("target-donasi")).sendKeys("999");
		System.out.println(driver.findElement(By.xpath("//p[@class='align-left__i label-input-error']")).getText());
		driver.navigate().refresh();
		
		driver.findElement(By.id("target-donasi")).sendKeys("9999");
		System.out.println(driver.findElement(By.xpath("//p[@class='align-left__i label-input-error']")).getText());
		driver.navigate().refresh();
		
		driver.findElement(By.id("target-donasi")).sendKeys("500000000");
		driver.navigate().refresh();
		
		driver.findElement(By.id("target-donasi")).sendKeys("500000001");
		System.out.println(driver.findElement(By.xpath("//p[@class='align-left__i label-input-error']")).getText());
		driver.navigate().refresh();
		
		driver.findElement(By.id("target-donasi")).sendKeys("800000000");
		System.out.println(driver.findElement(By.xpath("//p[@class='align-left__i label-input-error']")).getText());
		
		
		
		
		
	}



}
