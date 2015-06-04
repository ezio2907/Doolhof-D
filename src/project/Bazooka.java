/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Admin
 */
public class Bazooka extends Voorwerpen{
    
    @Override
    public Vierkant teken(){
        Vierkant plaatje = new Vierkant(this.getX() + 1, this.getY() + 1, "wit");
        return plaatje;
    }
    
    @Override
    public int pickUp(){
        return 3;
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Bazooka)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "B";
    }
}
