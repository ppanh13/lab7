package contexts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ItemPage;
import pages.SearchPage;

import java.util.List;

public class ResultsSetContext {
    public static ItemPage selectElement(SearchPage page, int elementIndex){
//        List <WebElement> results = null;
//        for (int i =1 ;i<33;i++){
//            if (i==7){
//                continue;}
//            System.out.println(page.getDriver().findElement(By.xpath("id(\"catalog_goods_block\")/div[1]/div["+String.valueOf(i)+"]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")).getText());
//            results.add(page.getDriver().findElement(By.xpath("id(\"catalog_goods_block\")/div[1]/div["+String.valueOf(i)+"]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")));
//
//        }
//        WebElement x = page.resultSet.get(elementIndex);
        WebElement x = page.getDriver().findElement(By.xpath("id(\"catalog_goods_block\")/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]"));
        x.click();
        return new ItemPage(page.getDriver());
    }
}
