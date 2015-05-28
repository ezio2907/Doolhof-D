/*
 * To change this template," "choose Tools | Templates
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
    private Speler S = new Speler();
    private int aantalStappen = 0;
    private int level = 0;
    private Helper H = new Helper();
    private Bazooka B = new Bazooka();
    private Uitgang U = new Uitgang();
    private Valsspeler V = new Valsspeler();
    private Muur X = new Muur(false);
    private Muur M = new Muur(true);
        
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
    
    
    public boolean setStappen(int aantalStappen){
        this.aantalStappen = aantalStappen;
        if (aantalStappen >= maxStappen){
            System.out.println("GAME OVER!!");
            return true;
        }
        return false;
    }
    
    public void setDoolhof(int nummer){
        if(nummer == 1){
            this.Doolhof = Doolhof1();
            maxStappen = 80;
            S.setP(1,1);
            level = nummer;
        }else if(nummer == 2){
            this.Doolhof = Doolhof2();
            maxStappen = 90;
            S.setP(1,11);
            level = nummer;
        }else if(nummer == 3){
            this.Doolhof = Doolhof3();
            maxStappen = 120;
            S.setP(13,13);
            level = nummer;
        }
    }
    
    private Object[][] Doolhof1(){
        Object[][] Doolhof1 =  {
            {X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X},
            {X,S,M," ",M,V," "," "," "," "," "," ",M," "," "," "," "," "," ",X},
            {X," ",M," ",M,M,M," ",M,M,M," ",M," ",M,M," ",M," ",X},
            {X," ",M," "," ",B,M," ",M," "," "," ",M," ",M,V," ",M," ",X},
            {X," ",M," ",M,M,M," ",M," ",M,M," "," ",M,M,M,M," ",X},
            {X," "," "," "," "," ",M," ",M," "," "," "," ",M," "," "," "," "," ",X},
            {X,M,M," ",M," ",M," ",M,M,M,M,M,M," ",M,M,M,M,X},
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
    
    private Object[][] Doolhof2() {
        Object[][] Doolhof2 = {{X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X},
            {X, " ", " ", " ", " ", " ", " ", M, M, M, M, M, M, M, " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", X},
            {X, " ", M, M, M, M, " ", " ", " ", " ", " ", " ", " ", M, " ", M, M, M, M, " ", M, M, M, M, X},
            {X, " ", M, M, M, M, " ", M, " ", M, M, M, " ", M, " ", M, " ", " ", M, " ", " ", " ", " ", " ", X},
            {X, " ", " ", " ", M, M, " ", M, " ", M, M, M, " ", M, " ", M, M, " ", M, " ", M, M, M, M, X},
            {X, M, M, " ", " ", M, " ", M, " ", " ", M, M, " ", M, " ", " ", M, " ", M, " ", M, U, " ", " ", X},
            {X, " ", M, M, M, M, " ", M, M, " ", M, M, M, M, " ", M, M, " ", M, " ", M, M, M, " ", X},
            {X, " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", M, " ", M, " ", M, " ", M, " ", X},
            {X, " ", M, M, M, M, M, M, M, " ", M, M, M, " ", M, M, M, " ", M, " ", " ", " ", M, " ", X},
            {X, " ", M, " ", " ", " ", " ", " ", " ", " ", M, " ", " ", " ", " ", " ", " ", " ", M, " ", M, M, M, " ", X},
            {X, " ", M, M, M, M, M, M, M, " ", M, " ", M, M, M, M, " ", M, M, " ", M, " ", " ", " ", X},
            {X, " ", " ", " ", " ", " ", " ", " ", " ", " ", M, " ", M, " ", " ", M, " ", " ", " ", " ", M, M, M, " ", X},
            {X, " ", M, M, " ", M, " ", M, M, " ", M, " ", M, " ", M, M, " ", M, M, " ", M, " ", " ", " ", X},
            {X, " ", M, " ", " ", M, " ", " ", M, M, M, " ", M, " ", M, " ", " ", " ", M, " ", M, " ", M, M, X},
            {X, " ", M, M, " ", M, M, " ", M, " ", " ", " ", M, " ", M, " ", M, " ", M, " ", M, " ", " ", " ", X},
            {X, " ", M, " ", " ", " ", M, " ", M, " ", M, M, M, " ", M, " ", M, " ", M, M, M, M, M, " ", X},
            {X, " ", M, " ", M, " ", " ", " ", M, " ", " ", M, " ", " ", " ", " ", M, " ", M, " ", " ", " ", M, " ", X},
            {X, " ", M, " ", M, M, M, M, M, M, " ", M, " ", M, " ", M, M, M, M, " ", M, " ", M, " ", X},
            {X, " ", M, " ", " ", M, " ", " ", " ", M, " ", M, M, M, " ", " ", " ", " ", " ", " ", M, " ", M, " ", X},
            {X, " ", M, M, M, M, " ", M, " ", M, " ", " ", " ", M, " ", " ", " ", " ", " ", " ", M, " ", M, " ", X},
            {X, " ", M, " ", " ", " ", " ", M, " ", M, M, M, " ", M, " ", M, M, M, " ", M, M, " ", M, " ", X},
            {X, " ", " ", " ", M, " ", M, M, " ", " ", " ", M, " ", " ", " ", " ", " ", M, " ", M, M, " ", " ", " ", X},
            {X, " ", M, M, M, M, M, M, M, M, " ", M, " ", M, M, M, M, M, " ", M, M, M, M, " ", X},
            {X, " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", M, " ", " ", " ", " ", " ", " ", " ", " ", M, " ", " ", " ", X},
            {X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X}};
        return Doolhof2;
    }
    
    private Object[][] Doolhof3(){
        Object[][] Doolhof3 = {
            {X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X},
            {X,V," "," "," "," "," "," "," ",M," ",M," "," "," "," ",M," "," ",M," "," "," "," "," "," "," "," "," ",X},
            {X," ",M,M,M," "," ",M," ",M," "," "," ",M,M," ",M," ",M," ",M," ",M," ",M," "," ",M," ",X},
            {X," ",M," ",M,M," ",M," ",M," ",M,M," ",M," ",M," ",M," ",M," ",M," ",M," ",M,M," ",M},
            {X," ",M," ",M," "," ",M," ",M," "," "," "," ",M," "," "," ",M," ",M," ",M," ",M," "," ",M," ",X},
            {X," ",M," ",M," ",M,M," ",M," ",M," "," ",M,M,M,M,M," ",M,M,M," ",M," ",M," "," ",X},
            {X," ",M,M,M," "," "," ",M," "," ",M," ",M,M,M," "," "," "," "," "," "," "," "," "," "," ",M," ",X},
            {X," "," "," "," ",M," ",M," ",M,M," "," "," ",M," "," ",M,M," ",M,M,M,M," ",M,M,M," ",X},
            {X,M,M,M," "," "," "," "," "," "," "," ",M,M,M," ",M,M," "," "," "," ",M,M," ",M,V,M," ",X},
            {X," "," "," "," ",M," ",M," ",M,M," "," "," ",M," ",M,M,M," ",M," ",M,M," ",M," ",M," ",X},
            {X," ",M,M,M,M," "," ",M,H,M,M,M," ",M," ",B,M," "," ",M," ",M,M," ",M," ",M," ",X},
            {X," ",M," "," "," ",M," ",M," "," "," "," "," ",M,M,M,M,M,M,M," "," "," "," "," "," ",M," ",X},
            {X," ",M," ",M," ",M," ",M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,X},
            {X," ",M," ",M," "," "," "," "," "," "," "," ",S,M,M,U," "," ",M," "," "," "," "," "," "," "," "," ",X},
            {X," "," "," ",M," ",M," ",M,M,M," ",M,M,M,M,M,M," ",M," ",M,M,M,M,M,M,M,M,X},
            {X," ",M," ",M," "," "," ",M," "," "," ",M," ",M,M,M,M," ",M," "," "," "," "," "," "," "," "," ",X},
            {X," "," ",M,M,M,M," ",M," ",M," ",M," ",M," ",H,M," ",M,M,M,M,M,M,M,M,M," ",X},
            {X,M," "," "," "," ",M," "," "," ",M," ",M," ",M," ",M,M," "," ",M,M,M,M,M,M,M,M," ",X},
            {X," "," ",M,M," ",M,M,M,M,M," ",M," ",M," "," "," ",M," ",M,M,M," "," "," "," "," "," ",X},
            {X," ",M," "," "," "," "," "," "," "," "," ",M," ",M,M,M," ",M," "," ",M,M," ",M," ",M,M,M,X},
            {X," "," "," ",M," ",M," ",M," ",M,M," "," "," "," ",M," "," ",M," "," "," "," ",M," "," "," "," ",X},
            {X,M,M,M," "," ",M," "," "," ",M," "," ",M,M," ",M,M," ",M,M,M,M," ",M," ",M,M,M,X},
            {X," "," "," "," ",M,M,M," ",M," "," ",M,V,M," "," ",M," "," "," "," "," "," "," "," "," "," "," ",X},
            {X," ",M,M," "," "," "," "," "," "," ",M," "," ",M,M," ",M," ",M," "," ",M,M,M,M,M,M," ",X},
            {X," "," ",M,M,M,M,M,M,M,M," "," ",M,M," "," ",M," ",M," ",M," "," "," "," "," ",M," ",X},
            {X,M," "," "," "," "," "," ",M," ",M," "," "," ",M," ",M,M," ",M," ",M," ",V,H,V," ",M," ",X},
            {X," "," ",M," "," ",M," ",M," ",M," ",M," ",M," ",M," "," ",M," ",M," "," "," "," "," ",M," ",X},
            {X,M,M,M,M,M,M," ",M,M,M," ",M," ",M," ",M,M,M,M," ",M,M,M,M,M,M," "," ",X},
            {X,B," "," "," "," "," "," "," "," "," "," ",M," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ",B,X},
            {X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X}
                }; 
        
        return Doolhof3;
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
}
