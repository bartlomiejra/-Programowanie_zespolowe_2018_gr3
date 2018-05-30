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

   
    private final StringProperty imie_s;
    private final StringProperty nazwisko_s;
    private final IntegerProperty pesel_s;
    private final StringProperty email_s;
    private final StringProperty data_urodzenia_s;
    private final IntegerProperty nr_tel_s;
    private final StringProperty login_s;
    private final StringProperty haslo_s;
    private final StringProperty nr_albumu_s;

    public Student(String imie_s, String nazwisko_s, Integer pesel_s, String email_s, String data_urodzenia_s, Integer nr_tel_s, String login_s, String haslo_s, String nr_albumu_s) {
       
        this.imie_s = new SimpleStringProperty(imie_s);
        this.nazwisko_s = new SimpleStringProperty(nazwisko_s);
        this.pesel_s = new SimpleIntegerProperty(pesel_s);
        this.email_s = new SimpleStringProperty(email_s);
        this.data_urodzenia_s = new SimpleStringProperty(data_urodzenia_s);
        this.nr_tel_s = new SimpleIntegerProperty(nr_tel_s);
        this.login_s = new SimpleStringProperty(login_s);
        this.haslo_s = new SimpleStringProperty(haslo_s);
        this.nr_albumu_s = new SimpleStringProperty(nr_albumu_s);

    }

    

    public String getimie_s() {
        return imie_s.get();
    }

    public String getnazwisko_s() {
        return nazwisko_s.get();
    }

    public Integer getpesel_s() {
        return pesel_s.get();
    }

    public String getemail_s() {
        return email_s.get();
    }
    public String getdata_urodzenia_s() {
        return data_urodzenia_s.get();
    }
    public Integer getnr_tel_s() {
        return nr_tel_s.get();
    }
    
    public String getlogin_s() {
        return login_s.get();
    }

    public String gethaslo_s() {
        return haslo_s.get();
    }

    public String getnr_albumu_s() {
        return nr_albumu_s.get();
    }

    

    

    public StringProperty imie_sProperty() {
        return imie_s;
    }

    public StringProperty nazwisko_sProperty() {
        return nazwisko_s;
    }

    public IntegerProperty pesel_sProperty() {
        return pesel_s;
    }

    public StringProperty email_sProperty() {
        return email_s;
    }
    public StringProperty data_urodzenia_sProperty() {
        return data_urodzenia_s;
    }
    public IntegerProperty nr_tel_sProperty() {
        return nr_tel_s;
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

}
