/**
 * Klasa reprezentująca pojedynczy produkt w sklepie.
 */
public class Produkt {
    private String nazwa;
    private double cena;
    private int ilosc;

    public Produkt(String nazwa, double cena, int ilosc) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    public void zmniejszIlosc(int iloscZakupu) {
        if (iloscZakupu > 0 && iloscZakupu <= this.ilosc) {
            this.ilosc -= iloscZakupu;
        } else {
            System.out.println("Nieprawidłowa ilość do zmniejszenia.");
        }
    }
    public Produkt(String nazwa, double cena) {
        this(nazwa, cena, 1); // domyślna ilość = 1
    }

    public String getNazwa() { return nazwa; }
    public double getCena() { return cena; }
    public int getIlosc() { return ilosc; }
    public void setIlosc(int ilosc) { this.ilosc = ilosc; }

    @Override
    public String toString() {
        return nazwa + " - " + cena + " zł, Ilość: " + ilosc;
    }
}