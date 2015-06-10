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
public class Muur extends Voorwerpen {

    Muur(boolean verwoestbaar) {
        this.vernietigbaar = verwoestbaar;
        this.loopbaar = false;
    }

    @Override
    public ImageIcon tekenJezelf(){
        ImageIcon image = new ImageIcon("Z:/Gebruiker/Documenten/NetBeansProjects/Doolhof-D/graphics/muur.png");
        return image;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Muur)) {
            return false;
        }
        return true;
    }

    public void vernietig() {
        System.out.println("muur word vernietigd");
    }

    public boolean getVernietigbaar() {
        return vernietigbaar;
    }
    
    @Override
    public String toString(){
        return "M";
    }
}
