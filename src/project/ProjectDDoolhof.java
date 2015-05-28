/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;

public class ProjectDDoolhof {

    public String[][] Doolhof;

    public static void main(String[] args) {
        startFrame start = new startFrame();
        start.FrameMaken();
    }
    
    public static void beginLevel(int level){
        FrameDoolhof FD = new FrameDoolhof();
        FD.opbouw(level);
    }

}
