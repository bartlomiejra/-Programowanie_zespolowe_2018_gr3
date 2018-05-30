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
public class Przedmioty {

    private IntegerProperty id_przedmiotu;
    private StringProperty nazwa_przedmiotu;

    public Przedmioty(Integer id_przedmiotu, String nazwa_przedmiotu) {
        this.id_przedmiotu = new SimpleIntegerProperty(id_przedmiotu);
        this.nazwa_przedmiotu = new SimpleStringProperty(nazwa_przedmiotu);

    }

    public Integer getid_przedmiotu() {
        return id_przedmiotu.get();
    }

    public String getnazwa_przedmiotu() {
        return nazwa_przedmiotu.get();
    }

    public IntegerProperty id_przedmiotuProperty() {
        return id_przedmiotu;
    }

    public StringProperty nazwa_przedmiotuProperty() {
        return nazwa_przedmiotu;
    }

}
