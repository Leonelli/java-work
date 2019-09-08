/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargames;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matteo
 */
public class Strada extends Terreno implements EventHandler<MouseEvent> {

    public Strada(GameArea parent) {
        super(parent);
        this.setOnMouseClicked(this);

        rectangle.setFill(Color.GREY);
                this.setOnMouseClicked(this);

    }

    @Override
    public void handle(MouseEvent event) {
        parent.getChildren().remove(this);
        this.getChildren().add(new Auto(parent));
        System.err.println("Hai fatto click su " + event.getSource());
        //this.getChildren().add(new Prato(parent));
    }
}
