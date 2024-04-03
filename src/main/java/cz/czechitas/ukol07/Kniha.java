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

    // Gettery a Settery ?? |musí být setter, jestli ho nebudu validovat?
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(int rokVydani) {
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
