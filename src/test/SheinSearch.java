import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SheinSearch extends Page {

    public static final String FILTER_CLASS = "//label[@class=\"S-checkbox ciPAkm S-checkbox_checkbox12 S-checkbox_normal\"]";


    public SheinSearch() {
		super();
		driver.get("https://br.shein.com/");
	}

	public WebElement getHeaderSearchInput() {
		return driver.findElement(By.xpath("//input[@class=\"header-search-input j-header-search-input\"]"));
	}

    public void clickOnCheckBox() {
        driver.findElement(By.xpath(FILTER_CLASS)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    public List<WebElement> getListItemSection() {
        return driver.findElements(By.xpath("//section[@role=\"listitem\"]"));
    }

    public WebElement getListedItemByAriaLabel(WebElement originalElement) {
        return originalElement.findElement(By.xpath("//a[@aria-label=\"" + originalElement.getAttribute("aria-label")  + "\"]"));
    }

    public WebElement getProductDescriptionTable() {
        return  driver.findElement(By.xpath("//div[@class=\"product-intro__description-table\"]"));
    }

    public List<WebElement> getProductDescriptionTableInfo() {
       return getProductDescriptionTable().findElements(By.xpath("//div[@class=\"product-intro__description-table-item\"]"));
    }

	@Override
	public String getTitle() {
		return driver.getTitle();
	}
}
