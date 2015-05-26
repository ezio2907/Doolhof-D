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
    private int X;
    private int Y;
    private Doolhof Dh;
    private boolean bazooka = false;
    private ArrayList<JLabel> labels;
    
    
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public ArrayList<JLabel> getLabels(){
        return labels;
    }
    public void setDoolhof(Doolhof Dh){
        this.Dh = Dh;
    }
    public void setLabels(ArrayList<JLabel> labels){
        this.labels = labels;
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
        if(!Dh.getMuurX().equals(Dh.getDoolhof()[y][x]) && !Dh.getMuurM().equals(Dh.getDoolhof()[y][x])){
            if(!" ".equals(Dh.getDoolhof()[y][x])){
//                if("B".equals(Dh.getDoolhof()[y][x])){
//                    Dh.getBazooka().pickUp();
//                } else if ("H".equals(Dh.getDoolhof()[y][x])){
//                    Dh.getHelper().pickUp(labels);
//                } else if ("V".equals(Dh.getDoolhof()[y][x])){
//                    Dh.getValsspeler.pickUp();
//                } else if ("U".equals(Dh.getDoolhof()[y][x])){
//                    Dh.getUitgang.pickUp();
//                }
            }
            return true;
        } else {
            return false;
        }
    }
    
}
