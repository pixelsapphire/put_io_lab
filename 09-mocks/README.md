### Pytanie 2.1

W obiekcie zastępczym możnaby dodać prywatne pole `connected` typu `boolean`, które byłoby ustawiane na `true` w momencie wywołania metody `connect()` i na `false` w momencie wywołania metody `close()` oraz posiadało publiczny getter `isConnected()`. Podczas testu należałoby zweryfikować czy przed i po wywołaniu metody `loadExpenses()` metoda `isConnected()` zwraca `false`.