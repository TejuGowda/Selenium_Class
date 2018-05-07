package programs;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParticularElement {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		WebElement ele = driver.findElement(By.xpath("//td[@id='logoContainer']/div/img"));
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation = new File("E:/Teju_screenshot.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		
	}
}
