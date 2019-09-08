package it.unitn.disi.lingprog.esame1906;

import static it.unitn.disi.lingprog.esame1906.Esame1906.BOTTOM;
import static it.unitn.disi.lingprog.esame1906.Esame1906.TOP;   
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Contenitore verticale per le tile attive
 * @author ronchet
 */
public class VerticalContainer extends VBox implements EventHandler<MouseEvent> {

    final ArrayList<Tile> listaDiTiles = new ArrayList<>();
    Esame1906 app;

    VerticalContainer(Esame1906 app) {
        super();
        this.app = app;
    }
    /**
     * genera il contenuto
     * @param n numero di tiles da costruire
     */
    public void populate(int n) {
        Random rg = new Random(System.currentTimeMillis());
        while (listaDiTiles.size() < n) {
            Color c = new Color(rg.nextDouble(), rg.nextDouble(), rg.nextDouble(), 1.0);
            int k = rg.nextInt(10);
            boolean isOk = true;
            Tile t = null;
            if (listaDiTiles.size() < n / 2) {
                t = new CircleTile(k, this, c);
            } else {
                t = new SquareTile(k, this, c);
            }
            for (Tile t1 : listaDiTiles) {
                if (t.isEquivalent(t1)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk)
                listaDiTiles.add(t);
        }
        Collections.shuffle(listaDiTiles);
        getChildren().addAll(listaDiTiles);
    }
    /**
     * Riordina il contenitore
     */
    void sort() {
        getChildren().removeAll(listaDiTiles);
        Collections.sort(listaDiTiles);
        getChildren().addAll(listaDiTiles);
    }
    /**
     * controlla se ci sono duplicati
     * @param thisTile tile di cui cercare duplicati
     * @return una tile equivalente a quella cercata
     */
    Tile checkForDuplicates(Tile thisTile) {
        Tile duplicateTile = null;
        for (Tile aTile : listaDiTiles) {
            if (thisTile.isEquivalent(aTile)) {
                duplicateTile = aTile;
                break;
            }
        }
        //System.out.println("duplicateTile " + duplicateTile);
        return duplicateTile;
    }
    /**
     * rimuovi una tile dal contenitore
     * @param thisTile tile da rimuovere
     */
    void remove(Tile thisTile) {
        listaDiTiles.remove(thisTile);
        app.hbox.getChildren().add(thisTile);
        thisTile.makeInactive();
    }
    /**
     * riposiziona una tile 
     * @param thisTile tile da riposizionare
     */
    void reposition(Tile thisTile) {
        listaDiTiles.remove(thisTile);
        int desiredPosition = thisTile.getDesiredPosition();
        if (desiredPosition == TOP)
            listaDiTiles.add(0, thisTile); // aggiungi a inizio lista
        if (desiredPosition == BOTTOM)
            listaDiTiles.add(thisTile); // aggiungi alla fine lista
    }
    /**
     * getsore degli eventi di mouse
     * @param event evento da gestire
     */
    @Override
    public void handle(MouseEvent event) {
        performAction((Tile)(event.getSource()));
        event.consume();
    } 
    /**
     * aggiornamento della tile e suo riposizionamento
     * @param tile la tile su cui agire
     */
    private void performAction(Tile tile) {
        getChildren().removeAll(listaDiTiles);
        tile.update();
        Tile duplicate = checkForDuplicates(tile);
        if (duplicate != null) {
            remove(tile);
            remove(duplicate);
        } else {
            reposition(tile);
        }
        getChildren().addAll(listaDiTiles);
    }
    /**
     * simula il click sulle tile avento valore specificato
     * @param n valore della tile su cui cliccare
     */
    // versione che clicca su tutti gli elementi aventi valore = n
    void push(int n){
        boolean foundOne=false;
        for (Tile t: listaDiTiles) {
            if (t.tileNumber==n) {
                performAction(t);
                foundOne=true;
                break;
            }
        }
        if (foundOne) push(n);
    }   
    //versione che clicca solo su un elemento avente valore = n
    /* void push(int n){
        for (Tile t: listaDiTiles) {
            if (t.tileNumber==n) {
                performAction(t);
                break;
            }
        }
    }
    */ 
}
