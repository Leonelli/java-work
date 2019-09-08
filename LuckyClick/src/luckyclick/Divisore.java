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
public class Divisore extends Cella {

    boolean clickato;
    public Divisore() {
        super();
        clickato=false;
        
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.err.println("clickato: "+clickato);
                if (Header.tentativi > 0 && clickato == false) {
                    System.out.print(event.getSource());
                    text.setVisible(true);
                    text.setText("/2");
                    Header.punteggio = Header.punteggio / 2;
                    Header.punteggio_label.setText("PUNTEGGIO : " + Header.punteggio);
                    r.setFill(Color.RED);
                    clickato=true;
                }
            }
        });
    }
}
