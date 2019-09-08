package it.unitn.disi.lingprog.esame1906;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * Classe rappresentante una Tile di forma quadrata
 * @author ronchet
 */
public class SquareTile extends Tile {

    SquareTile(int k, EventHandler<MouseEvent> vc, Color c) {
        super(k, new Rectangle(50, 50), vc, c);
    }
    /**
     * restituisce informazione su dove esse debba essere posta la tile dopo un aggiornamento 
     * @return una costante che definosce la posizione (in fondo)
     */
    @Override
    public int getDesiredPosition() {
        return Esame1906.BOTTOM;
    }
    /**
     * aggiornamento del valore della tile
     */
    @Override
    public void update() {
        tileNumber = (tileNumber + 1) % 10;
        tileText.setText("" + tileNumber);
    }
}
