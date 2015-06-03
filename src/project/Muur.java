/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

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
    public String teken() {
        if (vernietigbaar) {
            return "M";
        } else {
            return "X";
        }
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

    public String toString() {
        return "dit is een muur";
    }
}
