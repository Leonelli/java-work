/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenti;

/**
 *
 * @author Matteo
 */
public class Libretto {
    float media;
    Esame [] e;
    int contatore;
    
    Libretto(){
        this.e = new Esame [30];
        this.media = 0;
        this.contatore = 0;
    }
    
    float CalcolaMedia(){
        float res = 0;
        for (int i = 0; i < this.contatore; i++) { 
            res+=this.e[i].voto;
        }
        return res/this.contatore;
    }
    
    public void addEsame(Esame esame){
        this.e[contatore]= esame;
        this.contatore++;
        this.media=CalcolaMedia();
    }

}

