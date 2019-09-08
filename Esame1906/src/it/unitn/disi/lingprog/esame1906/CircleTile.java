package it.unitn.disi.lingprog.esame1906;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/**
 * Classe rappresentante una Tile di forma circolare
 * @author ronchet
 */
public class CircleTile extends Tile {

    CircleTile(int k, EventHandler<MouseEvent> vc, Color c) {
        super(k, new Circle(25, 25, 25), vc, c);
    }
    /**
     * restituisce informazione su dove esse debba essere posta la tile dopo un aggiornamento 
     * @return una costante che definisce la posizione (in cima)
     */
    @Override
    public int getDesiredPosition() {
        return Esame1906.TOP;
    }
    /**
     * aggiornamento del valore della tile
     */
    @Override
    public void update() {
        tileNumber = (tileNumber + 9) % 10;
        tileText.setText("" + tileNumber);
    }

}
