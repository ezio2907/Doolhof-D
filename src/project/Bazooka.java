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
    public String teken(){
        return "B";
    }
    
    @Override
    public void pickUp(){
        
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Bazooka)) {
            return false;
        }
        return true;
    }
}
