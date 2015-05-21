/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Admin
 */
public class Muur {
    public boolean verwoestbaar = true;
    public boolean loopbaar = false;
    
    public String teken(){
        if(verwoestbaar){
            return "M";
        } else if (!verwoestbaar){
            return "X";
        }
        return null;
    }
}
