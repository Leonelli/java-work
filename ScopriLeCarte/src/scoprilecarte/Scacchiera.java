/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoprilecarte;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Matteo
 */
public class Scacchiera extends GridPane {

    int DIM = 4;
    Casella[][] caselle;

    public Scacchiera(EventHandler<MouseEvent> cellController) {
        caselle = new Casella[DIM][DIM];

        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                caselle[i][j] = new Casella(cellController, i, j);
                this.add(caselle[i][j], i, j);
            }
        }
    }
}
