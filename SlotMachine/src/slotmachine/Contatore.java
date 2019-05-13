/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matteo
 */
public class Contatore extends VBox{
    
    public Contatore(String name,Integer value){
        TextField campotesto = new TextField();
        campotesto.setText(value.toString());
        campotesto.setEditable(false);
        Label label = new Label();
        label.setText(name);
        this.getChildren().addAll(label,campotesto);
    }
}
