/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class Helper extends Voorwerpen{
    public ArrayList<JLabel> labels;
    
    @Override
    public Vierkant teken(){
        Vierkant plaatje = new Vierkant(this.getX() + 1, this.getY() + 1, "blauw");
        return plaatje;
    }
    
    public void pickUp(ArrayList<JLabel> labels){
        this.labels = labels;
    }
    
    @Override
    public String toString(){
        return "H";
    }
    
//    public ??? vindWeg(){
//        Gebruik een "Stack" lijst
//        //pop = verwijder laatste in stack
//        //push = toevoegen als laatste in stack
//        
//        Push all paths from the point on which you are standing on a stack.
//            While (the stack is not empty){
//                Pop a path from the stack.
//                Follow the path until you reach an exit, intersection, or dead end.
//                If (you found an exit){
//                    Congratulations!
//                } else if (you found an intersection){
//                    Push all paths meeting at the intersection, except the current one, onto the stack.
//                }
//            }
//    }
    
    
    
}
