package contexts;

import pages.ContactsPage;
import pages.DeliveryPage;
import waiters.Waiters;

public class InputPersonalDataContext {
    public static DeliveryPage inputContacts(ContactsPage page, String name, String city, String phone, String email){
        page.name.setValue(name);
        page.phone.setValue(phone);
        page.email.setValue(email);
        if (!page.city.getValue().equals(city))
            page.city.setValue(city);
        Waiters.waitForPreloader(page.getDriver(), "//*[@id=\"step_contacts\"]/div/div[1]/div[2]/div/span", Waiters.WAIT_10);
        page.next.click();
        return new DeliveryPage(page.getDriver());
    }
}
