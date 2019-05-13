/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;

/**
 *
 * @author Matteo
 */
public class ImmagineSlot extends Polyline{
    public ImmagineSlot (String figura){
       super();
       switch(figura){
           case "triangolo":
                this.getPoints().addAll(50.0, 0.0,  0.0, 50.0,
                100.0, 50.0, 50.0, 0.0);
                this.setFill(Color.WHITE);
                this.setStroke(Color.BLUE);
               break;
           case "parallelogramma":
               // Create an open Parallelogram
                this.getPoints().addAll(30.0, 0.0, 130.0, 0.0,
                        100.00, 50.0,0.0, 50.0);
                this.setFill(Color.YELLOW);
                this.setStroke(Color.BLACK);
                break;
           case "esagono":
               this.getPoints().addAll(100.0, 0.0,120.0, 20.0,
                120.0, 40.0,100.0, 60.0,80.0, 40.0, 80.0, 20.0,100.0, 0.0);
       }  
    }
}
