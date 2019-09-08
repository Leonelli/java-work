/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckyclick;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Matteo
 */
//todo abstract
abstract class Cella extends StackPane {

    Text text;
    Rectangle r;

    public Cella() {

        

        
        r = new Rectangle(Commons.DIMPEZZO, Commons.DIMPEZZO);
        r.setFill(Color.YELLOW);
        r.setStroke(Color.BLACK);
        text = new Text("100");
        text.setVisible(false);
        r.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (Header.tentativi == 0) {
                    Header.tentativi_label.setText("GAME OVER");
                } else {
                    Header.tentativi--;
                    Header.tentativi_label.setText("TENTATIVI : " + Header.tentativi);
                }
            }
        });
        this.getChildren().addAll(r, text);

    }

    @Override
    public String toString() {
        return "Cella{" + "text=" + text + "}";
    }
}
