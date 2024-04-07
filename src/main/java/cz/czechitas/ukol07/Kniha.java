package cz.czechitas.ukol07;

public class Kniha {
    private String autor;
    private String nazev;
    private int rokVydani;

    // Parametrizovaný konstruktor
    public Kniha(String autor, String nazev, int rokVydani) {
        this.autor = autor;
        this.nazev = nazev;
        this.rokVydani = rokVydani;
    }

    public Kniha() {
        // Default constructor
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("Autor nemůže být null nebo prázdný řetězec");
        }
        this.autor = autor;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        if (nazev == null || nazev.isEmpty()) {
            throw new IllegalArgumentException("Název nemůže být null nebo prázdný řetězec");
        }
        this.nazev = nazev;
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(int rokVydani) {
        if (rokVydani <= 1454 || rokVydani > 2024) {
            throw new IllegalArgumentException("Neplatný rok vydání");
        }
        this.rokVydani = rokVydani;
    }

    @Override
    public String toString() {
        return "Kniha{" +
                "autor='" + autor + '\'' +
                ", nazev='" + nazev + '\'' +
                ", rokVydani=" + rokVydani +
                '}';
    }
}
