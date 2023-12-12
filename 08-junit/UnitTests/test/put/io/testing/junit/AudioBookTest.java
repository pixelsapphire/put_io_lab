package put.io.testing.junit;

import org.junit.jupiter.api.Test;
import put.io.testing.audiobooks.Audiobook;
import put.io.testing.audiobooks.AudiobookPriceCalculator;
import put.io.testing.audiobooks.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudioBookTest {

    // [[ Pytanie 5.1 ]]
    // Testowanie z użyciem podejścia analizy ścieżek działania programu to testowanie whitebox.

    @Test
    public void testCalculate_RegularCustomer_ReturnsStartingPrice() {
        Customer customer = new Customer("John Doe", Customer.LoyaltyLevel.STANDARD, false);
        Audiobook audiobook = new Audiobook("The Great Gatsby", 9.99);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();
        double actualPrice = calculator.calculate(customer, audiobook);
        assertEquals(audiobook.getStartingPrice(), actualPrice);
    }

    @Test
    public void testCalculate_SilverCustomer_ReturnsDiscountedPrice() {
        Customer customer = new Customer("Jane Smith", Customer.LoyaltyLevel.SILVER, false);
        Audiobook audiobook = new Audiobook("Pride and Prejudice", 14.99);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();
        double actualPrice = calculator.calculate(customer, audiobook);
        assertEquals(0.9 * audiobook.getStartingPrice(), actualPrice);
    }

    @Test
    public void testCalculate_GoldCustomer_ReturnsDiscountedPrice() {
        Customer customer = new Customer("Alice Johnson", Customer.LoyaltyLevel.GOLD, false);
        Audiobook audiobook = new Audiobook("To Kill a Mockingbird", 19.99);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();
        double actualPrice = calculator.calculate(customer, audiobook);
        assertEquals(0.8 * audiobook.getStartingPrice(), actualPrice);
    }

    @Test
    public void testCalculate_SubscriberCustomer_ReturnsZeroPrice() {
        Customer customer = new Customer("Bob Williams", Customer.LoyaltyLevel.STANDARD, true);
        Audiobook audiobook = new Audiobook("1984", 12.99);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();
        double actualPrice = calculator.calculate(customer, audiobook);
        assertEquals(0.0, actualPrice);
    }

    // [[ Pytanie 5.2 ]]
    // W metodzie calculate znajdują się 4 ścieżki działania.
}
