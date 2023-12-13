### Pytanie 3.1

Użycie BeforeAll spowoduje błąd ze strony JUnita. Nie można użyć tej adnotacji,
ponieważ metoda setup() nie jest statyczna i klasa CalculatorTest nie ma adnotacji
@TestInstance(Lifecycle.PER_CLASS) (jeden z tych warunków musi być spełniony).
Jest to mechanizm zabezpieczający przed wpływem wyników jednego testu na inne.

### Pytanie 4.1

W przypadku testu test1() otrzymujemy Failure, ponieważ oczekiwana wartość jest różna od otrzymanej.
W przypadku testu test2() otrzymujemy Error, ponieważ w trakcie wykonywania testu wystąpił wyjątek NullPointerException.


### Pytanie 4.2

JUnit oczekuje obiektu typu AssertionFailedError.

### Pytanie 5.1

Testowanie z użyciem podejścia analizy ścieżek działania programu to testowanie whitebox.

### Pytanie 5.2

W metodzie calculate znajdują się 4 ścieżki działania.