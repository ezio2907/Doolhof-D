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
    public Object[][] Doolhof;
    
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
    
    
    public boolean canMove(String direction) {
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
        if(!"X".equals(Doolhof[y][x])){
            if(!" ".equals(Doolhof[y][x])){
                
            }
            return true;
        } else {
            return false;
        }
    }
    
}
