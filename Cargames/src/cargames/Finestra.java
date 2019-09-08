/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargames;

import com.sun.javafx.print.Units;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class Finestra extends BorderPane {

    BorderPane borderpane;

    public Finestra() {

        Button down = new Button("Down");
        Button up = new Button("Up");
        Button right = new Button("Right");
        Button left = new Button("Left");

        BorderPane.setAlignment(down, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(up, Pos.TOP_CENTER);
        BorderPane.setAlignment(right, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(left, Pos.CENTER_LEFT);
        
        this.setBottom(down);
        this.setTop(up);
        this.setRight(right);
        this.setLeft(left);
        
        up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.err.println("click su up");
//Scacchiera.campo[1][1] = null;
            }
        });

    }
}
