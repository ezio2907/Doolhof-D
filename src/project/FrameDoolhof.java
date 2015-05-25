/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class FrameDoolhof {
    public Object[][] Doolhof;
    public ArrayList<JLabel> labels;
    public GamePanel frame;
    public JPanel jPanel1;
    public Speler S;
    public Doolhof Dh = new Doolhof();
    public JButton startButton = new JButton("Start");
    public JButton pauzeButton = new JButton("Pauze");
    public JButton opnieuwButton = new JButton("Opnieuw");
    public boolean pauze;
    public JLabel stappenLabel = new JLabel();
    
    
    public void LevelCreater(int level){
        jPanel1 = new JPanel();
        labels= new ArrayList<>();
        S = null;
        frame = new GamePanel();
            
        Dh.setDoolhof(level);
        Doolhof = Dh.Doolhof;
        S = Dh.S;
        S.Dh = this.Dh;
        Dh.aantalStappen = 0;
        
        JPanel knopenPanel = new JPanel(new GridLayout(1,6));
        ActionListener opnieuwKnop = new OpnieuwKnop();
        opnieuwButton.addActionListener(opnieuwKnop);
        ActionListener startknop = new StartKnop();
        startButton.addActionListener(startknop);
        ActionListener pauzeknop = new PauzeKnop();
        pauzeButton.addActionListener(pauzeknop);
        stappenLabel.setText("Stappen: " + (Dh.maxStappen - Dh.aantalStappen));
        knopenPanel.add(opnieuwButton);
        knopenPanel.add(pauzeButton);
        knopenPanel.add(startButton);
        knopenPanel.add(stappenLabel);
        
        frame.setLayout(new BorderLayout());
        int FRAME_WIDTH = 18*Doolhof.length;
        int FRAME_HEIGHT = 18*Doolhof.length + 30;
        frame.setVisible(false);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(knopenPanel, BorderLayout.NORTH);
                
        jPanel1.setLayout(new GridLayout(Doolhof.length, Doolhof.length));
        int positie = 0;
        for (int y = 0; y < Doolhof.length; y++) {
            for (int x = 0; x < Doolhof.length; x++) {
                JLabel label = new JLabel();
                labels.add(label);
                if(Doolhof[y][x] == Dh.X){
                    labels.get(positie).setText(Dh.X.teken());
                } else if(Doolhof[y][x] == Dh.M){
                    labels.get(positie).setText(Dh.M.teken());
//                } else if(Doolhof[y][x] == Dh.B){
//                    labels.get(positie).setText(Dh.B.teken());
//                } else if(Doolhof[y][x] == Dh.U){
//                    labels.get(positie).setText(Dh.U.teken());
//                } else if(Doolhof[y][x] == Dh.V){
//                    labels.get(positie).setText(Dh.V.teken());
//                } else if(Doolhof[y][x] == Dh.H){
//                    labels.get(positie).setText(Dh.H.teken());
//                } else if(Doolhof[y][x] == " "){
//                    labels.get(positie).setText(" ");
                } else {
                    labels.get(positie).setText(" ");
                }
                jPanel1.add(label);   
                frame.add(jPanel1);
                positie++;
            }
        }   
        int X = S.getX();
        int Y = S.getY();
        int positie2 = Y * Doolhof.length + X;        
        labels.get(positie2).setText("S");
        S.labels = labels;
        
        frame.setFocusable(true);
        frame.setVisible(true);
        pauze = false;
    }
    
    public void Loop(int nX, int nY){
        int X = S.getX();
        int Y = S.getY();
        int positie = Y * Doolhof.length + X;
        int nPositie = nY * Doolhof.length + nX;
        
        labels.get(nPositie).setText("S");
        
        labels.get(positie).setText(" ");
        
        Dh.aantalStappen++;
        Dh.gameOver();
    }
    
    public class GamePanel extends JFrame {
        public GamePanel() {
            addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) 
                {
                    if(!pauze){
                        if(e.getKeyCode() == 37){ //Links
                            if(S.canMove("Links")){
                                int X = S.getX();
                                int Y = S.getY();
                                Loop(X-1, Y);
                                S.setP(X-1, Y);
                                stappenLabel.setText("Stappen: " + (Dh.maxStappen - Dh.aantalStappen));
                            }
                        }
                        if(e.getKeyCode() == 38){ //Omhoog
                            if(S.canMove("Omhoog")){
                                int X = S.getX();
                                int Y = S.getY();
                                Loop(X, Y-1);
                                S.setP(X, Y-1);
                                stappenLabel.setText("Stappen: " + (Dh.maxStappen - Dh.aantalStappen));
                            }
                        }
                        if(e.getKeyCode() == 39){ //Rechts
                            if(S.canMove("Rechts")){
                                int X = S.getX();
                                int Y = S.getY();
                                Loop(X+1, Y);
                                S.setP(X+1, Y);
                                stappenLabel.setText("Stappen: " + (Dh.maxStappen - Dh.aantalStappen));
                            }
                        }
                        if(e.getKeyCode() == 40){ //Omlaag
                            if(S.canMove("Omlaag")){
                                int X = S.getX();
                                int Y = S.getY();
                                Loop(X, Y+1);
                                S.setP(X, Y+1);
                                stappenLabel.setText("Stappen: " + (Dh.maxStappen - Dh.aantalStappen));
                            }
                        }
                    }
                }
                @Override
                public void keyReleased(KeyEvent e) 
                {  
                    
                }
                @Override
                public void keyTyped(KeyEvent e) 
                { 
                    
                }
            });
            setFocusable(false);
        }
    }
    
    class OpnieuwKnop implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            frame.dispose();
            LevelCreater(Dh.level);
        }        
    }
    
    class StartKnop implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(pauze){
                jPanel1.setVisible(true);
                pauze = false;
                startButton.setFocusable(pauze);
            }
        }        
    }
    
    class PauzeKnop implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(!pauze){
                jPanel1.setVisible(false);
                pauze = true;
                startButton.setFocusable(pauze);
            }
        }        
    }
}
