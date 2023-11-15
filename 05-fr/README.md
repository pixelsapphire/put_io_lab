# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
## BC1: Sprzedaż aukcyjna

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego.

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([UC2](#uc2), [BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu. ([UC3](#uc3))
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu. ([UC4](#uc4))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę. ([BR1](#br1))
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


### Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC4](#uc4): Przekazanie produktu Kupującemu

[Kupujący](#ac2)
* [UC2](#uc2): Oferta ceny kupna produktu
* [UC3](#uc3): Przekazanie należności Sprzedającemu

---
<a id="uc1"></a>
## UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję. 
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
## UC2: Oferta ceny kupna produktu

**Aktorzy:** [Kupujący](#ac2), [Sprzedający](#ac1)

**Scenariusz główny:**
1. System pokazuje [Kupującemu](#ac2) informację o aktualnej cenie wywoławczej i prosi o podanie oferowanej kwoty.
2. [Kupujący](#ac2) podaje oferowaną kwotę.
3. System weryfikuje poprawność danych.
4. System informuje [Kupującego](#ac2) i [Sprzedającego](#ac1) o pomyślnym złożeniu oferty.

**Scenariusze alternatywne:** 

3.A. Podano nieprawidłową kwotę. ([BR1](#br1))
* 3.A.1. System informuje o błędnie podanych danych.
* 3.A.2. Przejdź do kroku 1.

---

<a id="uc3"></a>
## UC3: Przekazanie należności Sprzedającemu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System daje [Kupującemu](#ac2) możliwość wyboru sposobu płatności.
2. [Kupujący](#ac2) wybiera sposób płatności.
3. System przekierowuje [Kupującego](#ac2) do wybranego systemu płatności.
4. [Kupujący](#ac2) dokonuje płatności w wybranym systemie.
5. System przyjmuje informację o pomyślnym zakończeniu płatności.
6. System informuje [Sprzedającego](#ac1) o dokonaniu płatności.

**Scenariusze alternatywne:** 

1.A. ...
* 4.A.1. ...

---

<a id="uc4"></a>
## UC4: Przekazanie produktu Kupującemu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. ...

**Scenariusze alternatywne:** 

1.A. ...
* 4.A.1. ...

---

## Obiekty biznesowe (inaczej obiekty dziedzinowe lub informacyjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1.00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |

