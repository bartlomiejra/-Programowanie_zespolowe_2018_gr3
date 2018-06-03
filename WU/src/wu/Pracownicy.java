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
public class Pracownicy {

    private  IntegerProperty id_pracownika;
    private  StringProperty imie_p;
    private  StringProperty nazwisko_p;
    private  IntegerProperty pesel_p;
    private  StringProperty email_p;
    private  StringProperty data_urodzenia_p;
    private  IntegerProperty nr_tel_p;
    private  StringProperty login_p;
    private  StringProperty haslo_p;
    private  StringProperty specjalizacja_p;
    

    public Pracownicy( String imie_p, String nazwisko_p, Integer pesel_p, String email_p, String data_urodzenia_p, Integer nr_tel_p, String login_p,  String haslo_p, String specjalizacja_p) {
        this.imie_p = new SimpleStringProperty(imie_p);
        this.nazwisko_p = new SimpleStringProperty(nazwisko_p);
        this.pesel_p = new SimpleIntegerProperty(pesel_p);
        this.email_p = new SimpleStringProperty(email_p);
        this.data_urodzenia_p = new SimpleStringProperty(data_urodzenia_p);
        this.nr_tel_p = new SimpleIntegerProperty(nr_tel_p);
        this.login_p = new SimpleStringProperty(login_p);
        this.haslo_p = new SimpleStringProperty(haslo_p);
        this.specjalizacja_p = new SimpleStringProperty(specjalizacja_p);

    }
    
    public Pracownicy( Integer id_pracownika, String imie_p, String nazwisko_p) {
        this.id_pracownika = new SimpleIntegerProperty(id_pracownika);
        this.imie_p = new SimpleStringProperty(imie_p);
        this.nazwisko_p = new SimpleStringProperty(nazwisko_p);
        

    }
    // Konstruktor pracownicy admin 
    public Pracownicy( Integer id_pracownika, String imie_p, String nazwisko_p, Integer pesel_p, String email_p, String data_urodzenia_p, Integer nr_tel_p, String login_p,  String haslo_p, String specjalizacja_p) {
        this.id_pracownika = new SimpleIntegerProperty(id_pracownika);
        this.imie_p = new SimpleStringProperty(imie_p);
        this.nazwisko_p = new SimpleStringProperty(nazwisko_p);
        this.pesel_p = new SimpleIntegerProperty(pesel_p);
        this.email_p = new SimpleStringProperty(email_p);
        this.data_urodzenia_p = new SimpleStringProperty(data_urodzenia_p);
        this.nr_tel_p = new SimpleIntegerProperty(nr_tel_p);
        this.login_p = new SimpleStringProperty(login_p);
        this.haslo_p = new SimpleStringProperty(haslo_p);
        this.specjalizacja_p = new SimpleStringProperty(specjalizacja_p);

    }

    public String getimie_p() {
        return imie_p.get();
    }
    public String getnazwisko_p() {
        return nazwisko_p.get();
    }
    public Integer getpesel_p() {
        return pesel_p.get();
    }
    public String getemail_p() {
        return email_p.get();
    }
    public String getdata_urodzenia_p() {
        return data_urodzenia_p.get();
    }
    public Integer getnr_tel_p() {
        return nr_tel_p.get();
    }
    public String getlogin_p() {
        return login_p.get();
    }
    public String gethaslo_p() {
        return haslo_p.get();
    }
    public String getspecjalizacja_p() {
        return specjalizacja_p.get();
    }
    public Integer getid_pracownika() {
        return id_pracownika.get();
    }
    
    

    public StringProperty imie_pProperty() {
        return imie_p;
    }

    public StringProperty nazwisko_pProperty() {
        return nazwisko_p;
    }

    public IntegerProperty pesel_pProperty() {
        return pesel_p;
    }
    
    public StringProperty email_pProperty() {
        return email_p;
    }
    
    public StringProperty data_urodzenia_pProperty() {
        return data_urodzenia_p;
    }

    public IntegerProperty nr_tel_pProperty() {
        return nr_tel_p;
    }
    
    public StringProperty login_pProperty() {
        return login_p;
    }
    
    public StringProperty haslo_pProperty() {
        return haslo_p;
    }
    
    public StringProperty specjalizacja_pProperty() {
        return specjalizacja_p;
    }
    public IntegerProperty id_pracownikaProperty() {
        return id_pracownika;
    }
    
}
