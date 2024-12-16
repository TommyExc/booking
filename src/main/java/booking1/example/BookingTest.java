package booking1.example;

import io.qameta.allure.Description;
import booking1.example2.BookingPage;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BookingTest {
    BookingPage bookingPage = new BookingPage();

    @Test
    @Description("Проверка поиска отелей в Анталье с фильтром 5 звезд")
    public void testSearchFiveStarHotelsInAntalya() {
        bookingPage.open();
        bookingPage.searchForCity("Анталья");
        bookingPage.verifyCityInSearchResults("Анталья");
        bookingPage.selectFiveStars();
        bookingPage.verifyAllHotelsHaveFiveStars();
    }

    @Test
    public void tearDown() {
        closeWebDriver();
    }
}
