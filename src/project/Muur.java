/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Admin
 */
public class Muur extends Voorwerpen{
    
    Muur(boolean verwoestbaar){
        this.vernietigbaar = verwoestbaar;
    }
    
    @Override
    public String teken(){
        if(vernietigbaar){
            return "M";
        } else{
            return "X";
        }
    }
}
