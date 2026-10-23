package com.example.sem4_aplicatii;

import java.io.Serializable;

public class AMasina implements Serializable {

    private String marca;
    private String culoare;
    private boolean noua;
    private String combustibil;
    private float rating;

    private boolean automata;

    public AMasina(String marca, String culoare, boolean noua, String combustibil, boolean automata, float rating){
        this.marca = marca;
        this.culoare = culoare;
        this.noua = noua;
        this.combustibil = combustibil;
        this.automata = automata;
        this.rating = rating;
    }

    public String getMarca() { return marca; }
    public String getCuloare() { return culoare; }
    public boolean isNoua() { return noua; }
    public String getCombustibil() { return combustibil; }
    public float getRating() { return rating; }
    public boolean isAutomata() { return automata; }

    @Override
    public String toString() {
        return "AMasina{" +
                "marca='" + marca + '\'' +
                ", culoare='" + culoare + '\'' +
                ", noua=" + noua +
                ", combustibil='" + combustibil + '\'' +
                ", Rating: " + rating +
                ", automata=" + automata +
                '}';
    }
}
