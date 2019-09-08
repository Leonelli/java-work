/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.disi.leonelli.esame_201706;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matteo
 */


public class Casella extends StackPane{
    
    final int DIM = 50;
    int i;
    int j;
    Rectangle square;
    Pezzo pezzo;
    Casella casella;

    
        Casella(EventHandler<MouseEvent> cellController, int i, int j) {
            this.i=i;
            this.j=j;
            square=new Rectangle(DIM,DIM);
            square.setFill(Color.WHITE);
            square.setStroke(Color.BLACK);
            this.getChildren().add(square);
            this.addEventHandler(MouseEvent.MOUSE_CLICKED, cellController);
        }
        
        
        void setPezzo(Pezzo p){
        if (pezzo==null) {
            pezzo=p;
            p.setCasella(this);
            this.getChildren().add(pezzo);
            System.out.println(pezzo);
        }
        else{
            removePezzo();
        }
    }
        
         void removePezzo() {
        this.getChildren().remove(pezzo);
        pezzo=null;
    }
        
}
