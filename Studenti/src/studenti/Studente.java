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
public class Studente extends Persona{
    
    int matricola;
    Libretto libretto;
    
    Studente(String nome, String cognome,int matricola){
        this.nome = nome;
        this.cognome = cognome;
        this.matricola= matricola;
        this.libretto=new Libretto();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Studente s = new Studente("Giulio","Cesare",125);
       Esame e = new Esame("Geometria",27);
       s.libretto.addEsame(e);
       s.libretto.addEsame(new Esame("Fisica",22));
       System.out.print(s.nome+" "+s.cognome+" "); 
       System.out.println(s.libretto.media);
       
       Studente s2 = new Studente("Ivan","Bonmassare",125);
       s2.libretto.addEsame(new Esame("Prog1",30));
       s2.libretto.addEsame(new Esame("Prog2",28));
       System.out.print(s2.nome+" "+s2.cognome+" "); 
       System.out.println(s2.libretto.media);
    }

}
