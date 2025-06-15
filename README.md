# Projekt - System Zarządzania Sklepem Internetowym

## Opis
Aplikacja konsolowa napisana w Javie implementująca kompleksowy system zarządzania sklepem internetowym. Umożliwia:
- Zarządzanie magazynem produktów (CRUD)
- Obsługę koszyka zakupowego
- Realizację transakcji z uwzględnieniem rabatów
- Kontrolę stanów magazynowych

## Struktura aplikacji
- `Main` - klasa startowa z menu głównym
- `Produkt` - klasa reprezentująca produkt z polami: nazwa, cena, ilość
- `Koszyk` - klasa reprezentująca koszyk zakupowy z listą produktów (przykład kompozycji)
- `Sklep` - główna klasa zarządzająca operacjami na magazynie
- `Klient` - klasa reprezentująca klienta z możliwością rabatów
- `Portfel` - klasa zarządzająca środkami finansowymi klienta

## Kluczowe funkcjonalności

### Zarządzanie produktami
- Dodawanie nowych produktów do magazynu
- Przeglądanie pełnej listy produktów
- Aktualizacja stanów magazynowych
- Usuwanie produktów z systemu

### Obsługa transakcji
- Dodawanie produktów do koszyka
- Obliczanie wartości koszyka
- Realizacja zakupu z uwzględnieniem rabatów (5% dla stałych klientów)
- Kontrola stanu portfela klienta

### Walidacja danych
- Sprawdzanie dostępności produktów
- Kontrola poprawności wprowadzanych danych
- Obsługa błędów i wyjątków

### Przykładowe scenariusze
- Demonstracja relacji między koszykiem a produktami
- Symulacja procesu zakupowego

## Działanie
1. Uruchom klasę `Main`
2. Wybierz opcję z menu:
   - Dodaj nowy produkt (nazwa, cena, ilość)
   - Wyświetl listę produktów
   - Dodaj produkt do koszyka
   - Wyświetl zawartość koszyka
   - Dokonaj zakupu
   - Zakończ program

## Struktura danych
- Produkty przechowywane w `ArrayList` w klasie `Sklep`
- Koszyk jako `ArrayList` produktów
- Dane klienta przechowywane w obiekcie `Klient`

## Wymagania techniczne
- Java 17+
- Środowisko IDE (IntelliJ, Eclipse) lub narzędzia wiersza poleceń
- (Opcjonalnie) Maven 3.6+ do zarządzania zależnościami

## Autor
-Michał Mytych

-Uniwersytet Rzeszowski

-Informatyka i ekonometria  

-Rok akademicki: 2024/2025
