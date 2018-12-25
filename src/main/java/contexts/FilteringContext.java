package contexts;

import pages.SearchPage;
import waiters.Waiters;

public class FilteringContext {
    public static void filterByPriceRange(SearchPage page, int minPrice, int maxPrice){
        setPrice(page, minPrice, maxPrice);
        submitPriceFilter(page);
    }

    public static void filterByCountry(SearchPage page, String country){
        page.setCountry(country);
        Waiters.waitForLoading(page.getDriver(),Waiters.WAIT_10,page.progressBar);
    }

    private static void setPrice(SearchPage page, int minPrice, int maxPrice){
        page.setMinPrice(minPrice);
        page.setMaxPrice(maxPrice);
    }

    private static void submitPriceFilter(SearchPage page){
        page.submitPrice.click();
        Waiters.waitForLoading(page.getDriver(), Waiters.WAIT_10, page.progressBar);
    }
}
