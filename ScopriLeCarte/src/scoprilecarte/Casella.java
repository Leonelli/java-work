/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoprilecarte;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matteo
 */
public class Casella extends StackPane {

    Rectangle square;
    int i;
    int j;

    public Casella(EventHandler<MouseEvent> cellController, int i, int j) {
        this.i = i;
        this.j = j;

        square = new Rectangle(50, 50);
        square.setFill(Color.YELLOW);
        square.setStroke(Color.BLACK);
        this.getChildren().add(square);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, cellController);

    }
    Tessera tessera;

    void setPezzo(Tessera t) {
        if (tessera == null) {
            tessera = t;
            t.setCasella(this);
            this.getChildren().add(tessera);
            System.out.println(tessera);
        } 
        if (Tipo.P == t.tipo) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Peccato hai perso");
            alert.setContentText("mi spiace!");
                        
            System.out.println("Peccato hai perso");

            alert.showAndWait();
            
            Platform.exit();

        } 
        else if(Tipo.V==tessera.tipo){
             Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Complimenti hai vinto");
            alert.setContentText("Bravo!");
            alert.showAndWait();
            
            System.out.println("Complimenti hai vinto");
            //punti++;

            
        }
        else {
            Copri();
        }
    }

    void Copri() {
        this.getChildren().remove(tessera);
        tessera = null;
    }
}
