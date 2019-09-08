/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckyclick;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matteo
 */
public class Header extends VBox {

    static public int tentativi = 100;
    static public int punteggio = 0;
    static public Label punteggio_label;
    static public Label tentativi_label;

    public Header() {
        punteggio_label = new Label("PUNTEGGIO : " + punteggio);
        tentativi_label = new Label("TENTATIVI : " + tentativi);
        this.getChildren().addAll(punteggio_label, tentativi_label);
    }
}
