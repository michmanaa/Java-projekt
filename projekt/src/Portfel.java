import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * Klasa reprezentująca portfel klienta, zawiera saldo i operacje finansowe.
 */
public class Portfel {
    private BigDecimal saldo;

    public Portfel(double saldo) {
        this.saldo = BigDecimal.valueOf(saldo).setScale(2, RoundingMode.HALF_UP);
    }

    public boolean zaplac(double kwota) {
        BigDecimal kwotaBD = BigDecimal.valueOf(kwota).setScale(2, RoundingMode.HALF_UP);
        if (kwotaBD.compareTo(saldo) <= 0) {
            saldo = saldo.subtract(kwotaBD);
            return true;
        }
        return false;
    }

    public void dodajSrodki(double kwota) {
        saldo = saldo.add(BigDecimal.valueOf(kwota).setScale(2, RoundingMode.HALF_UP));
    }

    public void zmniejszSaldo(double kwota) {
        BigDecimal kwotaBD = BigDecimal.valueOf(kwota).setScale(2, RoundingMode.HALF_UP);
        if (kwotaBD.compareTo(saldo) <= 0) {
            saldo = saldo.subtract(kwotaBD);
        } else {
            System.out.println("Nieprawidłowa kwota do odjęcia.");
        }
    }

    public double getSaldo() {
        return saldo.doubleValue();
    }

    public String toString() {
        return "Saldo: " + saldo.setScale(2, RoundingMode.HALF_UP) + " zł";
    }
}
