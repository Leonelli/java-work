package it.unitn.disi.lingprog.esame1907.ronchet;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe rappresentante una Casella degli scacchi
 * @author ronchet
 */
public class Casella extends StackPane {
    int DIM=50;
    Color color;
    Rectangle square;
    int i;
    int j;
    /**
     * Costruttore
     * @param cellController Controllore degli eventi di mouse per la cella
     * @param color colore della cella
     * @param i coordinata della cella 
     * @param j coordinata della cella
     */
    Casella(EventHandler<MouseEvent> cellController,Color color, int i, int j) {
        this.color=color;
        this.i=i;
        this.j=j;
        square=new Rectangle(DIM,DIM);
        square.setFill(color);
        this.getChildren().add(square);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, cellController);
    }
    Pezzo pezzo;
    /**
     * associa alla casella il pezzo che la occupa
     * @param p il pezzo
     */
    void setPezzo(Pezzo p){
        if (pezzo==null) {
            pezzo=p;
            p.setCasella(this);
            this.getChildren().add(pezzo);
            System.out.println(pezzo);
        }
    }
    /**
     * illumina la cella
     */
    void highlite() {
        square.setFill(Color.RED);
    }
    /**
     * fai tornare la cella al rendering normale
     */
    void normal(){
         square.setFill(color);   
    }
    /**
     * rimuovi il pezzo dalla cella
     */
    void removePezzo() {
        this.getChildren().remove(pezzo);
        pezzo=null;
    }
}
