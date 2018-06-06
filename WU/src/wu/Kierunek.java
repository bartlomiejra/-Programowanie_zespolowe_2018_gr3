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
public class Kierunek {

    private IntegerProperty id_specjalizacji;
    private IntegerProperty id_studenta;
    private StringProperty kierunek;
    private StringProperty rok;

    public Kierunek(Integer id_specjalizacji, Integer id_studenta, String kierunek, String rok) {
        this.id_specjalizacji = new SimpleIntegerProperty(id_specjalizacji);
        this.id_studenta = new SimpleIntegerProperty(id_studenta);
        this.kierunek = new SimpleStringProperty(kierunek);
        this.rok = new SimpleStringProperty(rok);

    }

    public Integer getid_specjalizacji() {
        return id_specjalizacji.get();
    }

    public Integer getid_studenta() {
        return id_studenta.get();
    }

    public String getkierunek() {
        return kierunek.get();
    }

    public String getrok() {
        return rok.get();
    }

    public IntegerProperty id_specjalizacjiProperty() {
        return id_specjalizacji;
    }

    public IntegerProperty id_studentaProperty() {
        return id_studenta;
    }

    public StringProperty kierunekProperty() {
        return kierunek;
    }

    public StringProperty rokProperty() {
        return rok;
    }
}
