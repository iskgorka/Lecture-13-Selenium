import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        String searchFieldXpath = "//input[@title='Поиск']";
        WebElement searchElement = driver.findElement(By.xpath(searchFieldXpath));
        searchElement.sendKeys("rozetka ua");
        System.out.println("Search field is displayed " + searchElement.isDisplayed());
        searchElement.submit();

        WebElement searchResult = driver.findElement(By.xpath("//div[@class='yuRUbf']//a[@href='https://rozetka.com.ua/']//h3[@class='LC20lb MBeuO DKV0Md']"));
        searchResult.click();
        System.out.println("Current URL is " + driver.getCurrentUrl());

        WebElement rozetkaSearchElement = driver.findElement(By.xpath("//input[@name='search']"));
        rozetkaSearchElement.sendKeys("Костюм спортивный Tommy Hilfiger 92 см Синий");
        rozetkaSearchElement.click();

        List<WebElement> allMenus = driver.findElements(By.className("suggest-goods"));
        for (WebElement v : allMenus) {
            System.out.println("Menu title " + v.getText());
        }
        allMenus.get(0).click();

        WebElement productButton = driver.findElement(By.xpath("//button[@class=\"buy-button button button_with_icon button_color_green button_size_large ng-star-inserted\"]"));
        productButton.click();
        System.out.println("Product URL is " + driver.getCurrentUrl());
        System.out.println("Button text is " + productButton.getText());

        driver.close();
    }
}
