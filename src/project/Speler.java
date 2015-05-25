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
public class Speler {
    public int X;
    public int Y;
    public Doolhof Dh;
    public boolean bazooka = false;
    public ArrayList<JLabel> labels;
    
    
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
        if(!Dh.X.equals(Dh.Doolhof[y][x]) && !Dh.M.equals(Dh.Doolhof[y][x])){
            if(!" ".equals(Dh.Doolhof[y][x])){
//                if("B".equals(Dh.Doolhof[y][x])){
//                    Dh.B.pickUp();
//                } else if ("H".equals(Dh.Doolhof[y][x])){
//                    Dh.H.pickUp(labels);
//                } else if ("V".equals(Dh.Doolhof[y][x])){
//                    Dh.V.pickUp();
//                } else if ("U".equals(Dh.Doolhof[y][x])){
//                    Dh.U.pickUp();
//                }
            }
            return true;
        } else {
            return false;
        }
    }
    
}
