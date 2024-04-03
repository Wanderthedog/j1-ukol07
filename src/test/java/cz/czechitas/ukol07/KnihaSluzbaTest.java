package cz.czechitas.ukol07;

import cz.czechitas.ukol07.Kniha;
import cz.czechitas.ukol07.KnihaSluzba;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


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
        List<Kniha> seznamKnih = knihaSluzba.getSeznamKnih();
        // Ověřte, zda seznam knih není null a obsahuje nějaké knihy
        Assertions.assertNotNull(seznamKnih);
        Assertions.assertFalse(seznamKnih.isEmpty());
    }

    @Test
    void testGetKnihyVRoce() {
        List<Kniha> knihyVRoce1845 = knihaSluzba.getKnihyVRoce(1845);
        // Ověřte, zda seznam knih vydaných v roce 1845 není null
        Assertions.assertNotNull(knihyVRoce1845);
        // Ověřte, zda seznam obsahuje nějaké knihy vydané v daném roce
        Assertions.assertFalse(knihyVRoce1845.isEmpty());
    }
}