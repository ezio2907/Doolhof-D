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
public class Speler {

    private int X;
    private int Y;
    private boolean bazooka = false;
    private Character direction = 'S';

    public ImageIcon tekenJezelf() {
        ImageIcon image;
        if (direction == 'N') {
            image = new ImageIcon("Z:/Gebruiker/Documenten/NetBeansProjects/Doolhof-D/graphics/spelerN.png");
        } else if (direction == 'E') {
            image = new ImageIcon("Z:/Gebruiker/Documenten/NetBeansProjects/Doolhof-D/graphics/spelerE.png");
        } else if (direction == 'S') {
            image = new ImageIcon("Z:/Gebruiker/Documenten/NetBeansProjects/Doolhof-D/graphics/spelerS.png");
        } else {
            image = new ImageIcon("Z:/Gebruiker/Documenten/NetBeansProjects/Doolhof-D/graphics/spelerW.png");
        }
        return image;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setP(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public void setBazooka(boolean B) {
        bazooka = B;
    }

    public Boolean getBazooka() {
        return bazooka;
    }

    public void setDirection(Character D) {
        direction = D;
    }

    public Character getDirection() {
        return direction;
    }

    public String toString() {
        return "S";
    }
}
