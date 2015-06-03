/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class Speler{
    private int X;
    private int Y;
    private boolean bazooka = true;
    private String direction = "E";
    
    
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
    
    public void setBazooka(boolean B){
        bazooka = B;
    }
    
    public Boolean getBazooka(){
        return bazooka;
    }
    
    public void setDirection(String D){
        direction = D;
    }
        
    public String getDirection(){
        return direction;
    }
    
    public String teken() {
        return "S";
    }
    
}
