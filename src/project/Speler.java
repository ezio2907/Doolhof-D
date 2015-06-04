/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Admin
 */
public class Speler{
    private int X;
    private int Y;
    private boolean bazooka = true;
    private Character direction = 'E';
    
    
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
    
    public void setDirection(Character D){
        direction = D;
    }
        
    public Character getDirection(){
        return direction;
    }
    
    public String teken() {
        return "S";
    }
    
}
