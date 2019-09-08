/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2019;

import java.util.Collection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author Marco
 */
public class Bottone extends Button{
    String quale;
    Text sel;
    Collection<Pedina> pedine;
    Collection<Casella> caselle;
    
    public Bottone(String quale, Text sel, Collection<Pedina> pedine, Collection<Casella> caselle){
        this.quale=quale;
        this.setText(quale);
        this.sel=sel;
        this.pedine=pedine;
        this.caselle=caselle;
        
        
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                if(quale=="Reset"){
                    reset();
                }else if(quale=="Pedone"){
                        pedone();
                } else if(quale=="Torre"){
                        torre();
                } else if(quale=="Alfiere"){
                        alfiere();
                }
            }
        });
        
        this.setOnKeyTyped(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent e){
                if(e.getCharacter().equals("r")){
                    reset();
                } else if(e.getCharacter().equals("p")){
                        pedone();
                } else if(e.getCharacter().equals("t")){
                        torre();
                } else if(e.getCharacter().equals("a")){
                        alfiere();
                }
            }
        });    
    }
    
    public void reset(){
        System.out.println("Selezionato reset");
        sel.setText("selected = none");
        pedine.clear();
        for(Casella c:caselle){
            c.getChildren().remove(c.p);
        }
    }
    
    public void pedone(){
        System.out.println("Selezionato pedone");
        sel.setText("selected = PEDONE");
    }
    
    public void torre(){
        System.out.println("Selezionato torre");
        sel.setText("selected = TORRE");
    }
    
    public void alfiere(){
        System.out.println("Selezionato alfiere");
        sel.setText("selected = ALFIERE");
    }
}
