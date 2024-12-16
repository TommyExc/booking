package booking1.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class BookingPage {
    private SelenideElement searchInput = $("input[name='ss']");
    private SelenideElement searchButton = $("button[type='submit']");
    private SelenideElement filterFiveStars = $("input[id='filter_class:class-5']");
    private SelenideElement hotelList = $("div[data-testid='property-card']");

    public void open(String url) {
        open("https://booking.com/");
    }

    public void searchForCity(String city) {
        searchInput.setValue(city);
        searchButton.click();
    }

    public void verifyCityInSearchResults(String city) {
        $("h1").shouldHave(Condition.text(city));
    }

    public void selectFiveStars() {
        filterFiveStars.click();
    }

    public void verifyAllHotelsHaveFiveStars() {
        hotelList.shouldHave(Condition.text("5 звёзд"));
    }
}