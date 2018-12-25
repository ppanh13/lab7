import contexts.*;
import extensions.ChromeDriverEx;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
import pages.*;
import waiters.Waiters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class RozetkaTest {
    private static String driverPath = "Selenium WebDriver/chromedriver";
    private static ChromeDriverEx driver;

    @BeforeClass
    public static void setDriverPath() throws IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @Test
    public void test() throws Exception {
        driver = new ChromeDriverEx();
        Waiters.waitImplicit(driver, Waiters.WAIT_10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        SearchPage searchPage = new SearchPage(driver);
        int minPriceValueToSet = 100, maxPriceValueToSet = 2000;
        String country = "Украина";
        //filter goods by price and country; choose first item
        FilteringContext.filterByPriceRange(searchPage, minPriceValueToSet, maxPriceValueToSet);
        FilteringContext.filterByCountry(searchPage, country);
        ItemPage itemPage = ResultsSetContext.selectElement(searchPage, 0);
        //assert price of chosen item is correct
        int actualPrice = ItemVerificationContext.verifyItemPrice(itemPage, minPriceValueToSet, maxPriceValueToSet);
        //click "Buy"
        CartPage cartPage = ItemShoppingContext.buy(itemPage);
        //assert total price
        ItemVerificationContext.verifyTotalPrice(cartPage, actualPrice);
        //validate purchase
        ContactsPage contactsPage = ItemShoppingContext.validatePurchase(cartPage);
        //input contacts and delivery info
        String name = "Чан Фионг Ань", city = "Киев", phone = "+380123456789", email = "arbuzanya111@ukr.net";
        DeliveryPage deliveryPage = InputPersonalDataContext.inputContacts(contactsPage, name, city, phone, email);
        //assert sum is correct and purchase button is enabled
        //ItemVerificationContext.verifySum(deliveryPage, actualPrice);
        //ElementIsEnabledContext.verifyPurchaseButtonIsEnabled(deliveryPage);
        deliveryPage.takeScreenshot();
    }
    @After
    public void end() throws IOException {
        driver.quit();
    }
}
