/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Speler {
    public int X;
    public int Y;
    public Doolhof Dh;
    
    
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public void setP(int X, int Y){
        this.X = X;
        this.Y = Y;
    }
    
    
    public int canMove(String direction) {
        int x;
        int y;
        if("Rechts".equals(direction)) {
            x = getX()+1;
            y = getY();
        } else if("Links".equals(direction)) {
            x = getX()-1;
            y = getY();
        } else if("Omhoog".equals(direction)) {
            x = getX();
            y = getY()-1;
        } else {
            x = getX();
            y = getY()+1;
        }
        if(!Dh.X.equals(Dh.Doolhof[y][x]) && !Dh.M.equals(Dh.Doolhof[y][x])){
            if(!" ".equals(Dh.Doolhof[y][x])){
                if("B".equals(Dh.Doolhof[y][x])){
                    
                } else if ("H".equals(Dh.Doolhof[y][x])){
                    
                } else if ("V".equals(Dh.Doolhof[y][x])){
                    Dh.maxStappen = Dh.maxStappen + 20;
                } else if ("U".equals(Dh.Doolhof[y][x])){
                    Dh.level++;
                    return 2;
                }
            }
            
            return 1;
        } else {
            return 0;
        }
    }
    
}
