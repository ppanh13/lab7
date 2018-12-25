package pages;

import extensions.ChromeDriverEx;
import elements.Button;
import elements.CheckList;
import elements.TextField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends Page {
    public static final String ROZETKA_SEARCH_URL = "https://bt.rozetka.com.ua/boilers/c80131/filter/";

    public SearchPage(ChromeDriverEx driver) {
        super(driver);
        open();
    }

    @FindBy(xpath = "//body/div[3]")
    @CacheLookup
    public WebElement progressBar;

    @FindBy(id = "price[min]")
    @CacheLookup
    public TextField minPrice;

    @FindBy(id = "price[max]")
    @CacheLookup
    public TextField maxPrice;

    @FindBy(id = "submitprice")
    @CacheLookup
    public Button submitPrice;

    @FindBy(xpath = "//form[@id=\"filter_parameters_form\"]/div[4]")
    @CacheLookup
    public CheckList countryFilter;

//    @FindBy(css = ".g-i-tile-i.available")
    @FindBy(className = "g-i-tile-i-image fix-height")
    @CacheLookup
    public List<WebElement> resultSet = null;

    public SearchPage open() {
        driver.get(ROZETKA_SEARCH_URL);
        return this;
    }

    public SearchPage setCountry(String country){
        countryFilter.selectFromCheckList(country);
        return this;
    }

    public SearchPage setMinPrice(int price){
        minPrice.setValue(Integer.toString(price));
        return this;
    }

    public SearchPage setMaxPrice(int price){
        maxPrice.setValue(Integer.toString(price));
        return this;
    }
}
