package it.unitn.disi.lingprog.esame1907.ronchet;

import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * Classe astratta che rappresenta i pezzi degli scacchi
 * @author ronchet
 */
abstract public class Pezzo extends StackPane implements EventHandler<MouseEvent>{
    /**
     * Casella su cui il Pezzo si trova
     */
    Casella casella=null;
    protected Text t=null;
    /**
     * Scacchiera su cui il Pezzo si trova
     */
    Scacchiera sc=null;
    /** Costruttore
     * @param s etichetta da visualizzare sul pezzo
     * @param sc scacchiera
     */
    Pezzo(String s, Scacchiera sc) {
        this.sc=sc;
        Circle c=new Circle(20,20,20);
        c.setFill(Color.YELLOW);
        c.setStroke(Color.BLUE);
        t=new Text(s);
        t.setStroke(Color.BLUE);
        this.getChildren().addAll(c,t);
        this.addEventFilter(MouseEvent.MOUSE_ENTERED, this);
        this.addEventFilter(MouseEvent.MOUSE_EXITED, this);
    }
    /**
     * Associa il pezzo alla casella su cui si trova
     * @param x la casella
     */
    void setCasella(Casella x) {
        casella=x;
    }
    /**
     * Metodo astratto per trovare tutte le caselle raggiungibili.
     * La logica specifica deve essere implementata nelle sottoclassi.
     * @return Insieme di caselle raggiungibili, sotto vorma di lista
     */
    abstract List<Casella> getReachableCells();
    /**
     * Gestione degli eventi di Mouse
     * @param event 
     */
    @Override
    public void handle(MouseEvent event) {
        System.out.println(event.getEventType().getName());
        if (event.getEventType().getName().equals("MOUSE_ENTERED")) doMouseEnteredAction();
        if (event.getEventType().getName().equals("MOUSE_EXITED")) doMouseExitedAction();
    }
    /** 
     * azione da compiere quando il mouse entra sul pezzo
     */
    void doMouseEnteredAction() {
        casella.highlite();
        for (Casella c:getReachableCells()) {c.highlite();}
    }
    /** 
     * azione da compiere quando il mouse esce dal pezzo
     */
    void doMouseExitedAction() {
        casella.normal();
        for (Casella c:getReachableCells()) {c.normal();}
    }
        
}
