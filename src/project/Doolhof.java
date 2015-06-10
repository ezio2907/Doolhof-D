/*
 * To change this template," "choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Doolhof {
    private Voorwerpen[][] Doolhof;
    private int maxStappen;
    private Speler S = new Speler();
    private int aantalStappen = 0;
    private int level = 0;
        
    public Voorwerpen[][] getDoolhof(){
        return Doolhof;
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
    public void levelUp(){
        level++;
    }
    
    
    public boolean setStappen(int aantalStappen){
        this.aantalStappen = aantalStappen;
        if (aantalStappen >= maxStappen){
            return true;
        }
        return false;
    }
    
    public void setMaxStappen(int maxStappen){
        this.maxStappen = maxStappen;
    }
    
    public void setDoolhof(int nummer) throws IOException{
        if(nummer == 1){
            this.Doolhof = DoolhofMaak(1);
            maxStappen = 80;
            level = nummer;
        }else if(nummer == 2){
            this.Doolhof = DoolhofMaak(2);
            maxStappen = 90;
            level = nummer;
        }else if(nummer == 3){
            this.Doolhof = DoolhofMaak(3);
            maxStappen = 150;
            level = nummer;
        }else{
            this.Doolhof = DoolhofMaak(1);
            maxStappen = 80;
            level = 1;
        }
    }
    
    private Voorwerpen[][] DoolhofMaak(int level) throws IOException{
        String path = "Doolhof/Doolhof"+level+".txt";
        BufferedReader d1 = new BufferedReader(new FileReader(path));
        String line = d1.readLine();
        Voorwerpen[][] Doolhof1 = new Voorwerpen[line.length()][line.length()];
        int y = 0;
        
        Voorwerpen[] spelObjecten = new Voorwerpen[line.length()];
        for (int i = 0; i < line.length(); i++) {
            spelObjecten[i] = maakVoorwerp(y, i, line.charAt(i));
        }
        Doolhof1[y] = spelObjecten;
        while((line = d1.readLine()) != null){
            y++;
            spelObjecten = new Voorwerpen[line.length()];
            for (int i = 0; i < line.length(); i++) {
                spelObjecten[i] = maakVoorwerp(y, i, line.charAt(i));
            }
            Doolhof1[y]=spelObjecten;
        }
        d1.close();
        return Doolhof1;
    }
    
    private Voorwerpen maakVoorwerp(int y, int x, Character voorwerp){
        if (voorwerp == 'X') {
            Muur X = new Muur(false);
            X.setP(x, y);
            return X;
        } else if (voorwerp == 'M') {
            Muur M = new Muur(true);
            M.setP(x, y);
            return M;
        } else if (voorwerp == 'S') {
            S.setP(x, y);
            Pad P = new Pad();
            P.setP(x, y);
            return P;
        } else if (voorwerp == 'B') {
            Bazooka B = new Bazooka();
            B.setP(x, y);
            return B;
        } else if (voorwerp == 'U') {
            Uitgang U = new Uitgang();
            U.setP(x, y);
            return U;
        } else if (voorwerp == 'V') {
            Valsspeler V = new Valsspeler();
            V.setP(x, y);
            return V;
        } else if (voorwerp == 'H') {
            Helper H = new Helper();
            H.setP(x, y);
            return H;
        } else if (voorwerp == ' ') {
            Pad P = new Pad();
            P.setP(x, y);
            return P;
        } else {
            Pad P = new Pad();
            P.setP(x, y);
            return P;
        }
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
