/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2019;


import java.util.ArrayList;
import java.util.Collection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Marco
 */

public class Casella extends StackPane{
    int x;
    int y;
    int i;
    Text sel;
    Pedina p;
    boolean occ = false;
    Collection<Casella> caselle;
    Collection<Pedina> pedine;
    Rectangle c = new Rectangle(50,50);
    
    public Casella(int x, int y, Text sel, Collection<Casella> caselle, Collection<Pedina> pedine){
        this.x=x;
        this.y=y;
        this.sel=sel;
        this.caselle=caselle;
        this.pedine=pedine;
        this.getChildren().add(c);
        this.setWidth(50);
        this.setHeight(50);
        colora();
        i=1;
        c.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                System.out.println(sel.getText());
                if(sel.getText()!="selected = none"){
                    System.out.println("Sto inserendo in "+x+" "+y);
                    inserisci(x,y,sel,caselle);
                    i++;
                }    
           } 
        });
    }
    
    
    
    public void colora(){
        if((x % 2==0)&&(y % 2==0)){
            c.setFill(Paint.valueOf("WHITE"));
        } else if(x % 2 == 0){
            c.setFill(Paint.valueOf("BLACK"));
        } else if((x % 2 != 0) && (y % 2 == 0)) {
            c.setFill(Paint.valueOf("BLACK"));
        } else {
            c.setFill(Paint.valueOf("WHITE"));
        }
    }
    
    public void inserisci(int x, int y, Text sel,Collection<Casella> caselle){
        System.out.println("Premuta casella "+x+" "+y);
        p = new Pedina(sel,x,y,caselle,pedine);
        Casella.this.getChildren().add(p);
    }
}