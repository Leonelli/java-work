/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargames;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matteo
 */
public class Terreno extends StackPane  {
    Rectangle rectangle;
    protected final GameArea parent;
    final int DIM = 50;
    
    public Terreno(GameArea parent){
         this.parent = parent;
        rectangle = new Rectangle(DIM,DIM);
        rectangle.setStroke(Color.BLACK);
        this.getChildren().add(rectangle);
    }    
    
}

