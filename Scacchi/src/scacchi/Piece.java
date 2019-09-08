/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import static scacchi.Scacchi.TILE_SIZE;

/**
 *
 * @author Matteo
 */
public class Piece extends StackPane implements EventHandler<MouseEvent> {

    private PieceType type;
    private Text text;

    private double oldX, oldY;

    public PieceType getType() {
        return type;
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public Piece(PieceType type, int x, int y) {
        this.type = type;

        move(x,y);

        Ellipse ellipse = new Ellipse(TILE_SIZE*0.45, TILE_SIZE *0.45);
        ellipse.setFill(Color.YELLOW);

        if (type == PieceType.A) {
            this.text = new Text("A");

        } else if (type == PieceType.P) {
            this.text = new Text("P");

        } else if (type == PieceType.T) {
            this.text = new Text("T");
        }

        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(TILE_SIZE * 0.03);

        getChildren().addAll(ellipse, this.text);
       
        
    }
    
     public void handle(MouseEvent event) {
        System.out.println(event.getEventType().getName()); 
         inserisci(0, 0);
     }
    
    
    public void move(int x, int y) {
        oldX = x * TILE_SIZE;
        oldY = y * TILE_SIZE;
        relocate(oldX, oldY);
    }

    
     public void inserisci(int x, int y){
        System.out.println("Premuta casella "+x+" "+y);
        Piece piece = new Piece(PieceType.A,x,y);
        this.getChildren().add(piece);
      
    }
}
