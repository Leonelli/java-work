/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.disi.leonelli.esame_201706;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Matteo
 */
public class Pezzo extends StackPane{
    Scacchiera s;
    Casella casella;
    
    public Pezzo(Scacchiera s){
        this.s = s;
        Circle c = new Circle(14,14,14);
        c.setFill(Color.BLUE);
        c.setStroke(Color.BLACK);
        this.getChildren().add(c);
    }
    
     void setCasella(Casella x) {
        casella=x;
    }

}
