/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Matteo
 */
public class Carta extends StackPane implements Comparable {
    int numero;
    Seme seme;
    Rectangle contenitore;
    
    public Carta(int numero, Seme seme){
        this.seme= seme;
        this.numero= numero;
        contenitore = new Rectangle(50,50);
        contenitore.setFill(Color.AQUAMARINE);
        contenitore.setStroke(Color.BLACK);
        Text text = new Text(numero+" "+seme);
        
        this.getChildren().addAll(contenitore,text);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return numero + " - " + seme;
    }

    @Override
    public int compareTo(Object o) {
           if(this.numero > ((Carta)o).numero){
               return 1;
           }
           else 
           {
               return -1;
           }
           /*if(this.seme < ((Carta)o).seme){
               {
                   return 1;
               }
               else{
                   return -1;
               }
           }*/
    }

   
    
    
    
}
