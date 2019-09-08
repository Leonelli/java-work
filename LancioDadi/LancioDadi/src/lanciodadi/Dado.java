/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanciodadi;

import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author andre
 */
public class Dado extends StackPane {
    
    private int n;
    private ValueBox contatore;
    private GridPane punti;
    private Campo campo;
    
    public Dado(int n, ValueBox contatore, Campo campo) {
        super();
        this.setMaxSize(Commons.DIMDADO, Commons.DIMDADO);
        this.setMinSize(Commons.DIMDADO, Commons.DIMDADO);
        Rectangle  sfondo = new Rectangle(Commons.DIMDADO, Commons.DIMDADO);
        sfondo.setFill(Color.WHITE);
        sfondo.setStroke(Color.BLACK);
        punti = new GridPane();
        punti.setMaxSize(Commons.DIMPUNTO, Commons.DIMDADO);
        punti.setMinSize(Commons.DIMDADO, Commons.DIMDADO);
        punti.setAlignment(Pos.CENTER);
        for(int i = 0; i < 3; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100/3);
            punti.getColumnConstraints().add(colConst);
        }
        for(int i = 0; i < 3; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100/3);
            punti.getRowConstraints().add(rowConst);
        }
        this.getChildren().addAll(sfondo, punti);
        this.contatore = contatore;
        this.n = n;
        this.campo = campo;
        roll(n);
        contatore.incrementa();
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
        
            @Override
            public void handle(Event event) {
                if(contatore.getN() > 0) {
                    roll(Commons.R.nextInt(6) + 1);
                }
            }
            
        });
    }
    
    public int getScore() {
        return n;
    }
    
    public void roll(int n) {
        punti.getChildren().clear();
        this.n = n;
        ArrayList<StackPane> p = new ArrayList();
        for(int i = 0; i < 6; i++) {
            Circle cerchio = new Circle(Commons.DIMPUNTO);
            StackPane tmp = new StackPane();
            cerchio.setFill(Color.BLACK);
            tmp.getChildren().add(cerchio);
            p.add(tmp);
        }
        switch(n) {
            case 1:
                punti.add(p.get(0), 1, 1);
                break;
            case 2:
                punti.add(p.get(0), 0, 0);
                punti.add(p.get(1), 2, 2);
                break;
            case 3:
                punti.add(p.get(0), 0, 0);
                punti.add(p.get(1), 1, 1);
                punti.add(p.get(2), 2, 2);
                break;
            case 4:
                punti.add(p.get(0), 0, 0);
                punti.add(p.get(1), 2, 2);
                punti.add(p.get(2), 2, 0);
                punti.add(p.get(3), 0, 2);
                break;
            case 5:
                punti.add(p.get(0), 0, 0);
                punti.add(p.get(1), 1, 1);
                punti.add(p.get(2), 2, 2);
                punti.add(p.get(3), 2, 0);
                punti.add(p.get(4), 0, 2);
                break;
            case 6:
                punti.add(p.get(0), 0, 0);
                punti.add(p.get(1), 2, 2);
                punti.add(p.get(2), 2, 0);
                punti.add(p.get(3), 0, 1);
                punti.add(p.get(4), 2, 1);
                punti.add(p.get(5), 0, 2);
                break;
            default:
        }
        for(Node e : this.punti.getChildren()) {
            StackPane.setAlignment(e, Pos.CENTER);
        }
        this.contatore.decrementa();
        this.campo.checkWin();
    }
    
}
