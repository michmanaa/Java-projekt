/**
 * Klasa bazowa reprezentująca osobę (imię i nazwisko).
 */
public class Osoba {
    protected String imie;
    protected String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String toString() {
        return imie + " " + nazwisko;
    }
}