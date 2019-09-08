/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoprilecarte;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 *
 * @author Matteo
 */
public class Tessera extends StackPane implements EventHandler<MouseEvent> {

    Casella casella ;
    Text text;
    Tipo tipo;
    public Tessera(String s, Scacchiera sc,Tipo tipo){
        this.tipo=tipo;
        this.text = new Text(s);
        this.getChildren().add(text);
    }

    void setCasella(Casella x) {
        casella=x;
    }
    
    @Override
    public void handle(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
