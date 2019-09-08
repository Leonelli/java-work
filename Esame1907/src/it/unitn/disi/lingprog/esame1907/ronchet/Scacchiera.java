package it.unitn.disi.lingprog.esame1907.ronchet;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * Scacchiera su cui si svolge il gioco
 * @author ronchet
 */
public class Scacchiera extends GridPane {
    final int N;
    Color color;
    Casella[][] caselle;
    /**
     * Costruttore
     * @param n numero di celle per riga/colonna
     * @param cellController Controllore degli esenti di mouse per le caselle 
     */
    Scacchiera(int n, EventHandler<MouseEvent> cellController) {
        N=n;
        caselle=new Casella[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (((i+j)%2)==0)
                    color=Color.WHITE;
                else 
                    color=Color.BLACK;
                caselle[i][j]=new Casella(cellController,color, i, j);
                //aggiungi la casella alla griglia grafica
                this.add(caselle[i][j], i, j);
            }
        }
    }
    /**
     * svuota la scacchiera
     */
    void rimuoviPezzi() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {    
               if (caselle[i][j].pezzo!=null) {
                   caselle[i][j].removePezzo();
               } 
            }
        }
        Pedone.count=0;
        Alfiere.count=0;
        Torre.count=0;
    }
}
