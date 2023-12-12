package put.io.testing.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    void setup() {
        calculator = new Calculator();
    }

    // [[ Pytanie 3.1 ]]
    // Użycie BeforeAll spowoduje błąd ze strony JUnita. Nie można użyć tej adnotacji,
    // ponieważ metoda setup() nie jest statyczna i klasa CalculatorTest nie ma adnotacji
    // @TestInstance(Lifecycle.PER_CLASS) (jeden z tych warunków musi być spełniony).
    // Jest to mechanizm zabezpieczający przed wpływem wyników jednego testu na inne.

    @Test
    void testAdd1() {
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    void testAdd2() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testAdd3() {
        assertEquals(0, calculator.add(-1, 1));
    }

    @Test
    void testMultiply1() {
        assertEquals(0, calculator.multiply(0, 0));
    }

    @Test
    void testMultiply2() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    void testMultiply3() {
        assertEquals(1, calculator.multiply(-1, -1));
    }

    @Test
    void testAddPositiveNumbers1() {
        assertThrows(IllegalArgumentException.class, () -> calculator.addPositiveNumbers(-3, 4));
    }

    @Test
    void testAddPositiveNumbers2() {
        assertEquals(7, calculator.addPositiveNumbers(3, 4));
    }
}