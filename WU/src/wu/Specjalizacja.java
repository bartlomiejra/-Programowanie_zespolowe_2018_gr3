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
public class Specjalizacja {

    private IntegerProperty id_specjalizacji;
    private StringProperty kierunek;
    private StringProperty rok;

    public Specjalizacja(Integer id_specjalizacji, String kierunek, String rok) {
        this.id_specjalizacji = new SimpleIntegerProperty(id_specjalizacji);
        this.kierunek = new SimpleStringProperty(kierunek);
        this.rok = new SimpleStringProperty(rok);

    }

    public Integer getid_specjalizacji() {
        return id_specjalizacji.get();
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

    public StringProperty kierunekProperty() {
        return kierunek;
    }

    public StringProperty rokProperty() {
        return rok;
    }
}
