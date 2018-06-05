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
private final IntegerProperty id_oceny;
    private final IntegerProperty ocena;
    private final StringProperty nazwa_przedmiotu;
    private final StringProperty student;
    private final StringProperty prowadzacy;

    public Oceny(Integer id_oceny,Integer ocena, String nazwa_przedmiotu, String student, String prowadzacy) {
       this.id_oceny = new SimpleIntegerProperty(id_oceny);
        this.ocena = new SimpleIntegerProperty(ocena);
        this.nazwa_przedmiotu = new SimpleStringProperty(nazwa_przedmiotu);
        this.student = new SimpleStringProperty(student);
        this.prowadzacy = new SimpleStringProperty(prowadzacy);

    }
    
 public Integer getid_oceny() {
        return id_oceny.get();
    }

    public Integer getocena() {
        return ocena.get();
    }

    public String getnazwa_przedmiotu() {
        return nazwa_przedmiotu.get();
    }

    public String getStudent() {
        return student.get();
    }

    public String getProwadzacy() {
        return prowadzacy.get();
    }

    public IntegerProperty id_ocenyProperty() {
        return id_oceny;
    }

    public IntegerProperty ocenaProperty() {
        return ocena;
    }

    public StringProperty nazwa_przedmiotuProperty() {
        return nazwa_przedmiotu;
    }

    public StringProperty studentProperty() {
        return student;
    }

    public StringProperty prowadzacyProperty() {
        return prowadzacy;
    }

}
