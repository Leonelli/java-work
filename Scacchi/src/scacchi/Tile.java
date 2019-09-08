/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matteo
 */
public class Tile extends Rectangle {

    private Piece piece;
    private Scacchi scacchiera;

    public boolean hasPiece() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Tile(boolean light, int x, int y) {
        setWidth(Scacchi.TILE_SIZE);
        setHeight(Scacchi.TILE_SIZE);

        relocate(x * Scacchi.TILE_SIZE, y * Scacchi.TILE_SIZE);

        setFill(light ? Color.WHITE : Color.BLACK);

        this.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){
            public void handle(javafx.scene.input.MouseEvent event){
                    System.out.println("Sto inserendo in "+x+" "+y);
                    inserisci(PieceType.A,x,y);
               } 
        });
        
    }  
    
    public void inserisci(PieceType type, int x, int y) {
        piece = new Piece(type, x, y);
        relocate(x * Scacchi.TILE_SIZE, y * Scacchi.TILE_SIZE);
    }
}
