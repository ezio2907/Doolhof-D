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
public class Uitgang  extends Voorwerpen{
    
    
    @Override
    public ImageIcon tekenJezelf(){
        ImageIcon image = new ImageIcon("Z:/Gebruiker/Documenten/NetBeansProjects/Doolhof-D/graphics/door.png");
        return image;
    }
    
    @Override
    public Vierkant teken(){
        Vierkant plaatje = new Vierkant(this.getX() + 1, this.getY() + 1, "zwaart");
        return plaatje;
    }
    
    @Override
    public int pickUp(){
        return 1;
    }
    
    @Override
    public String toString(){
        return "U";
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Uitgang)) {
            return false;
        }
        return true;
    }
}
