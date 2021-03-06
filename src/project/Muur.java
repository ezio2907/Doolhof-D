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
        ImageIcon image = new ImageIcon("graphics/muur.png");
        return image;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Muur)) {
            return false;
        }
        return true;
    }

    public boolean getVernietigbaar() {
        return vernietigbaar;
    }
    
    @Override
    public String toString(){
        return "M";
    }
}
