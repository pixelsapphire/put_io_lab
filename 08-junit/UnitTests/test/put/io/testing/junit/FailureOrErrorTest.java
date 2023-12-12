package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FailureOrErrorTest {

    @Test
    void test1() {
        assertEquals(0, 1);
    }

    @Test
    void test2() {
        assertEquals(0, ((String) null).length());
    }

    // [[ Pytanie 4.1 ]]
    // W przypadku testu test1() otrzymujemy Failure, ponieważ oczekiwana wartość jest różna od otrzymanej.
    // W przypadku testu test2() otrzymujemy Error, ponieważ w trakcie wykonywania testu wystąpił wyjątek NullPointerException.

    @Test
    void test3() {
        try {
            assertEquals(0, 1);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    // [[ Pytanie 4.2 ]]
    // JUnit oczekuje obiektu typu AssertionFailedError.
}