/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class Doolhof {
    public Object[][] Doolhof;
    public int maxStappen;
    public ArrayList<JLabel> labels= new ArrayList<>();
    public Speler S = new Speler();
    public int aantalStappen = 0;
    public int level = 0;
    public Helper H = new Helper();
    public Bazooka B = new Bazooka();
    public Uitgang U = new Uitgang();
    public Valsspeler V = new Valsspeler();
    public Muur X = new Muur();
    public Muur M = new Muur();
        
    Doolhof(){
        M.verwoestbaar = false;
    }
    
    public void setDoolhof(int nummer){
        if(nummer == 1){
            this.Doolhof = Doolhof1();
            maxStappen = 80;
            S.setP(1,1);
            level = nummer;
        }else if(nummer == 2){
            //Doolhof2();
            level = nummer;
        }else if(nummer == 3){
            //Doolhof3();
            level = nummer;
        }
    }
    
    private Object[][] Doolhof1(){
        Object[][] Doolhof1 =  {{X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X},
                                {X," ",M," ",M,V," "," "," "," "," "," ",M," "," "," "," "," "," ",X},
                                {X," ",M," ",M,M,M," ",M,M,M," ",M," ",M,M," ",M," ",X},
                                {X," ",M," "," ",B,M," ",M," "," "," ",M," ",M,V," ",M," ",X},
                                {X," ",M," ",M,M,M," ",M," ",M,M," "," ",M,M,M,M," ",M},
                                {X," "," "," "," "," ",M," ",M," "," "," "," ",M," "," "," "," "," ",X},
                                {X,M,M," ",M," ",M," ",M,M,M,M,M,M," ",M,M,M,M,M},
                                {X," "," "," ",M," ",M," ",M," "," "," "," "," "," "," "," "," "," ",X},
                                {X," ",M," ",M," "," "," ",M,M,M," ",M,M," ",M," ",M," ",X},
                                {X," ",M," ",M,M,M," ",M," "," "," "," ",M," ",M," ",M," ",X},
                                {X," ",M," "," "," ",M," ",M," "," ",M,M,M," ",M,M," "," ",X},
                                {X," ",M," ",M," "," ",M,M," "," ",M,U," "," ",M," "," ",M,X},
                                {X," ",M,M,M,M," ",M,B," "," ",M,M,M,M,M,M," "," ",X},
                                {X," "," ",M," "," "," ",M,M,M,M,M," "," ",M," ",M,X," ",X},
                                {X,M," ",M," ",M," "," "," ",M," "," "," "," "," "," ",M," "," ",X},
                                {X," "," ",M," ",M," ",M," ",M,M,M,M,M,M," ",M," ",M,X},
                                {X," ",M,M," ",M," ",M," "," "," "," "," "," "," "," ",X," "," ",X},
                                {X," "," "," "," ",M," ",M," ",M,M,M," ",M,M,M,M,M," ",X},
                                {X,M,M,M,M,M," "," "," ",M,H," "," "," "," "," "," "," "," ",X},
                                {X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X}
        }; // maak er een array van objecten van
        
        return Doolhof1;
    }
    
    @Override
    public String toString(){
        String waarde = "";
        for (int x = 0; x < Doolhof.length; x++) {
            for (int y = 0; y < Doolhof.length; y++) {
                waarde = waarde + Doolhof[x][y];
                if (y + 1 == Doolhof.length){
                    waarde = waarde + "\n";
                }
            }
        }
        return waarde;
    }
    
    public void gameOver(){
        if (aantalStappen == maxStappen){
            System.out.println("GAME OVER!!");
        }
    }
}
