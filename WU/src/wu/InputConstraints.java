/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wu;

/**
 *
 * @author Zbyszek
 */
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Jens Deters
 */
public class InputConstraints {

    private InputConstraints() {
        // not needed here
    }

    

    public static void numbersOnly(final TextField textField) {
        numbersOnly(textField, Integer.MAX_VALUE);
    }

    public static void numbersOnly(final TextField textField, final Integer maxLenth) {
        textField.addEventFilter(KeyEvent.KEY_TYPED, createNumbersOnlyInputHandler(maxLenth));
        textField.focusedProperty().addListener((Observable observable) -> {
            textField.setText(textField.getText().trim());
        });
    }
    
    public static void numbersOnlyP(final TextField textField) {
        numbersOnlyP(textField, Integer.MAX_VALUE);
    }

    public static void numbersOnlyP(final TextField textField, final Integer maxLenth) {
        textField.addEventFilter(KeyEvent.KEY_TYPED, createNumbersOnlyPInputHandler(maxLenth));
        textField.focusedProperty().addListener((Observable observable) -> {
            textField.setText(textField.getText().trim());
        });
    }

    public static void lettersOnly(final TextField textField) {
        lettersOnly(textField, Integer.MAX_VALUE);
    }

    public static void lettersOnly(final TextField textField, final Integer maxLenth) {
        textField.addEventFilter(KeyEvent.KEY_TYPED, createLettersOnlyInputHandler(maxLenth));
        textField.focusedProperty().addListener((Observable observable) -> {
            textField.setText(textField.getText().trim());
        });
    }



    public static EventHandler<KeyEvent> createNumbersOnlyInputHandler(final Integer maxLength) {
        return createPatternInputHandler(9, "[0-9.]");
    }
    public static EventHandler<KeyEvent> createNumbersOnlyPInputHandler(final Integer maxLength) {
        return createPatternInputHandler(11, "[0-9.]");
    }

    public static EventHandler<KeyEvent> createLettersOnlyInputHandler(final Integer maxLength) {
        return createPatternInputHandler(maxLength, "[A-Za-z]");
    }

   

    public static EventHandler<KeyEvent> createPatternInputHandler(final Integer maxLength, String pattern) {
        return (KeyEvent event) -> {
            if (event.getSource() instanceof TextField) {
                TextField textField = (TextField) event.getSource();
                if (textField.getText().length() >= maxLength || !event.getCharacter().matches(pattern)) {
                    event.consume();
                }
            }
        };
    }

}
