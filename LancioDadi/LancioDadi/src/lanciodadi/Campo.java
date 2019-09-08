/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanciodadi;

import java.util.ArrayList;
import java.util.Collections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 *
 * @author andre
 */
public class Campo extends StackPane{
    
    private int dadiAttivi;
    private HBox dadi;
    private ValueBox contatore;
    
    public Campo(ValueBox contatore) {
        super();
        this.contatore = contatore;
        this.setMaxSize(Commons.CENTERSIZE, Commons.CENTERSIZE);
        this.setMinSize(Commons.CENTERSIZE, Commons.CENTERSIZE);
        dadi = new HBox();
        dadi.setMaxWidth(3 * Commons.DIMDADO);
        dadi.setMaxHeight(Commons.DIMDADO);
        dadiAttivi = 0;
        Rectangle sfondo = new Rectangle(Commons.CENTERSIZE,Commons.CENTERSIZE);
        sfondo.setFill(Color.GREEN);
        this.getChildren().addAll(sfondo,dadi);
        StackPane.setAlignment(dadi, Pos.CENTER);
        
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
            @Override
            public void handle(Event event) {
                if(dadiAttivi < 3) {
                    mostraDado();
                }
            }
        });
    }
    
    public void mostraDado() {
        dadiAttivi++;
        dadi.getChildren().add(new Dado(Commons.R.nextInt(6) + 1, contatore, this));
        StackPane.setAlignment(dadi, Pos.CENTER);
    }
    
    public void showWin() {
        Alert finestra = new Alert(Alert.AlertType.INFORMATION);
        finestra.setContentText("Hai vinto!");
        finestra.show();
    }
    
    public boolean checkWin() {
        if(this.dadiAttivi < 3) 
            return false;
        ArrayList<Integer> valori = new ArrayList<>();
        for(Node e : dadi.getChildren()) {
            if(e instanceof Dado) {
                valori.add(((Dado) e).getScore());
            }
        }
        Collections.sort(valori);
        for(int i = 0; i < valori.size() - 1; i++) {
            if(valori.get(i) != valori.get(i + 1) - 1)
                return false;            
        }
        showWin();
        return true;
    }
    
    @Override
    public String toString() {
        String t = "";
        int i = 1;
        int somma = 0;
        for (Node e : dadi.getChildren()) {
            if (e instanceof Dado) {
                t += "Dado " + Integer.toString(i) + " vale " + ((Dado) e).getScore() + "\n";
                somma += ((Dado) e).getScore();
                i++;
            }
        }
        t += "il totale è " + somma;
        return t;
    }
}
