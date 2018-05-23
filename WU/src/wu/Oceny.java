/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wu;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jacek
 */
public class Oceny {

       private final IntegerProperty  ocena;
 private final StringProperty nazwa_przedmiotu;
      private final StringProperty imie_s;
    private final StringProperty naziwsko_s;
    private final StringProperty imie_p;
    private final StringProperty nazwisko_p;
    
    
    public Oceny(Integer ocena, String nazwa_przedmiotu, String imie_s, String nazwisko_s, String imie_p, String nazwisko_p){
        this.ocena = new SimpleIntegerProperty(ocena);
        this.nazwa_przedmiotu = new SimpleStringProperty(nazwa_przedmiotu);
        this.imie_s = new SimpleStringProperty(imie_s);
        this.naziwsko_s = new SimpleStringProperty(nazwisko_s);
        this.imie_p = new SimpleStringProperty(imie_p);
        this.nazwisko_p = new SimpleStringProperty(nazwisko_p);
        
        
    }
     public Integer getocena(){
        return ocena.get();
    }
        public String getnazwa_przedmiotu(){
        return nazwa_przedmiotu.get();
    }
    public String getimie_s(){
        return imie_s.get();      
    }
    public String getnaziwsko_s(){
        return naziwsko_s.get();
    }

    public String getimie_p(){
        return imie_p.get();
    }
    public String getnazwisko_p(){
        return nazwisko_p.get();
    }
    
    
}
