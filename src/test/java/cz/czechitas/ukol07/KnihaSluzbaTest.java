package cz.czechitas.ukol07;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class KnihaSluzbaTest {

    private KnihaSluzba knihaSluzba;

    @BeforeEach
    void setUp() {
        try {
            knihaSluzba = new KnihaSluzba();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetSeznamKnih() {
        List<Kniha> seznamKnih = knihaSluzba.getSeznamKnih(); // Ověřuje, zda seznam knih není null a obsahuje nějaké knihy
        Assertions.assertNotNull(seznamKnih);
        Assertions.assertFalse(seznamKnih.isEmpty());
        assertEquals(14,seznamKnih.size());
    }

    @Test
    void testGetKnihyVRoce() {
        List<Kniha> knihyVRoce1845 = knihaSluzba.getKnihyVRoce(1845);   //Ověřuje, zda metoda getKnihyVRoce vrací seznam knih vydaných v daném roce.
        Assertions.assertNotNull(knihyVRoce1845);

        List<Kniha> knihy1954 = knihaSluzba.getKnihyVRoce(1954); // Ověřuje, zda vrácený seznam obsahuje správný počet knih pro daný rok.
        assertEquals(1, knihy1954.size());

        List<Kniha> neexistujiciRok = knihaSluzba.getKnihyVRoce(2000); // Ověřuje, že pokud je zadaný rok, který není v seznamu, vrátí prázdný seznam.
        assertEquals(0, neexistujiciRok.size());
    }

    @Test
    void testGetKnihyOdAutora() {
        List<Kniha> knihyCapek = knihaSluzba.getKnihyOdAutora("Karel Čapek"); //Ověřuje, zda metoda getKnihyOdAutora vrací seznam knih napsaných daným autorem.
        assertEquals(5, knihyCapek.size());

        List<Kniha> neexistujiciAutor = knihaSluzba.getKnihyOdAutora("Neexistující Autor");// Ověřuje, že pokud je zadaný autor, který není v seznamu, vrátí prázdný seznam.
        assertEquals(0, neexistujiciAutor.size());
    }

    @Test
    void setAutorIsNull() {
        Kniha kniha = new Kniha(); // Ověřuje, že volání metody setAutor s hodnotou null vyvolá výjimku
        assertThrows(IllegalArgumentException.class, () -> kniha.setAutor(null));
    }

    @Test
    void setAutorIsEmpty() { // Ověřuje, že volání metody setNazev s prázdným řetězcem vyvolá výjimku
        Kniha kniha = new Kniha();
        assertThrows(IllegalArgumentException.class, () -> kniha.setAutor(""));
    }

    @Test
    void setNazevIsNull() {//věřuje, že volání metody setNazev s hodnotou null vyvolá výjimku
        Kniha kniha = new Kniha();
        assertThrows(IllegalArgumentException.class, () -> kniha.setNazev(null));
    }

    @Test
    void setNazevIsEmpty() { //Oěřuje, že volání metody setNazev s prázdným řetězcem vyvolá výjimku
        Kniha kniha = new Kniha();
        assertThrows(IllegalArgumentException.class, () -> kniha.setNazev(""));
    }

    @Test
    void setNazevIsValid() { //Ověřuje, že volání metody setNazev s platným argumentem nevyvolá výjimku.
        Kniha kniha = new Kniha();
        assertDoesNotThrow(() -> kniha.setNazev("Název knihy"));
    }

    @Test
    void setRokVydaniIsMinus() { //Ověřuje, že volání metody setRokVydani s hodnotou záporného roku vyvolá výjimku
        Kniha kniha = new Kniha();
        assertThrows(IllegalArgumentException.class, () -> kniha.setRokVydani(-100));
    }

    @Test
    void setRokVydaniIsBefore1454() {//Ověřuje, že volání metody setRokVydani před rokem 1454 vyvola vyjimku
        Kniha kniha = new Kniha();
        assertThrows(IllegalArgumentException.class, () -> kniha.setRokVydani(1400));
    }

    @Test
    void setRokVydaniIsInFuture() {// Ověřuje, že volání metody setRokVydani s rokem v budoucnosti vyvolá výjimku
        Kniha kniha = new Kniha();
        assertThrows(IllegalArgumentException.class, () -> kniha.setRokVydani(2025));
    }

    @Test
    void setRokVydaniIsValid() {
        Kniha kniha = new Kniha();// Ověřuje, že volání metody setRokVydani s platným rokem nevyvolá výjimku.
        assertDoesNotThrow(() -> kniha.setRokVydani(1856));
    }
}


