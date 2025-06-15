import java.util.ArrayList;
/**
 * Klasa reprezentująca sklep – zarządza magazynem i sprzedażą produktów.
 */
public class Sklep {
    private ArrayList<Produkt> magazyn = new ArrayList<>();

    public void przyjmijTowar(Produkt p) {
        magazyn.add(p);
    }

    public void pokazMagazyn() {
        for (int i = 0; i < magazyn.size(); i++) {
            System.out.println(i + ". " + magazyn.get(i));
        }
    }

    public Produkt pobierzZMagazynu(int index) {
        if (index >= 0 && index < magazyn.size()) {
            return magazyn.get(index);
        }
        return null;
    }

    public void usunZMagazynu(Produkt p) {
        magazyn.remove(p);
    }

    public void sprzedajZKoszyka(Klient klient, Koszyk koszyk, double rabat) {
        double suma = koszyk.obliczWartosc() * rabat; // Uwzględnienie rabatu

        if (klient.getPortfel().getSaldo() >= suma) {
            klient.getPortfel().zmniejszSaldo(suma);
            System.out.println("Zakup udany! Całkowity koszt (po rabacie): " + suma);
            koszyk.oproznijKoszyk();
        } else {
            System.out.println("Nie masz wystarczających środków na koncie.");
        }
    }
}