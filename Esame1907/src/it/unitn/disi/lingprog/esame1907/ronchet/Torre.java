package it.unitn.disi.lingprog.esame1907.ronchet;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe rappresentante una Torre degli scacchi
 * @author ronchet
 */
public class Torre extends Pezzo {
    /**
     * Contatore del numero di Torri esistenti
     */
    static int count=0;
    /**
     * Costruttore 
     * @param sc scacchiera
     */
    Torre(Scacchiera sc) {
        super("T"+(++count),sc);
    }
    /**
     * Metodo per trovare tutte le caselle raggiungibili dalla Torre.
     * @return Insieme di caselle raggiungibili, sotto vorma di lista
     */    
    List<Casella> getReachableCells() {
        List<Casella> reachableCells=new ArrayList<Casella>();
        //Casella[][] caselle=sc.caselle;
        for (int k=0;k<sc.N;k++){
            reachableCells.add(sc.caselle[casella.i][k]);
            reachableCells.add(sc.caselle[k][casella.j]);
        }
        return reachableCells;
    } 
}
