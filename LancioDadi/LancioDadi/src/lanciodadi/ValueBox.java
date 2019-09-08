/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanciodadi;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author andre
 */
class ValueBox extends VBox {
    
    private Text label;
    private TextField campo;
    private int n;
    
    public ValueBox(String s, int n) {
        super();
        label = new Text(s);
        campo = new TextField(Integer.toString(n));
        campo.setEditable(false);
        this.getChildren().addAll(label,campo);
        this.n = n;
    }
    
    //decremento il contatore
    public void decrementa() {
        n--;
        campo.setText(Integer.toString(n));
        if(n == 0) {
            Alert finestra = new Alert(AlertType.INFORMATION);
            finestra.setContentText("Hai perso");
            finestra.showAndWait();
        }
    }
    
    //incremento il contatore
    public void incrementa() {
        n++;
        campo.setText(Integer.toString(n));
    }
    
    
    public int getN() {
        return n;
    }
}
