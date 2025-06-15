/**
 * Główna klasa uruchamiająca aplikację sklepu.
 * Zawiera menu konsolowe umożliwiające wykonywanie operacji na magazynie i koszyku.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Sklep sklep = new Sklep();
        Scanner scanner = new Scanner(System.in);

        // Tworzenie klienta z domyślnym saldem
        Klient klient = new Klient("Jerzy", "Frącz", "jurek-f@gmail.com", false, 500.0);
        Koszyk koszyk = new Koszyk();

        boolean dziala = true;

        // Główna pętla menu
        while (dziala) {
            System.out.println("\n=== MENU SKLEPU ===");
            System.out.println("1. Przyjmij towar do magazynu");
            System.out.println("2. Wyświetl produkty w magazynie");
            System.out.println("3. Dodaj produkt do koszyka");
            System.out.println("4. Pokaż koszyk");
            System.out.println("5. Dokonaj zakupu (Sklep uwzględnia rabat dla stałych klientów)");
            System.out.println("6. Wyjście");
            System.out.print("Wybierz opcję: ");
            String wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    try {
                        System.out.print("Nazwa produktu: ");
                        String nazwa = scanner.nextLine();
                        System.out.print("Cena: ");
                        double cena = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ilość: ");
                        int ilosc = Integer.parseInt(scanner.nextLine());

                        sklep.przyjmijTowar(new Produkt(nazwa, cena, ilosc));
                        System.out.println("Dodano produkt do magazynu!");
                    } catch (NumberFormatException e) {
                        System.out.println("Błąd: Nieprawidłowy format liczby.");
                    }
                    break;

                case "2":
                    sklep.pokazMagazyn();
                    break;

                case "3":
                    sklep.pokazMagazyn();
                    try {
                        System.out.print("Podaj indeks produktu do dodania do koszyka: ");
                        int indeks = Integer.parseInt(scanner.nextLine());
                        Produkt p = sklep.pobierzZMagazynu(indeks);

                        if (p != null) {
                            System.out.print("Podaj ilość do zakupu: ");
                            int iloscZakupu = Integer.parseInt(scanner.nextLine());

                            if (iloscZakupu > 0 && iloscZakupu <= p.getIlosc()) {
                                koszyk.dodajProdukt(new Produkt(p.getNazwa(), p.getCena(), iloscZakupu));
                                p.zmniejszIlosc(iloscZakupu);
                                System.out.println("Dodano produkt/y do koszyka");
                            } else {
                                System.out.println("Nieprawidłowa ilość.");
                            }
                        } else {
                            System.out.println("Nieprawidłowy indeks.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Błąd: Podano nieprawidłowy numer.");
                    }
                    break;

                case "4":
                    koszyk.wyswietlKoszyk();
                    break;

                case "5":
                    double rabat = klient.getRabat();
                    double sumaZakupu = koszyk.obliczWartosc() * rabat;

                    if (klient.getPortfel().getSaldo() >= sumaZakupu) {
                        klient.getPortfel().zmniejszSaldo(sumaZakupu);
                        System.out.println("Zakup udany! Całkowity koszt (po rabacie): " +
                                String.format("%.2f", sumaZakupu) + " zł");
                        System.out.println("Nowe saldo klienta: " + klient.getPortfel().toString());
                        koszyk.oproznijKoszyk();
                    } else {
                        System.out.println("Nie masz wystarczających środków na koncie.");
                    }
                    break;

                case "6":
                    dziala = false;
                    break;

                default:
                    System.out.println("Nieprawidłowy wybór.");
            }
        }

        scanner.close();
    }
}
