import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class BookingPage {

    private SelenideElement searchInput = $("input[data-sb-id='location']");
    private SelenideElement checkInDateInput = $("div[data-placeholder='Check-in']");
    private SelenideElement checkOutDateInput = $("div[data-placeholder='Check-out']");
    private SelenideElement searchButton = $("button[data-sb-id='submit-button']");
    private SelenideElement mapButton = $("button[data-testid='map-button']");
    private SelenideElement firstHotelCard = $("div[data-testid='property-card']:nth-child(1)");
    private SelenideElement hotelName = firstHotelCard.$("div[data-testid='title']");
    private SelenideElement hotelStars = firstHotelCard.$("div[data-testid='rating']");
    private SelenideElement hotelRating = firstHotelCard.$("div[data-testid='review-score']");
    private SelenideElement hotelPrice = firstHotelCard.$("div[data-testid='price-and-discounted-price']");
    private SelenideElement hotelMarker = $("div[data-testid='map-marker']");

    public void openBookingPage() {
        open("https://www.booking.com/");
    }

    public void searchForCity(String city) {
        searchInput.setValue(city).pressEnter();
    }

    public void selectRandomDates() {
        LocalDate today = LocalDate.now();
        
        int checkInDays = ThreadLocalRandom.current().nextInt(1, 31);
        int checkOutDays = checkInDays + ThreadLocalRandom.current().nextInt(1, 6);
        
        LocalDate checkInDate = today.plusDays(checkInDays);
        LocalDate checkOutDate = today.plusDays(checkOutDays);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String checkInDateFormatted = checkInDate.format(dateFormatter);
        String checkOutDateFormatted = checkOutDate.format(dateFormatter);

        System.out.println("Случайная дата заезда: " + checkInDate);
        System.out.println("Случайная дата выезда: " + checkOutDate);

        checkInDateInput.click();
        $("td[data-date='" + checkInDateFormatted + "']").click(); 
        checkOutDateInput.click();
        $("td[data-date='" + checkOutDateFormatted + "']").click(); 
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickMapButton() {
        mapButton.click();
    }

    public void hoverOverFirstHotel() {
        firstHotelCard.hover();
    }

    public String getHotelName() {
        return hotelName.getText();
    }

    public String getHotelStars() {
        return hotelStars.getText();
    }

    public String getHotelRating() {
        return hotelRating.getText();
    }

    public String getHotelPrice() {
        return hotelPrice.getText();
    }

    public void clickOnHotelMarker() {
        hotelMarker.click();
    }
}
