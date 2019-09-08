/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadi;

import java.util.Random;

/**
 *
 * @author Matteo
 */
public class Commons {
    
    //dimensione del dado
    public final static int DIMDADO = 100;
    
    //dimensione punto sul dado
    public final static int DIMPUNTO = 5;
    
    //larghezza campo
    public final static int WIDTH = 700;
    
    //altezza campo 
    public final static int HEIGTH = 700;
    
    //dimensione dell'area cliccabile
    public final static int CENTERSIZE = 500;
    
    //generatore di numeri
    public final static Random R = new Random(System.currentTimeMillis());
    
}
