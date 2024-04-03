package cz.czechitas.ukol07;


import java.io.IOException;
import java.util.List;


public class Aplikace {

    public static void main(String[] args) {
        try {
            KnihaSluzba knihaSluzba = new KnihaSluzba(); // instance třídy KnihaSluzba

            List<Kniha> seznamKnih = knihaSluzba.getSeznamKnih(); // Celkový počet knih v databázi
            System.out.println("Celkový počet knih v databázi: " + seznamKnih.size());
            System.out.println("Knihy, které napsal Karel Čapek:"); // Vypište do konzole názvy všech knížek, které napsal Karel Čapek.
            List<Kniha> knihyKarlaCapka = knihaSluzba.getKnihyOdAutora("Karel Čapek");
            for (Kniha kniha : knihyKarlaCapka) {
                System.out.println(kniha.getNazev());
            }
            System.out.println("Knihy vydané poprvé v roce 1845:");  // Vypište všechny knížky vydané poprvé v roce 1845
            List<Kniha> knihyVRoce1845 = knihaSluzba.getKnihyVRoce(1845);
            for (Kniha kniha : knihyVRoce1845) {
                System.out.println(kniha.getAutor() + ": " + kniha.getNazev());
            }
        } catch (IOException e) {
            System.err.println("Chyba při čtení dat: " + e.getMessage());
        }
    }
}
