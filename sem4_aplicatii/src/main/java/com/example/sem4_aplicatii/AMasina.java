package com.example.sem4_aplicatii;

import android.os.Parcel;
import android.os.Parcelable;

public class AMasina implements Parcelable {

    private String marca;
    private String culoare;
    private boolean noua;
    private String combustibil;
    private float rating;
    private boolean automata;

    public AMasina(String marca, String culoare, boolean noua,
                   String combustibil, boolean automata, float rating) {
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

    protected AMasina(Parcel in) {
        marca = in.readString();
        culoare = in.readString();
        noua = in.readByte() != 0;
        combustibil = in.readString();
        automata = in.readByte() != 0;
        rating = in.readFloat();
    }

    public static final Creator<AMasina> CREATOR = new Creator<AMasina>() {
        @Override
        public AMasina createFromParcel(Parcel in) {
            return new AMasina(in);
        }

        @Override
        public AMasina[] newArray(int size) {
            return new AMasina[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(marca);
        dest.writeString(culoare);
        dest.writeByte((byte) (noua ? 1 : 0));
        dest.writeString(combustibil);
        dest.writeByte((byte) (automata ? 1 : 0));
        dest.writeFloat(rating);
    }

    @Override
    public String toString() {
        return "AMasina{" +
                "marca='" + marca + '\'' +
                ", culoare='" + culoare + '\'' +
                ", noua=" + noua +
                ", combustibil='" + combustibil + '\'' +
                ", rating=" + rating +
                ", automata=" + automata +
                '}';
    }
}