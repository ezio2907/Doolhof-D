/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Admin
 */
public class Uitgang  extends Voorwerpen{
    
    @Override
    public String teken(){
        return "U";
    }
    
    @Override
    public int pickUp(){
        return 1;
    }
}
