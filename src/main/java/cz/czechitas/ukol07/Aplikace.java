package cz.czechitas.ukol07;


import java.io.IOException;
import java.util.List;


public class Aplikace {

    public static void main(String[] args) {
        try {
            // Vytvoření instance třídy KnihaSluzba
            KnihaSluzba knihaSluzba = new KnihaSluzba();

            // Celkový počet knih v databázi
            List<Kniha> seznamKnih = knihaSluzba.getSeznamKnih();
            System.out.println("Celkový počet knih v databázi: " + seznamKnih.size());

            // Názvy knih napsané Karlem Čapkem
            System.out.println("Knihy napsané Karlem Čapkem:");
            List<Kniha> knihyKarlaCapka = knihaSluzba.getKnihyOdAutora("Karel Čapek");
            for (Kniha kniha : knihyKarlaCapka) {
                System.out.println(kniha.getNazev());
            }

            // Knihy vydané poprvé v roce 1845
            System.out.println("Knihy vydané poprvé v roce 1845:");
            List<Kniha> knihyVRoce1845 = knihaSluzba.getKnihyVRoce(1845);
            for (Kniha kniha : knihyVRoce1845) {
                System.out.println(kniha.getAutor() + ": " + kniha.getNazev());
            }
        } catch (IOException e) {
            System.err.println("Chyba při čtení dat: " + e.getMessage());
        }
    }
}
