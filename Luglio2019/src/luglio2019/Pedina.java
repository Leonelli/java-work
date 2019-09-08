/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2019;

import java.util.ArrayList;
import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Marco
 */
public class Pedina extends StackPane{
    Circle p = new Circle(23,23,23);
    Text nome;
    Text sel;
    int x;
    int y;
    int np = 1;
    int nt = 1;
    int na = 1;
    Collection<Casella> caselle;

    
    public Pedina(Text sel,int x, int y, Collection<Casella> caselle,Collection<Pedina> pedine){
        this.sel=sel;
        this.x=x;
        this.y=y;
        pedine.add(this);
        p.setFill(Paint.valueOf("YELLOW"));
        p.setStroke(Paint.valueOf("BLACK"));
        Pedina.this.getChildren().add(p);
        String n = sel.getText();
        System.out.print(pedine);
        int i=1;
        if(n.contains("PEDONE")){
            for (Pedina pe:pedine){
                if (pe.nome == null){
                    nome=new Text("P"+Integer.toString(i));
                }else{
                    String s = pe.nome.getText();
                    if(s.contains(Integer.toString(i))&&s.contains("P")){
                        i++;
                    }else{
                        nome=new Text("P"+i);
                    }
                }
            }
        }else if(n.contains("TORRE")){
            for (Pedina pe:pedine){
                if (pe.nome == null){
                    nome=new Text("T"+Integer.toString(i));
                }else{
                    String s = pe.nome.getText();
                    if(s.contains(Integer.toString(i))&&s.contains("T")){
                        i++;
                    }else{
                        nome=new Text("T"+i);
                    }
                }
            }
        }else if(n.contains("ALFIERE")){
           for (Pedina pe:pedine){
                if (pe.nome == null){
                    nome=new Text("A"+Integer.toString(i));
                }else{
                    String s = pe.nome.getText();
                    if(s.contains(Integer.toString(i))&&s.contains("A")){
                        i++;
                    }else{
                        nome=new Text("A"+i);
                    }
                }
            }
        }else{
            nome = new Text("none");
        }
        nome.setFont(Font.font("Verdana",FontWeight.BOLD,15));
        Pedina.this.getChildren().add(nome);
        
        Pedina.this.setOnMouseMoved(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                if (nome.getText().contains("P")){
                    for(Casella c:caselle){
                        if((c.x==x)&&(c.y==y-1)||(c.x==x)&&(c.y==y)){
                            c.c.setFill(Paint.valueOf("RED"));
                        }
                    }
                }
                if (nome.getText().contains("T")){
                    for(Casella c:caselle){
                        if((c.x==x)||(c.y==y)){
                            c.c.setFill(Paint.valueOf("RED"));
                        }
                    }
                }
                if (nome.getText().contains("A")){
                    for(Casella c:caselle){
                        for(int k=-9; k<10; k++){
                            if((c.x==x+k)&&(c.y==y+k)||(c.x==x+k)&&c.y==y-k){
                                c.c.setFill(Paint.valueOf("RED"));
                            }
                        }
                    }
                }
            }
        });
        
        Pedina.this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                for(Casella c:caselle){
                    c.colora();
                }
                
            }
        });
    }
    
    
}
