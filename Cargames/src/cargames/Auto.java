/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargames;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Matteo
 */
public class Auto extends Terreno {

    static int contatore = 3;
    int numero_auto;
    Circle c;
    GameArea parent;

    public Auto(GameArea parent) {
        super(parent);
        this.parent = parent;
        numero_auto = this.contatore--;
        c = new Circle(20, Color.RED);
        System.err.println(parent.addAuto.disableProperty().get());
        if (contatore >= 0) {
            if (parent.abilita_inserimento_auto==true) {
                this.getChildren().add(c);
                parent.label.setText("auto rimaste: " + Auto.contatore);
                parent.addAuto.setDisable(false);
                parent.abilita_inserimento_auto=false;
            } else {
                parent.addAuto.setDisable(true);
            }
        }

    }
}
