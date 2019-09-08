/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargames;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author Matteo
 */
public class Prato extends Terreno implements EventHandler<MouseEvent>{
    public Prato(GameArea parent){
        super(parent);
        rectangle.setFill(Color.GREEN);
    }

    @Override
    public void handle(MouseEvent event) {
                parent.getChildren().remove(this);

        //this.getChildren().add(new Strada(parent));
    }
}
