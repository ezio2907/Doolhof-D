/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class Bazooka extends Voorwerpen{
    
    private int vernietigdeMuurX;
    private int vernietigdeMuurY;
    
    @Override
    public ImageIcon tekenJezelf(){
        ImageIcon image = new ImageIcon("Z:/Gebruiker/Documenten/NetBeansProjects/Doolhof-D/graphics/bazooka.png");
        return image;
    }
    
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
    
    public Voorwerpen[][] vuur(Character directie, Voorwerpen[][] Doolhof, int length, int X, int Y) {
        if (directie == 'N') {
            vernietigN(Doolhof, length, X, Y);
        } else if (directie == 'E') {
            vernietigE(Doolhof, length, X, Y);
        } else if (directie == 'S') {
            vernietigS(Doolhof, length, X, Y);
        } else {
            vernietigW(Doolhof, length, X, Y);
        }
        return Doolhof;
    }

    private void vernietigN(Voorwerpen[][] Doolhof, int length, int KogelX, int KogelY) {
        Pad p = new Pad();
        Muur m = new Muur(true);
        outerloop:
        while (KogelY >= 0) {
            if (Doolhof[KogelY][KogelX].equals(m)) {
                if (Doolhof[KogelY][KogelX].vernietigbaar == true) {
                    Doolhof[KogelY][KogelX] = p;
                    vernietigdeMuurX = KogelX;
                    vernietigdeMuurY = KogelY;
                }
                break outerloop;
            }
            KogelY--;
        }
    }

    private void vernietigE(Voorwerpen[][] Doolhof, int length, int KogelX, int KogelY) {
        Pad p = new Pad();
        Muur m = new Muur(true);
        int positie = length * KogelY + KogelX;
        outerloop:
        while (KogelX <= length) {
            if (Doolhof[KogelY][KogelX].equals(m)) {
                if (Doolhof[KogelY][KogelX].vernietigbaar == true) {
                    Doolhof[KogelY][KogelX]= p;
                    vernietigdeMuurX = KogelX;
                    vernietigdeMuurY = KogelY;
                }
                break outerloop;
            }
            KogelX++;
            positie = length * KogelY + KogelX;
        }
    }

    private void vernietigS(Voorwerpen[][] Doolhof, int length, int KogelX, int KogelY) {
        Pad P = new Pad();
        Muur m = new Muur(true);
        int positie = length * KogelY + KogelX;
        outerloop:
        while (KogelY <= length) {
            if (Doolhof[KogelY][KogelX].equals(m)) {
                if (Doolhof[KogelY][KogelX].vernietigbaar == true) {
                    Doolhof[KogelY][KogelX]=P;
                    vernietigdeMuurX = KogelX;
                    vernietigdeMuurY = KogelY;
                }
                break outerloop;
            }
            KogelY++;
            positie = length * KogelY + KogelX;
        }
    }

    private void vernietigW(Voorwerpen[][] Doolhof, int length, int KogelX, int KogelY) {
        Pad p = new Pad();
        Muur m = new Muur(true);
        int positie = length * KogelY + KogelX;
        outerloop:
        while (KogelX >= 0) {
            if (Doolhof[KogelY][KogelX].equals(m)) {
                if (Doolhof[KogelY][KogelX].vernietigbaar == true) {
                    Doolhof[KogelY][KogelX]= p;
                    vernietigdeMuurX = KogelX;
                    vernietigdeMuurY = KogelY;
                }
                break outerloop;
            }
            KogelX--;
            positie = length * KogelY + KogelX;
        }
    }
    
    public int getVernietigdeMuurX(){
        return vernietigdeMuurX;
    }
    
    public int getVernietigdeMuurY(){
        return vernietigdeMuurY;
    }
}
