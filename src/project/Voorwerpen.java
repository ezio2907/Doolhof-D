/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import javax.swing.JLabel;
import project.Valsspeler;
import project.Muur;
import project.Helper;
import project.Bazooka;
import project.Uitgang;

/**
 *
 * @author Admin
 */
public abstract class Voorwerpen{
    public boolean loopbaar = true;
    public boolean vernietigbaar = false;
    public Doolhof Dh;
    private Voorwerpen Valsspeler;
    private Voorwerpen Uitgang;
    private Voorwerpen Muur;
    private Voorwerpen Helper;
    private Voorwerpen Bazooka;
    private int X;
    private int Y;
    
    public void setP(int X, int Y){
        this.X = X;
        this.Y = Y;
    }
    
    
    public void setDH(Doolhof Dh){
        this.Dh = Dh;
    }
    
    public int pickUp(){
        return 0;
    }
    
    public String teken(){
        return "J";
    }
    
    public Voorwerpen setVoowerp(String voorwerp){
        switch (voorwerp) {
            case "V":
                return Valsspeler;
            case "M":
                return Muur;
            case "X":
                return Muur;
            case "H":
                return Helper;
            case "U":
                return Uitgang;
            default:
                return null;
        }
    }
    
    public Voorwerpen getVoowerp(Voorwerpen voorwerp){
        if (voorwerp == Valsspeler) {
            return Valsspeler;
        } else if (voorwerp == Helper) {
            return Helper;
        } else if (voorwerp == Bazooka) {
            return Bazooka;
        } else if (voorwerp == Uitgang) {
            return Uitgang;
        } else if (voorwerp == Muur) {
            return Muur;
        } else {
            return null;
        }
    }
}
