package it.unitn.disi.lingprog.esame1906;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

/**
 * Classe astratta rappresentante una tile.
 * Le sottoclassi hanno la responsabilità di:
 * <UL>
 * <LI> definire correttamente la propria forma </LI>
 * <LI> aggiornare il proprio stato </LI>
 * <LI> restituire informazione su dove esse debbano essere poste dopo un aggiornamento </LI>
 * </UL>
 * @author ronchet
 */
public abstract class Tile extends StackPane implements Comparable{
    Shape s;
    Text tileText;
    int tileNumber;
    EventHandler<MouseEvent> controller=null;
    /**
     * Costruttore
     * @param i valore che la tile deve assumere
     * @param s forma della tile
     * @param vc gestore degli eventi di mouse per la tile
     * @param c colore della tile
     */
    Tile(int i,Shape s,EventHandler<MouseEvent> vc, Color c) {
        this.s=s;
        s.setFill(c);
        s.setStroke(c.invert());
        this.tileNumber=i;
        tileText=new Text(""+i);
        tileText.setStroke(c.invert());
        getChildren().addAll(s,tileText);
        controller=vc;
        this.addEventFilter(MouseEvent.MOUSE_CLICKED, controller);
    }
    /**
     * rendi inattiva la tile
     */
    public void makeInactive() {
        this.removeEventFilter(MouseEvent.MOUSE_CLICKED, controller);
    }
    /**
     * controllo di equivalenza
     * @param obj la tile con cui confrontare
     * @return true se equivalenti
     */
    public boolean isEquivalent(Tile obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return false;
        if (getClass() == obj.getClass() && tileNumber == obj.tileNumber)
            return true;
        return false;
    }
    /**
     * implementazione dell'interfaccia Comparable per permetter l'ordinamento.
     * @param obj l'oggetto con cui comparare
     * @return secondo la convenzione standard di Comparable
     */
    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Tile) {
            Tile t=(Tile)obj;
            return t.tileNumber-this.tileNumber;
        }
        return 0;
    }
    public abstract void update();  
    public abstract int getDesiredPosition();
}
