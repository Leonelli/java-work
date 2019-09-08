/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckyclick;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author Matteo
 */
public class Moltiplicatore extends Cella {

    boolean clickato;
    public Moltiplicatore() {
        super();
        clickato=false;
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (Header.tentativi > 0 && clickato == false) {
                    System.out.print(event.getSource());
                    text.setVisible(true);
                    text.setText("X2");
                    Header.punteggio = Header.punteggio * 2;
                    Header.punteggio_label.setText("PUNTEGGIO : " + Header.punteggio);
                    r.setFill(Color.GREEN);
                    clickato=true;
                }
            }
        });
    }
}
