package it.unitn.disi.lingprog.esame1907.ronchet;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe rappresentante un Pedone degli scacchi
 * @author ronchet
 */
public class Pedone extends Pezzo {
    /**
     * Contatore del numero di Pedoni esistenti
     */    
    static int count=0;
    /**
     * Costruttore 
     * @param sc scacchiera
     */
    Pedone(Scacchiera sc) {
        super("P"+(++count),sc);
    }
    /**
     * Metodo per trovare tutte le caselle raggiungibili dal Pedone
     * @return Insieme di caselle raggiungibili, sotto vorma di lista
     */
    List<Casella> getReachableCells() {
        List<Casella> reachableCells=new ArrayList<Casella>();
        //Casella[][] caselle=sc.caselle;
        if (casella.j>0) {
            Casella tentative=sc.caselle[casella.i][casella.j-1];
            reachableCells.add(tentative);
        }
        return reachableCells;
    } 
}
