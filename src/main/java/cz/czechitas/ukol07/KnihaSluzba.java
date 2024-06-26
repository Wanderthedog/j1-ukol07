package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class KnihaSluzba {
    private List<Kniha> seznamKnih;

    public KnihaSluzba() throws IOException {
        nactiKnihyZJson();
    }

    private void nactiKnihyZJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = KnihaSluzba.class.getResourceAsStream("knihy.json")) {
            seznamKnih = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        }
    }

    public List<Kniha> getSeznamKnih() {
        return seznamKnih;
    }

    public List<Kniha> getKnihyOdAutora(String autor) {
        List<Kniha> knihyOdAutora = new ArrayList<>();
        for (Kniha kniha : seznamKnih) {
            if (kniha.getAutor().equals(autor)) {
                knihyOdAutora.add(kniha);
            }
        }
        return knihyOdAutora;
    }

    public List<Kniha> getKnihyVRoce(int rok) {
        List<Kniha> knihyVRoce = new ArrayList<>();
        for (Kniha kniha : seznamKnih) {
            if (kniha.getRokVydani() == rok) {
                knihyVRoce.add(kniha);
            }
        }
        return knihyVRoce;
    }
}