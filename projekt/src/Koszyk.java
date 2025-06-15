import java.util.ArrayList;
/**
 * Klasa reprezentująca koszyk klienta.
 */

public class Koszyk {
    private ArrayList<Produkt> produkty = new ArrayList<>();

    public void dodajProdukt(Produkt p) {
        produkty.add(p);
    }

    public double obliczLacznaCene() {
        double suma = 0;
        for (Produkt p : produkty) {
            suma += p.getCena() * p.getIlosc();
        }
        return suma;
    }

    // Dodana metoda obliczWartosc, zgodna z użyciem w klasie Sklep
    public double obliczWartosc() {
        return obliczLacznaCene();
    }

    public ArrayList<Produkt> getProdukty() {
        return produkty;
    }

    public void wyswietlKoszyk() {
        for (Produkt p : produkty) {
            System.out.println("- " + p);
        }
        System.out.println("Łączna cena: " + obliczLacznaCene() + " zł");
    }

    public void wyczysc() {
        produkty.clear();
    }

    // Dodana metoda oproznijKoszyk, aby uniknąć błędu w klasie Sklep
    public void oproznijKoszyk() {
        wyczysc();
    }
}
