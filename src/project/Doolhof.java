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
    private Character[][] Doolhof;
    private int maxStappen;
    private Speler S = new Speler();
    private int aantalStappen = 0;
    private int level = 0;
        
    public Character[][] getDoolhof(){
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
            this.Doolhof = Doolhof1();
            maxStappen = 80;
            level = nummer;
        }else if(nummer == 2){
            this.Doolhof = Doolhof2();
            maxStappen = 90;
            level = nummer;
        }else if(nummer == 3){
            this.Doolhof = Doolhof3();
            maxStappen = 150;
            level = nummer;
        }
    }
    
    private Character[][] Doolhof1() throws IOException{
        String path = "Doolhof/Doolhof1.txt";
        BufferedReader d1 = new BufferedReader(new FileReader(path));
        String line = d1.readLine();
        Character[][] Doolhof1 = new Character[line.length()][line.length()];
        int x = 0;
        
        Character[] Characters = new Character[line.length()];
        for (int i = 0; i < line.length(); i++) {
            Characters[i] = line.charAt(i);
        }
        Doolhof1[x] = Characters;
        while((line = d1.readLine()) != null){
            x++;
            Characters = new Character[line.length()];
            for (int i = 0; i < line.length(); i++) {
                Characters[i] = line.charAt(i);
            }
            Doolhof1[x]=Characters;
        }
        d1.close();
        return Doolhof1;
    }
    
    private Character[][] Doolhof2() throws IOException{
        String path = "Doolhof/Doolhof2.txt";
        BufferedReader d2 = new BufferedReader(new FileReader(path));
        String line = d2.readLine();
        Character[][] Doolhof2 = new Character[line.length()][line.length()];
        int x = 0;
        
        Character[] Characters = new Character[line.length()];
        for (int i = 0; i < line.length(); i++) {
            Characters[i] = line.charAt(i);
        }
        Doolhof2[x] = Characters;
        
        while((line = d2.readLine()) != null){
            x++;
            Characters = new Character[line.length()];
            for (int i = 0; i < line.length(); i++) {
                Characters[i] = line.charAt(i);
            }
            Doolhof2[x]=Characters;
        }
        d2.close();
        return Doolhof2;
    }
    
    private Character[][] Doolhof3() throws IOException{
        String path = "Doolhof/Doolhof3.txt";
        BufferedReader d3 = new BufferedReader(new FileReader(path));
        String line = d3.readLine();
        Character[][] Doolhof3 = new Character[line.length()][line.length()];
        int x = 0;
        
        Character[] Characters = new Character[line.length()];
        for (int i = 0; i < line.length(); i++) {
            Characters[i] = line.charAt(i);
        }
        Doolhof3[x] = Characters;
        
        while((line = d3.readLine()) != null){
            x++;
            Characters = new Character[line.length()];
            for (int i = 0; i < line.length(); i++) {
                Characters[i] = line.charAt(i);
            }
            Doolhof3[x]=Characters;
        }
        d3.close();
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
