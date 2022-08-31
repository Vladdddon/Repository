import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JunitRozetka {

    WebDriver driver;
    @DisplayName("Should demonstrate simple website view and search")
    @BeforeEach
    public void setUp() {
        System.out.println("_______________________________________________________\n");
        System.out.println("This is the setUp() method that runs before each testcase");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void verifySearch() {
        System.setProperty("webdriver.chrome.driver", "/Users/valeksa/IdeaProjects/Repository/Repository/chromedriver");
        int itemsQuantity = 3;
        String searchPhrase = "Телефон";

        WebElement searchField = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/div/div[1]/input"));
        WebElement searchButton = driver.findElement(By.xpath(".//button[contains(@class,'search-form__submit')]"));

        searchField.sendKeys(searchPhrase);
        searchButton.click();
        try{TimeUnit.SECONDS.sleep(5);}
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> Items = driver.findElements(By.xpath(".//span[@class = 'goods-tile__title']"));
        Assert.assertTrue(compareSearch(Items, searchPhrase, itemsQuantity));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private boolean compareSearch(List<WebElement> Items, String searchPhrase, int itemsQuantity) {
        boolean present = true;
        for (int i = 0; i < itemsQuantity; i++) {
            String itemName = Items.get(i).getAttribute("innerText");
            present = present && itemName.toLowerCase().contains(searchPhrase.toLowerCase());
        }
        return present;
    }
}
