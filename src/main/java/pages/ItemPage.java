package pages;

import extensions.ChromeDriverEx;
import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends Page{
    public ItemPage(ChromeDriverEx driver) {
        super(driver);
    }

//    @FindBy(id = "price_label")
//    @CacheLookup
//    public Label price;

//    @FindBy(xpath = "//*[@id=\"detail_buy_label\"]/div[3]/div[1]/div/form/span/span/button")
//    @CacheLookup
    public WebElement buy =  driver.findElement(By.xpath("//button[@name=\"topurchases\"]"));

    public int getPrice(){
        //String tmp = (driver.findElement(By.xpath("id(\"catalog_goods_block\")/div[1]/div[" + 0 + "]/div[1]/div[1]/div[1]"))).findElement(new By.ByClassName("g-price-uah")).getText();
//        int i = Integer.valueOf(tmp
//                .substring(0,tmp.length()-3)
//                .replace("\u2009","")
//                .replace(" ",""));
        WebElement price = driver.findElement(By.id("price_label"));
        String stringValue = price.getText().replace(" ", "");
        return Integer.parseInt(stringValue);
//        return i;
    }
}
