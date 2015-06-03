/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Valsspeler extends Voorwerpen{
    private int waarde = 0;
    
    public Valsspeler(){
        Random generator = new Random();
        waarde = generator.nextInt(30) + 1;
    }
    
    
    @Override
    public String teken(){
        return waarde + "";
    }
    
    @Override
    public int pickUp(){
        return 2;
    }
}
