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
public class Harmonogram {

    private final IntegerProperty idHarmonogramu;
    private final StringProperty idPrzedmiotu;
    private final StringProperty idPracownika;
    private final StringProperty Data;
    private final StringProperty Godzina;
    private final StringProperty kierunek;
    private final IntegerProperty rok;

    public Harmonogram(Integer idHarmonogramu, String idPrzedmiotu, String idPracownika, String Data, String Godzina, String kierunek, Integer rok) {
        this.idHarmonogramu = new SimpleIntegerProperty(idHarmonogramu);
        this.idPrzedmiotu = new SimpleStringProperty(idPrzedmiotu);
        this.idPracownika = new SimpleStringProperty(idPracownika);
        this.Data = new SimpleStringProperty(Data);
        this.Godzina = new SimpleStringProperty(Godzina);
        this.kierunek = new SimpleStringProperty(kierunek);
        this.rok = new SimpleIntegerProperty(rok);

    }

    public Integer getidHarmonogramu() {
        return idHarmonogramu.get();
    }

    public String getnazwa_idPrzedmiotu() {
        return idPrzedmiotu.get();
    }

    public String getidPracownika() {
        return idPracownika.get();
    }

    public String getData() {
        return Data.get();
    }

    public String getGodzina() {
        return Godzina.get();
    }

    public String getkierunek() {
        return kierunek.get();
    }

    public Integer getrok() {
        return rok.get();
    }

    public IntegerProperty idHarmonogramuProperty() {
        return idHarmonogramu;
    }

    public StringProperty idPrzedmiotuProperty() {
        return idPrzedmiotu;
    }

    public StringProperty idPracownikaProperty() {
        return idPracownika;
    }

    public StringProperty DataProperty() {
        return Data;
    }

    public StringProperty GodzinaProperty() {
        return Godzina;
    }

    public StringProperty kierunekProperty() {
        return kierunek;
    }

    public IntegerProperty rokProperty() {
        return rok;
    }

}
