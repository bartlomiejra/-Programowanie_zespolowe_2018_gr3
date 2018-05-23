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
public class Student {
     private final IntegerProperty id_studenta;
    private final StringProperty imie_s;
    private final StringProperty naziwsko_s;
    private final IntegerProperty pesel_s;
    private final StringProperty emial_s;
    private final StringProperty login_s;
    private final StringProperty haslo_s;
    private final StringProperty nr_albumu_s;
     private final IntegerProperty nr_tel_s;
    public Student(Integer id_studenta, String imie_s, String naziwsko_s, Integer pesel_s, String emial_s, String login_s, String haslo_s, String nr_albumu_s,Integer nr_tel_s) {
        this.id_studenta = new SimpleIntegerProperty(id_studenta);
        this.imie_s = new SimpleStringProperty(imie_s);
        this.naziwsko_s = new SimpleStringProperty(naziwsko_s);
        this.pesel_s = new SimpleIntegerProperty(pesel_s);
        this.emial_s = new SimpleStringProperty(emial_s);
        this.login_s = new SimpleStringProperty(login_s);
        this.haslo_s = new SimpleStringProperty(haslo_s);
        this.nr_albumu_s = new SimpleStringProperty(nr_albumu_s);
        this.nr_tel_s = new SimpleIntegerProperty(nr_tel_s);
        
    }

    
     public Integer getid_studenta(){
        return id_studenta.get();
    }
    public String getimie_s(){
        return imie_s.get();      
    }
    public String getnaziwsko_s(){
        return naziwsko_s.get();
    }
  
    public Integer getpesel_s(){
        return pesel_s.get();
    }
    public String getemial_s(){
        return emial_s.get();
    }
    public String getlogin_sn(){
        return login_s.get();
    }
       public String gethaslo_s(){
        return haslo_s.get();
    }
       public String getnr_albumu_s(){
        return nr_albumu_s.get();
    }
         public Integer getnr_tel_s(){
        return nr_tel_s.get();
    }
       
   
    
     public IntegerProperty id_studentaProperty() {
        return id_studenta;
     }
    public StringProperty imie_sProperty() {
        return imie_s;
    }
     public StringProperty naziwsko_sProperty() {
        return naziwsko_s;
    }
      public IntegerProperty pesel_sProperty() {
        return pesel_s;
    }
      public StringProperty emial_sProperty() {
        return emial_s;
    }
       public StringProperty login_sProperty() {
        return login_s;
    }
        public StringProperty haslo_sProperty() {
        return haslo_s;
    }
         public StringProperty nr_albumu_sProperty() {
        return nr_albumu_s;
    }
             public IntegerProperty nr_tel_sProperty() {
        return nr_tel_s;
     }
    
}

