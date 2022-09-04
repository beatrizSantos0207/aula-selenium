import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class TestShein {

    @Test
    public void teste() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\beatr\\Downloads\\chromedriver_win32\\chromedriver.exe");

        SheinSearch sheinSearch = new SheinSearch();

        WebElement searchHeader = sheinSearch.getHeaderSearchInput();
        searchHeader.sendKeys("vestido");
        searchHeader.submit();

        sheinSearch.clickOnCheckBox();
        sheinSearch.clickOnCheckBox();
        sheinSearch.clickOnCheckBox();

        List<WebElement> foundList = sheinSearch.getListItemSection();
        for (WebElement webElement : foundList) {
            WebElement listedItem =  sheinSearch.getListedItemByAriaLabel(webElement);
            System.out.println("Descrição: " + listedItem.getAttribute("aria-label"));
            System.out.println("Preço: " +  listedItem.getAttribute("data-price"));
            System.out.println("Preço US: " +  listedItem.getAttribute("data-us-price"));
        }

        System.out.println("Total de itens encontrados: " + foundList.size());

        foundList.get(0).click();
        sheinSearch.getProductDescriptionTableInfo()
                .forEach(item -> {
                    System.out.println(item.getText());
                });
    }

}



