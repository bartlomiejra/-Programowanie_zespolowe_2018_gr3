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
public class Loghistory {

    private final StringProperty login;
    private final StringProperty ostatnie_logowanie;


    public Loghistory(String login, String ostatnie_logowanie) {
        this.login = new SimpleStringProperty(login);
        this.ostatnie_logowanie = new SimpleStringProperty(ostatnie_logowanie);

    }

    public String getlogin_s() {
        return login.get();
    }

    public String getostatnie_logowanie() {
        return ostatnie_logowanie.get();
    }



    public StringProperty loginProperty() {
        return login;
    }

    public StringProperty ostatnie_logowanieProperty() {
        return ostatnie_logowanie;
    }


}
