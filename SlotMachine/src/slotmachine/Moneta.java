/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Matteo
 */
public class Moneta extends StackPane{
       public Moneta(){
           super();
           Circle cerchio = new Circle(35,Color.BLANCHEDALMOND);
           Label label = new Label("1 euro");
           this.getChildren().addAll(cerchio,label);
        }
}
