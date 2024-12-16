import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class BookingTest {

    @Test
    @Description("Тест на поиск отелей на Booking.com")
    public void testBooking() {
        BookingPage bookingPage = new BookingPage();


        bookingPage.openBookingPage();

        String city = "Paris"; // Можно выбрать другой город
        bookingPage.searchForCity(city);


        bookingPage.selectRandomDates();

        bookingPage.clickSearchButton();

        bookingPage.clickMapButton();

        bookingPage.hoverOverFirstHotel();
        String hotelName = bookingPage.getHotelName();
        String hotelStars = bookingPage.getHotelStars();
        String hotelRating = bookingPage.getHotelRating();
        String hotelPrice = bookingPage.getHotelPrice();


        bookingPage.clickOnHotelMarker();
    }