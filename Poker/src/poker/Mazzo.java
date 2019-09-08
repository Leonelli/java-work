/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Matteo
 */
public class Mazzo {
    public ArrayList <Carta> mazzo = new ArrayList();

    public Mazzo(){
        Carta c;
        
        for (int i = 1; i <= 4; i++) {
            for(Seme s : Seme.values()){
                c= new Carta(i,s);
                mazzo.add(c);
            }
        }
        //is missing the blackJack
        //c = new Carta(0,Seme.J);

        Collections.shuffle(mazzo);
        System.out.println(mazzo);
        Collections.sort(mazzo);
        System.out.println(mazzo);
        Collections.shuffle(mazzo);


    }
}
