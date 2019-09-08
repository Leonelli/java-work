/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckyclick;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import static luckyclick.Header.punteggio;

/**
 *
 * @author Matteo
 */
public class Base extends Cella {

    boolean clickato;

    /**
     * costruttore dell'oggetto Base che eredita da cella
     */
    public Base() {
        super();
        clickato = false;
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (Header.tentativi > 0 && clickato == false) {
                    System.out.print(event.getSource());
                    text.setVisible(true);
                    text.setText(((Commons.R.nextInt(9) + 1) * 100) + "");
                    r.setFill(Color.WHITE);
                    int value = Integer.parseInt(text.getText());
                    Header.punteggio += value;
                    Header.punteggio_label.setText("PUNTEGGIO : " + Header.punteggio);
                    System.out.println("Header.punteggio: " + Header.punteggio);
                    clickato = true;
                }
            }
        });
    }
}
