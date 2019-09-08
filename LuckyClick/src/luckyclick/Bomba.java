/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckyclick;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Matteo
 */
public class Bomba extends Cella {
    boolean clickato;
    
    public Bomba() {
        super();
        clickato = false;
        Bomba b = this;
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("riga " + GridPane.getRowIndex(b));
                System.out.println("colonna " + GridPane.getColumnIndex(b));
                
                if (Header.tentativi > 0 && clickato == false) {
                    System.out.print(event.getSource());
                    text.setVisible(true);
                    text.setText("BOOM");
                    r.setFill(Color.BLUE);
                    clickato = true;
                }
            }
        });
    }
}
