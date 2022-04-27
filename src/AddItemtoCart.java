import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//: Building Programming Logic to process items in array for Cart

public class AddItemtoCart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Deepika\\Selenium\\chromedriver_win32_100\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://racks.lk/");
	
		String[] itemsNeeded= {"3 LAYER FOLDABLE ROLLING CART,3 LAYER BAMBOO STORAGE RACK"};
		
		List<WebElement> Products = driver.findElements(By.cssSelector("h2.woocommerce-loop-product__title"));
	
		for(int i=0;i<Products.size();i++)
		{
			String[] name=Products.get(i).getText().split(",");
			String formattedName = name[0].trim();				

			for (int j=0;j<itemsNeeded.length;j++)
			{
				if(itemsNeeded[j].contains(formattedName))
				{
					//System.out.println(formattedName);
					driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
				}

			}
		}
	}

}
