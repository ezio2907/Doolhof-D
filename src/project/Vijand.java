/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class Vijand {
    private int X;
    private int Y;
    private Character direction = 'S';

    public ImageIcon tekenJezelf() {
        ImageIcon image;
        if (direction == 'N') {
            image = new ImageIcon("graphics/MonsterN.png");
        } else if (direction == 'E') {
            image = new ImageIcon("graphics/MonsterE.png");
        } else if (direction == 'S') {
            image = new ImageIcon("graphics/MonsterS.png");
        } else {
            image = new ImageIcon("graphics/MonsterW.png");
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

    public void setDirection(Character D) {
        direction = D;
    }

    public Character getDirection() {
        return direction;
    }
    
    public Character nieuwDirection(boolean[] kanten){
        Random generator = new Random();
        boolean moved = false;
        if(kanten[0] == kanten[1] && kanten[1] == kanten[2] && kanten[2] == kanten[3] && kanten[1] == false){
                if(direction == 'N'){
                    kanten[3] = true;
                }
                if(direction == 'E'){
                    kanten[1] = true;
                }
                if(direction == 'W'){
                    kanten[2] = true;
                }
                if(direction == 'S'){
                    kanten[0] = true;
                }
            }
        int kant = generator.nextInt(3);
        while(!moved){
            if(kanten[kant]){
                if(kant == 0){
                    setDirection('N');
                }
                if(kant == 2){
                    setDirection('E');
                }
                if(kant == 1){
                    setDirection('W');
                }
                if(kant == 3){
                    setDirection('S');
                }
                moved = true;
            } else{
                int kantikum = 0;
                do{
                    kantikum = generator.nextInt(4);
                }while(kantikum == kant);
                kant = kantikum;
            }                
        }
        return getDirection();
    }
}
