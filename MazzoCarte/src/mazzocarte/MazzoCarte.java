/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazzocarte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Matteo
 */
public class MazzoCarte {
    /**
     * @param args the command line arguments
     */
    
    MazzoCarte(){
        int ncarte=13;
        int nsemi = 4;
        
        List<Carta> mazzo=new ArrayList();    
        
        for (int i = 0; i <= ncarte; i++) {
            for (int j = 0; j <= nsemi; j++) {
                Carta c = new Carta(i,j);
                mazzo.add(c);
                mazzo.add(c);
                //System.out.println(c);
            }
        }
        Collections.shuffle(mazzo);
        List <Carta> carte_estratte = mostraCarte(10,mazzo);
        boolean vittoria = controllaVittoria(carte_estratte);
        if (vittoria) {
            System.out.println("HAI VINTO");
        }
        else{
            System.out.println("HAI PERSO");

        }
    }
    
    public static void main(String[] args) {
       
       MazzoCarte mazzo=new MazzoCarte();    


    }

   
    boolean controllaVittoria(List<Carta> mazzo){
        boolean vittoria = false;
        System.out.println("-----------Controllo vittoria----------------");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (mazzo.get(i).equals(mazzo.get(j))&& i!=j) {
                    System.out.println(mazzo.get(i) + " " + mazzo.get(j) + " equal?: " + mazzo.get(i).equals(mazzo.get(j)));
                    vittoria = true;
                }
            }
        }
         
        return vittoria;
    }
            
    List<Carta> mostraCarte(int n, List<Carta> mazzo){
                    System.out.println("-----------CARTE ESTREATTE----------------");

        List <Carta> carte_estratte = new ArrayList(); 
        for (int i = 0; i < n; i++) {
            Carta c = mazzo.get(i);
            carte_estratte.add(c);

            System.out.println(c);
        }
        return carte_estratte;
    }
}

