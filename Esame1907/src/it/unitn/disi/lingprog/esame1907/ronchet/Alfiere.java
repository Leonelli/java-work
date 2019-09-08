package it.unitn.disi.lingprog.esame1907.ronchet;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe rappresentante un Alfiere degli scacchi
 * @author ronchet
 */
public class Alfiere extends Pezzo {
    /**
     * Contatore del numero di Alfieri esistenti
     */
    static int count = 0;
    /**
     * Costruttore 
     * @param sc scacchiera
     */
    Alfiere(Scacchiera sc) {
        super("A" + (++count), sc);
    }
    /**
     * Metodo per trovare tutte le caselle raggiungibili dal'Alfiere.
     * @return Insieme di caselle raggiungibili, sotto vorma di lista
     */
    List<Casella> getReachableCells() {
        List<Casella> reachableCells = new ArrayList<Casella>();
        int i1 = casella.i;
        int j1 = casella.j;
        for (int ik = i1+1; ik < sc.N; ik++) {
            j1 = j1 + 1;
            if (j1 >= sc.N)
                break;
            reachableCells.add(sc.caselle[ik][j1]);
        }
        j1 = casella.j;
        for (int ik = i1+1; ik < sc.N; ik++) {
            j1 = j1 - 1;
            if (j1 < 0)
                break;
            reachableCells.add(sc.caselle[ik][j1]);
        }
        j1 = casella.j;
        for (int ik = i1-1; ik >= 0; ik--) {
            j1 = j1 + 1;
            if (j1 >= sc.N)
                break;
            reachableCells.add(sc.caselle[ik][j1]);
        }
        j1 = casella.j;
        for (int ik = i1-1; ik >= 0; ik--) {
            j1 = j1 - 1;
            if (j1 < 0)
                break;
            reachableCells.add(sc.caselle[ik][j1]);
        }
        return reachableCells;
    }
}
