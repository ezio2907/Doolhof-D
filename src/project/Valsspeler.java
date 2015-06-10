/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class Valsspeler extends Voorwerpen{
    
    public Valsspeler(){
        Random generator = new Random();
        setValue(generator.nextInt(30) + 1);
    }
    
    @Override
    public ImageIcon tekenJezelf(){
        ImageIcon image = new ImageIcon("Z:/Gebruiker/Documenten/NetBeansProjects/Doolhof-D/graphics/valsspeler.png");
        return image;
    }
    
    @Override
    public Vierkant teken(){
        Vierkant plaatje = new Vierkant(this.getX() + 1, this.getY() + 1, "wit");
        return plaatje;
    }
    
    @Override
    public int pickUp(){
        return 2;
    }
    
    @Override
    public String toString(){
        return getValue() + "";
    }
}
