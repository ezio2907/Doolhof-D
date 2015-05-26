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
    private Object[][] Doolhof;
    private int maxStappen;
    private ArrayList<JLabel> labels= new ArrayList<>();
    private Speler S = new Speler();
    private int aantalStappen = 0;
    private int level = 0;
    private Helper H = new Helper();
    private Bazooka B = new Bazooka();
    private Uitgang U = new Uitgang();
    private Valsspeler V = new Valsspeler();
    private Muur X = new Muur();
    private Muur M = new Muur();
        
    Doolhof(){
        M.verwoestbaar = false;
    }
    
    public Object[][] getDoolhof(){
        return Doolhof;
    }
    public Helper getHelper(){
        return H;
    }
    public Bazooka getBazooka(){
        return B;
    }
    public Uitgang getUitgang(){
        return U;
    }
    public Valsspeler getValsspeler(){
        return V;
    }
    public Muur getMuurM(){
        return M;
    }
    public Muur getMuurX(){
        return X;
    }
    public int getStappen(){
        return aantalStappen;
    }
    public Speler getSpeler(){
        return S;
    }
    public int getMaxStappen(){
        return maxStappen;
    }
    public int getLevel(){
        return level;
    }
    
    public void setStappen(int aantalStappen){
        this.aantalStappen = aantalStappen;
        if (aantalStappen >= maxStappen){
            System.out.println("GAME OVER!!");
        }
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
                                {X," "," ",M," "," "," ",M,M,M,M,M," "," ",M," ",M,M," ",X},
                                {X,M," ",M," ",M," "," "," ",M," "," "," "," "," "," ",M," "," ",X},
                                {X," "," ",M," ",M," ",M," ",M,M,M,M,M,M," ",M," ",M,X},
                                {X," ",M,M," ",M," ",M," "," "," "," "," "," "," "," ",M," "," ",X},
                                {X," "," "," "," ",M," ",M," ",M,M,M," ",M,M,M,M,M," ",X},
                                {X,M,M,M,M,M," "," "," ",M,H," "," "," "," "," "," "," "," ",X},
                                {X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X}
        }; 
        return Doolhof1;
    }
    
//    private Object[][] Doolhof3(){
//        Object[][] Doolhof3 = {
//            {X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X},
//            {X,V," "," "," "," "," "," "," ",M," ",M," "," "," "," ",M," "," ",M," "," "," "," "," "," "," "," ",X},
//            {X," ",M,M,M," "," ",M,," ",M," "," "," ",M,M," ",M," ",M," ",M," ",M," ",M," "," ",M," ",X},
//            {X," ",M," ",M,M," ",
//            
//            {X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X}
//                }; 
//        return Doolhof3;
//    }
    
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
}
