/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Matteo
 */


public class Piece extends StackPane{

    private PieceType type;
    private double mouseX,mouseY;
    private double oldX,oldY;

    public PieceType getType() {
        return type;
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }
     
    
    
public Piece(PieceType type, int x,int y){

    this.type = type;

    move(x, y);
    
    Ellipse bg = new Ellipse(Checkers.TILE_SIZE*0.3125,Checkers.TILE_SIZE*0.26);
    bg.setFill(Color.BLACK);
    
    
    bg.setStroke(Color.BLACK);
    bg.setStrokeWidth(Checkers.TILE_SIZE*0.03);
    
    bg.setTranslateX((Checkers.TILE_SIZE-Checkers.TILE_SIZE*0.3125*2)/2);
    bg.setTranslateY((Checkers.TILE_SIZE-Checkers.TILE_SIZE*0.26*2)/2 + Checkers.TILE_SIZE*0.07);
  
    
    Ellipse ellipse = new Ellipse(Checkers.TILE_SIZE*0.3125,Checkers.TILE_SIZE*0.26);
    ellipse.setFill(type==PieceType.RED ?
            Color.valueOf("#c40003"): Color.valueOf("#fff9f4"));

    ellipse.setStroke(Color.BLACK);
    ellipse.setStrokeWidth(Checkers.TILE_SIZE);
    
    ellipse.setTranslateX((Checkers.TILE_SIZE-Checkers.TILE_SIZE));
    ellipse.setTranslateY((Checkers.TILE_SIZE-Checkers.TILE_SIZE));
    
    
    getChildren().addAll(bg,ellipse);
    
    
    setOnMousePressed(e->{
        mouseX = e.getSceneX();
        mouseY = e.getSceneY();
    });

    setOnMouseDragged(e->{
        relocate(e.getSceneX()-mouseX+oldX, e.getSceneY()-mouseY+oldY);
    });
}

public void move(int x,int y){
    oldX = x * Checkers.TILE_SIZE;
    oldY = y * Checkers.TILE_SIZE;
    relocate(oldX,oldY);
}

public void abortMove(){
    relocate(oldX,oldY);
}

}
