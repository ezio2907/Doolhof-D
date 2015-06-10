/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class Pad extends Voorwerpen{
    
    @Override
    public ImageIcon tekenJezelf(){
        ImageIcon image = new ImageIcon("Z:/Gebruiker/Documenten/NetBeansProjects/Doolhof-D/graphics/floor.png");
        return image;
    }
    
    @Override
    public Vierkant teken(){
        Vierkant plaatje = new Vierkant(this.getX() + 1, this.getY() + 1, "wit");
        return plaatje;
    }
    
    @Override
    public String toString(){
        return " ";
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pad)) {
            return false;
        }
        return true;
    }
    
    public Vierkant snelste(){
        Vierkant plaatje = new Vierkant(this.getX() + 1, this.getY() + 1, "rood");
        return plaatje;
    }
    
}
