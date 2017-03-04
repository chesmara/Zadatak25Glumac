package com.example.androiddevelopment.zadatak20glumac.model;

/**
 * Created by androiddevelopment on 13.2.17..
 */

public class Filmovi {

    private int id;
    private String nazivFilma;
    private Glumac glumac;
  //----------------------------------
    public Filmovi(){
        }
   //----------------------------------------------------------
    public Filmovi(int id, String nazivFilma, Glumac glumac) {
        this.id = id;
        this.nazivFilma = nazivFilma;
        this.glumac = glumac;
    }
   //---------------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivFilma() {
        return nazivFilma;
    }

    public void setNazivFilma(String nazivFilma) {
        this.nazivFilma = nazivFilma;
    }

    public Glumac getGlumac() {
        return glumac;
    }

    public void setGlumac(Glumac glumac) {
        this.glumac = glumac;
    }

    @Override
    public String toString() {
        return "Film:{" +
                " '" + nazivFilma + '\'' +
                '}';
    }
}
