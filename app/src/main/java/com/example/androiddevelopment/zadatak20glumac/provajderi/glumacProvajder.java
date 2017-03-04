package com.example.androiddevelopment.zadatak20glumac.provajderi;

import android.app.ListActivity;

import com.example.androiddevelopment.zadatak20glumac.model.Filmovi;
import com.example.androiddevelopment.zadatak20glumac.model.Glumac;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by androiddevelopment on 13.2.17..
 */

public class glumacProvajder {

    public static Date setBirthDay(int y, int m, int d) {
    Calendar calendar1 = new GregorianCalendar();
    calendar1.set(y,m,d);
        Date brth = calendar1.getTime();
        return brth;
}

  public static List<Glumac> getGlumac(){

      List<Glumac> glumaci = new ArrayList<>();


           glumaci.add(new Glumac(0,"djuza.jpg", "Vlastimir Stoiljkovic", "Glumac bio 100 godina", 5, setBirthDay(1934,4,3), null ));

           glumaci.add(new Glumac(1,"nikola.jpg", "Nikola Simic", "Glumio u nebrojeno mnogo filmova i perdstava", 5, setBirthDay(1928,8,24), null ));

           glumaci.add(new Glumac(2,"paja.jpg", "Pavle Vujisic", "Najpoznatiji po seriji kamiondzije", 5, setBirthDay(1936,5,2), null ));

           glumaci.add(new Glumac(3,"ckalja.jpg", "Miodrag Petrovic", "Najpoznatiji po seriji kamiondzije i Vruc Vetar", 5, setBirthDay(1945,7,2), null ));


      return glumaci;
  }

    public static List<String> getImenaGlumaca(){

        List<String> imenaGlumaca = new ArrayList<>();
        imenaGlumaca.add("Vlastimir Stoiljkovic");
        imenaGlumaca.add("Nikola Simic");
        imenaGlumaca.add("Pavle Vujisic");
        imenaGlumaca.add("Miodrag Petrovic");

        return imenaGlumaca;
    }

    public static Glumac getGlumacById(int id){

        Glumac g;
        switch(id){
            case(0):
                g=new Glumac(0,"djuza.jpg", "Vlastimir Stoiljkovic", "Glumac bio 100 godina", 5, setBirthDay(1934,4,3), null );
                g.getFilmovi().add(new Filmovi(0,"Srecni ljudi",g));
                g.getFilmovi().add(new Filmovi(1,"Lepota poroka", g));
                g.getFilmovi().add(new Filmovi(2,"Lepota poroka 2", g));
                g.getFilmovi().add(new Filmovi(3,"Munje", g));
                break;
            case (1):
                g=new Glumac(1,"nikola.jpg", "Nikola Simic", "Glumio u nebrojeno mnogo filmova i perdstava", 5, setBirthDay(1928,8,24), null );
                g.getFilmovi().add(new Filmovi(0,"Bilo jednom jeda", g));
                g.getFilmovi().add(new Filmovi(1,"Lepota poroka4", g));
                g.getFilmovi().add(new Filmovi(2,"Lepota poroka", g));
                g.getFilmovi().add(new Filmovi(3,"Crna macka", g));
                break;
            case (2):
                g=new Glumac(2,"paja.jpg", "Pavle Vujisic", "Najpoznatiji po seriji kamiondzije", 5, setBirthDay(1936,5,2), null );
                g.getFilmovi().add(new Filmovi(0,"Lepota poroka 6", g));
                g.getFilmovi().add(new Filmovi(1,"Lepota poroka 7", g));
                break;
            case (3):
                g=new Glumac(3,"ckalja.jpg", "Miodrag Petrovic", "Najpoznatiji po seriji kamiondzije i Vruc Vetar", 5, setBirthDay(1945,7,2), null );
                g.getFilmovi().add(new Filmovi(0,"Kamiondzije 1", g));
                g.getFilmovi().add(new Filmovi(1,"Kamiondzije poroka", g));
                break;
            default:
                g=null;

        }return g;

    }


}
