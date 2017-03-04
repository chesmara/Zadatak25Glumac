package com.example.androiddevelopment.zadatak20glumac.model;

import android.opengl.GLU;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by androiddevelopment on 13.2.17..
 */

public class Glumac {

    private int id;
    private String slika;
    private String imePrezime;
    private String biografija;
    private float ocena;
    private Date datumRodjenja;
    private Date datumSmriti;

    private ArrayList<Filmovi> filmovi;


    public Glumac(){
        filmovi=new ArrayList<>();

    }

    public Glumac(int id, String slika, String imePrezime, String biografija, float ocena, Date datumRodjenja, Date datumSmriti) {
        this.id = id;
        this.slika = slika;
        this.imePrezime = imePrezime;
        this.biografija = biografija;
        this.ocena = ocena;
        this.datumRodjenja = datumRodjenja;
        this.datumSmriti = datumSmriti;

        filmovi=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Date getDatumSmriti() {
        return datumSmriti;
    }

    public void setDatumSmriti(Date datumSmriti) {
        this.datumSmriti = datumSmriti;
    }

    public ArrayList<Filmovi> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(ArrayList<Filmovi> filmovi) {
        this.filmovi = filmovi;
    }

    @Override
    public String toString() {
        return "Glumac{" +
                "imePrezime='" + imePrezime + '\'' +
                '}';
    }


}
