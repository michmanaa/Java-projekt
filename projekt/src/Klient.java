/**
 * Klasa reprezentująca klienta sklepu. Dziedziczy po klasie Osoba.
 */
public class Klient extends Osoba {
    private String email;
    private boolean czyStalyKlient;
    private Portfel portfel;

    public Klient(String imie, String nazwisko, String email, boolean czyStalyKlient, double saldo) {
        super(imie, nazwisko);
        this.email = email;
        this.czyStalyKlient = czyStalyKlient;
        this.portfel = new Portfel(saldo);
    }

    public boolean isStalyKlient() {
        return czyStalyKlient;
    }

    public Portfel getPortfel() {
        return portfel;
    }

    public double getRabat() {
        return czyStalyKlient ? 0.95 : 1.0; // 5% rabatu dla stałego klienta
    }

    public void pomniejszSaldoPoRabacie(double kwota) {
        double kwotaPoRabacie = kwota * getRabat();
        portfel.zmniejszSaldo(kwotaPoRabacie);
    }

    public String toString() {
        return super.toString() + " | Email: " + email + " | " +
                (czyStalyKlient ? "Stały klient (5% rabatu)" : "Klient detaliczny") + " | " + portfel;
    }
}