/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.disi.leonelli.esame_201706;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Matteo
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
                color=Color.WHITE;
                caselle[i][j]=new Casella(cellController, i, j);
                //aggiungi la casella alla griglia grafica
                this.add(caselle[i][j], i, j);
            }
        }
    }
    
}
