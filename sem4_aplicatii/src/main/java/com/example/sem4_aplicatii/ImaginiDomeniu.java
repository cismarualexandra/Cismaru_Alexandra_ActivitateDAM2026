package com.example.sem4_aplicatii;

import android.graphics.Bitmap;

public class ImaginiDomeniu {
    private String textAfisat;
    private Bitmap imagine;
    private String link;

    public ImaginiDomeniu(String textAfisat, Bitmap imagine, String link) {
        this.textAfisat = textAfisat;
        this.imagine = imagine;
        this.link = link;
    }

    public String getTextAfisat() {
        return textAfisat;
    }

    public void setTextAfisat(String textAfisat) {
        this.textAfisat = textAfisat;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Bitmap getImagine() {
        return imagine;
    }

    public void setImagine(Bitmap imagine) {
        this.imagine = imagine;
    }

    @Override
    public String toString() {
        return "ImaginiDomeniu{" +
                "textAfisat='" + textAfisat + '\'' +
                ", imagine=" + imagine +
                ", link='" + link + '\'' +
                '}';
    }
}
