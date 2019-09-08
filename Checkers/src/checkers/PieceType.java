/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

/**
 *
 * @author Matteo
 */
public enum PieceType{
    RED(1),WHITE(-1);
    
    final int moveDir;
    
    PieceType(int moveDir){
        this.moveDir=moveDir;
    }
}