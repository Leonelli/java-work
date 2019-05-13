/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazzoCarte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.shape.Circle;

/**
 *
 * @author Matteo
 */
public class MazzoCarte{
    /**
     * @param args the command line arguments
     */
    
    MazzoCarte(){
        int ncarte=13;
        int nsemi = 4;
        
        List<Carta> mazzo=new ArrayList();    
        
        for (int i = 1; i <= ncarte; i++) {
            for (int j = 1; j <= nsemi; j++) {
                Carta c = new Carta(i,j);
                Carta c1 = new Carta(i,j);
                mazzo.add(c);
                mazzo.add(c1);
                //System.out.println(c);
            }
        }
        System.out.println(mazzo.size());
        Collections.shuffle(mazzo);
        
        //METODI DI ORDINAMENTO
       /* System.out.println("--------RIORDINAMENTO--------------");
        Collections.sort(mazzo);
        System.out.println(mazzo);
        System.out.println("--------RIORDINAMENTO SEME--------------");
        Collections.sort(mazzo, new CartaSeme());
        System.out.println(mazzo);
        System.out.println("--------RIORDINAMENTO VALORE--------------");
        Collections.sort(mazzo, new CartaValore());
        System.out.println(mazzo);*/

        
        boolean failure=true;
        int n = 10;
         do {
             try{
                TextInputDialog dialog = new TextInputDialog("10");
                dialog.setTitle("Pesca");
                dialog.setHeaderText("Pesca");
                dialog.setContentText("Numero carte da pesca:");
                n= Integer.parseInt(dialog.showAndWait().get());
                failure=false;
             }
             catch(NumberFormatException ex){
                 failure=true;
             }
         } while (failure || n <10 || n > 50);  
             
        
        List <Carta> carte_estratte = mostraCarte(n,mazzo);
        
        boolean vittoria = controllaVittoria(carte_estratte,n);
        if (vittoria) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("VITTORIA");
            alert.setHeaderText(":)");
            alert.setContentText("HAI VINTO!");
            alert.showAndWait();  
            
            System.out.println("---------CARTA VINCENTE------------");
            System.out.println(CartaVincente(carte_estratte,n));
            
            boolean vittoria_doppia=false;
            
            for (int i = 0; i < carte_estratte.size(); i++) {
                
                Carta c = mazzo.get(n);
                if(carte_estratte.get(i).compareTo(c)==0){
                     vittoria_doppia = true;
                     System.out.println("CARTA DOPPIA");
                     System.out.println(c);
                     
                }
            }
             if(vittoria_doppia==true){
                    Alert alert1 = new Alert(AlertType.INFORMATION);
                    alert1.setTitle("CARTA TROVATA");
                    alert1.setHeaderText(":)");
                    alert1.setContentText("VITTORIA DOPPIA!");
                    alert1.showAndWait();             
                }
                else
                {
                        Alert alert2 = new Alert(AlertType.INFORMATION);
                        alert2.setTitle("NIENTE DOPPIA VITTORIA");
                        alert2.setHeaderText(":(");
                        alert2.setContentText("HAI PERSO IL BONUS!");
                        alert2.showAndWait();             
                        }
            
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("SCOFITTA");
            alert.setHeaderText(":(");
            alert.setContentText("HAI PERSO!");
            alert.showAndWait();             

        }
    }
    
    public static void main(String[] args) {
       
       MazzoCarte mazzo=new MazzoCarte();    


    }

    
    
   
    boolean controllaVittoria(List<Carta> mazzo,int n){
        boolean vittoria = false;
        //System.out.println("-----------Controllo vittoria----------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mazzo.get(i).equals(mazzo.get(j))&& i!=j) {
                    //System.out.println(mazzo.get(i) + " " + mazzo.get(j) + " equal?: " + mazzo.get(i).equals(mazzo.get(j)));
                    vittoria = true;
                    /*Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Look, an Information Dialog");
                    alert.setContentText(mazzo.get(i).toString());
                    alert.showAndWait();   */    
                }
            }
        }
         
        return vittoria;
    }
     
    
    //get carte_estratte
    public List <Carta> getCarteEstratte(int n,List<Carta> mazzo){
        return mostraCarte(n,mazzo);
    }
    
    
    //trova carta vincente{}
    public Carta CartaVincente(List<Carta> mazzo,int n){
        Carta carta_vincente = new Carta(1,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                 if (mazzo.get(i).equals(mazzo.get(j))&& i!=j) {
                      return carta_vincente = mazzo.get(j);
                 }
            }
        }          
        return carta_vincente;
    }
            
    List<Carta> mostraCarte(int n, List<Carta> mazzo){
        //System.out.println("-----------CARTE ESTREATTE----------------");
        List <Carta> carte_estratte = new ArrayList(); 
        for (int i = 0; i < n; i++) {
            Carta c = mazzo.get(i);
            carte_estratte.add(c);

            System.out.println(c);
        }
        return carte_estratte;
    }

    
    
  
}

