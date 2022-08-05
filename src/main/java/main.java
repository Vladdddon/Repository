import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class main
{
    public static <bool> void main(String [] args)
    {
        System.setProperty("webdriver.chrome.driver", "/Users/valeksa/IdeaProjects/Repository/Repository/chromedriver-102.0.5005.61");
        int itemsQuantity = 3;
        String searchPhrase = "Телефон";

        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://rozetka.com.ua/");

        WebElement searchField = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/div/div[1]/input"));
        WebElement searchButton = driver.findElement(By.xpath(".//button[contains(@class,'search-form__submit')]"));

//        Actions actions = new Actions(driver);
//        actions.moveToElement(searchField).build().perform();
//        actions.click(searchField).build().perform();
        searchField.sendKeys(searchPhrase);
//        WebElement searchButton = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/button"));
        searchButton.click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        List<WebElement> Items = driver.findElements(By.xpath(".//span[@class = 'goods-tile__title']"));

        boolean present = true;
        for(int i = 0; i < itemsQuantity; i++)
        {
            String itemName = Items.get(i).getAttribute("innerText");
            present = present && itemName.toLowerCase().contains(searchPhrase.toLowerCase());
        }
        driver.quit();
        driver.close();



//        if (WebElement.ELEMENT_KEY] == ids[1][webdriver.WebElement.ELEMENT_KEY])
//        {
//
//        }
//            return true;


//        searchField.click();
//        searchButton.click();


//        driver.findElement(By.linkText("Search"))

//        String S = " ";
//        S.contains("Телефон");

//        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
//        driver.findElement(By.linkText("www.facebook.com")).sendKeys(selectLinkOpeninNewTab);
    }
}