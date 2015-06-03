/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class FrameDoolhof {

    public Character[][] Doolhof;
    public ArrayList<JLabel> labels;
    public ArrayList<Voorwerpen> objecten = new ArrayList<>();
    public GamePanel frame;
    public JPanel jPanel1;
    public Speler S;
    public Doolhof Dh;
    public JButton startButton = new JButton("Start");
    public JButton pauzeButton = new JButton("Pauze");
    public JButton opnieuwButton = new JButton("Opnieuw");
    public boolean pauze;
    public JLabel stappenLabel = new JLabel();

    public void opbouw(int level) throws IOException {
        labels = new ArrayList<>();
        //objecten = new ArrayList<>();
        frame = new GamePanel();
        frame.setLayout(new BorderLayout());
        jPanel1 = new JPanel();
        Dh = new Doolhof();
        Dh.setDoolhof(level);
        Doolhof = Dh.getDoolhof();


        JPanel knopenPanel = new JPanel(new GridLayout(1, 6));
        ActionListener opnieuwKnop = new OpnieuwKnop();
        opnieuwButton.addActionListener(opnieuwKnop);
        ActionListener startknop = new StartKnop();
        startButton.addActionListener(startknop);
        ActionListener pauzeknop = new PauzeKnop();
        pauzeButton.addActionListener(pauzeknop);
        stappenLabel.setText("Stappen: " + (Dh.getMaxStappen()));
        knopenPanel.add(opnieuwButton);
        knopenPanel.add(pauzeButton);
        knopenPanel.add(startButton);
        knopenPanel.add(stappenLabel);

        int FRAME_WIDTH = 15 * Doolhof.length;
        int FRAME_HEIGHT = 15 * Doolhof.length + 30;
        frame.setVisible(false);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(knopenPanel, BorderLayout.NORTH);

        LevelCreater(level);
    }

    public void LevelCreater(int level) throws IOException {
        int FRAME_WIDTH = 18 * Doolhof.length;
        int FRAME_HEIGHT = 18 * Doolhof.length + 30;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        objecten = new ArrayList<>();;
        labels.clear();
        jPanel1.removeAll();
        Dh.setDoolhof(level);
        Doolhof = Dh.getDoolhof();
        S = Dh.getSpeler();
        Dh.setStappen(0);
        stappenLabel.setText("Stappen: " + (Dh.getMaxStappen()));
        jPanel1.setLayout(new GridLayout(Doolhof.length, Doolhof.length));

        int positie = 0;
        for (int y = 0; y < Doolhof.length; y++) {
            for (int x = 0; x < Doolhof.length; x++) {
                JLabel label = new JLabel();
                labels.add(label);
                if (Doolhof[y][x] == 'X') {
                    Muur X = new Muur(false);
                    X.setP(x, y);
                    objecten.add(X);
                    labels.get(positie).setText(X.teken());
                } else if (Doolhof[y][x] == 'M') {
                    Muur M = new Muur(true);
                    M.setP(x, y);
                    objecten.add(M);
                    labels.get(positie).setText(M.teken());
                } else if (Doolhof[y][x] == 'S') {
                    Pad P = new Pad();
                    P.setP(x, y);
                    objecten.add(P);
                    Dh.getSpeler().setP(x, y);
                    labels.get(positie).setText(Dh.getSpeler().teken());
                } else if (Doolhof[y][x] == 'B') {
                    Bazooka B = new Bazooka();
                    B.setP(x, y);
                    objecten.add(B);
                    labels.get(positie).setText(B.teken());
                } else if (Doolhof[y][x] == 'U') {
                    Uitgang U = new Uitgang();
                    U.setP(x, y);
                    objecten.add(U);
                    labels.get(positie).setText(U.teken());
                } else if (Doolhof[y][x] == 'V') {
                    Valsspeler V = new Valsspeler();
                    V.setP(x, y);
                    objecten.add(V);
                    labels.get(positie).setText(V.teken());
                } else if (Doolhof[y][x] == 'H') {
                    Helper H = new Helper();
                    H.setP(x, y);
                    objecten.add(H);
                    labels.get(positie).setText(H.teken());
                } else if (Doolhof[y][x] == ' ') {
                    Pad P = new Pad();
                    P.setP(x, y);
                    labels.get(positie).setText(P.teken());
                    objecten.add(P);
                } else {
                    Pad P = new Pad();
                    P.setP(x, y);
                    labels.get(positie).setText(P.teken());
                    objecten.add(P);
                }
                jPanel1.add(label);
                frame.add(jPanel1);
                positie++;
            }
        }
        frame.setFocusable(true);
        frame.setVisible(true);
        jPanel1.setVisible(false);
        pauze = true;
        startButton.setFocusable(pauze);
    }

    private void beweegSpeler(int nX, int nY) {
        int X = S.getX();
        int Y = S.getY();
        int positie = Y * Doolhof.length + X;
        int nPositie = nY * Doolhof.length + nX;
        
        if (objecten.get(nPositie).pickUp() == 1) { //Uitgang
            pauzeButton.doClick();
            Dh.levelUp();
            try {
                LevelCreater(Dh.getLevel());
            } catch (IOException ex) {
                System.out.println(ex);
            }
            opnieuwButton.doClick();
        } 
        
        labels.get(positie).setText(" ");
        
        labels.get(nPositie).setText("S");

        if(Dh.setStappen(Dh.getStappen() + 1)){
            stappenLabel.setText(" GAME OVER!");
            pauze = true;
        } else {
            stappenLabel.setText("Stappen: " + (Dh.getMaxStappen() - Dh.getStappen()));
        }
    }

    public boolean canMove(String direction){
        int x = S.getX();
        int y = S.getY();
        switch (direction) {
            case "Rechts":
                x = S.getX() + 1;
                break;
            case "Links":
                x = S.getX() - 1;
                break;
            case "Omhoog":
                y = S.getY() - 1;
                break;
            case "Omlaag":
                y = S.getY() + 1;
                break;
        }
        int positie = y * Doolhof.length + x;
        
        if (objecten.get(positie).pickUp() == 2){ //Valsspeler
            Dh.setMaxStappen(Integer.parseInt(labels.get(positie).getText()) + Dh.getMaxStappen());
        } else if (objecten.get(positie).pickUp() == 3){ //Bazooka
            S.setBazooka(true);
        }
        return objecten.get(positie).loopbaar;
    }

    public class GamePanel extends JFrame {

        public GamePanel() {
            addKeyListener(new KeyListener() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (!pauze) {
                        if (e.getKeyCode() == 37) { //Links
                            S.setDirection("W");
                            if (canMove("Links")) {
                                int X = S.getX();
                                int Y = S.getY();
                                beweegSpeler(X - 1, Y);
                                S.setP(X - 1, Y);
                            }
                        }
                        if (e.getKeyCode() == 38) { //Omhoog
                            S.setDirection("N");
                            if (canMove("Omhoog")) {
                                int X = S.getX();
                                int Y = S.getY();
                                beweegSpeler(X, Y - 1);
                                S.setP(X, Y - 1);
                            }
                        }
                        if (e.getKeyCode() == 39) { //Rechts
                            S.setDirection("E");
                            if (canMove("Rechts")) {
                                int X = S.getX();
                                int Y = S.getY();
                                beweegSpeler(X + 1, Y);
                                S.setP(X + 1, Y);
                            }
                        }
                        if (e.getKeyCode() == 40) { //Omlaag
                            S.setDirection("S");
                            if (canMove("Omlaag")) {
                                int X = S.getX();
                                int Y = S.getY();
                                beweegSpeler(X, Y + 1);
                                S.setP(X, Y + 1);
                            }
                        }
                        if (e.getKeyCode() == 32) { //Spatie
                            if (S.getBazooka()) {
                                S.setBazooka(false);
                                if (S.getDirection().contentEquals("N")) {
                                    vernietigN();
                                }else if (S.getDirection().contentEquals("E")){
                                    vernietigE();
                                }else if (S.getDirection().contentEquals("S")){
                                    vernietigS();
                                }else{
                                    vernietigW();
                                }
                            }
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }

                @Override
                public void keyTyped(KeyEvent e) {
                }
            });
            setFocusable(
                    false);
        }
    }

    public void vernietigN() {
        Pad p = new Pad();
        Muur m = new Muur(true);
        Muur x = new Muur(false);
        int KogelX = S.getX();
        int KogelY = S.getY();
        int positie = Doolhof.length * KogelY + KogelX;
        outerloop:
        while (KogelY >= 0) {
            if (objecten.get(positie).equals(m)) {
                if (objecten.get(positie).vernietigbaar == true) {
                    System.out.println("deze muur kan breken");
                    objecten.set(positie, p);
                } else {
                    System.out.println("deze muur kan niet breken");
                }
                break outerloop;
            }
            System.out.println(objecten.get(positie).toString());
            KogelY--;
            positie = Doolhof.length * KogelY + KogelX;
        }
    }

    public void vernietigE() {
        Pad p = new Pad();
        Muur m = new Muur(true);
        Muur x = new Muur(false);
        int KogelX = S.getX();
        int KogelY = S.getY();
        int positie = Doolhof.length * KogelY + KogelX;
        outerloop:
        while (KogelX <= Doolhof.length) {
            if (objecten.get(positie).equals(m)) {
                if (objecten.get(positie).vernietigbaar == true) {
                    System.out.println("deze muur kan breken");
                    objecten.set(positie, p);
                } else {
                    System.out.println("deze muur kan niet breken");
                }
                break outerloop;
            }
            System.out.println(objecten.get(positie).toString());
            KogelX++;
            positie = Doolhof.length * KogelY + KogelX;
        }
    }

    public void vernietigS() {
        Pad p = new Pad();
        Muur m = new Muur(true);
        Muur x = new Muur(false);
        int KogelX = S.getX();
        int KogelY = S.getY();
        int positie = Doolhof.length * KogelY + KogelX;
        outerloop:
        while (KogelY <= Doolhof.length) {
            if (objecten.get(positie).equals(m)) {
                if (objecten.get(positie).vernietigbaar == true) {
                    System.out.println("deze muur kan breken");
                    objecten.set(positie, p);
                } else {
                    System.out.println("deze muur kan niet breken");
                }
                break outerloop;
            }
            System.out.println(objecten.get(positie).toString());
            KogelY++;
            positie = Doolhof.length * KogelY + KogelX;
        }
    }

    public void vernietigW() {
        Pad p = new Pad();
        Muur m = new Muur(true);
        Muur x = new Muur(false);
        int KogelX = S.getX();
        int KogelY = S.getY();
        int positie = Doolhof.length * KogelY + KogelX;
        outerloop:
        while (KogelX >= 0) {
            if (objecten.get(positie).equals(m)) {
                if (objecten.get(positie).vernietigbaar == true) {
                    System.out.println("deze muur kan breken");
                    objecten.set(positie, p);
                } else {
                    System.out.println("deze muur kan niet breken");
                }
                break outerloop;
            }
            System.out.println(objecten.get(positie).toString());
            KogelX--;
            positie = Doolhof.length * KogelY + KogelX;
        }
    }

    class OpnieuwKnop implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            pauze = true;
            jPanel1.setVisible(false);
            try {
                LevelCreater(Dh.getLevel());
            } catch (IOException ex) {
                Logger.getLogger(FrameDoolhof.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class StartKnop implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (pauze) {
                jPanel1.setVisible(true);
                pauze = false;
                startButton.setFocusable(pauze);
            }
        }
    }

    class PauzeKnop implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (!pauze) {
                jPanel1.setVisible(false);
                pauze = true;
                startButton.setFocusable(pauze);
            }
        }
    }
}
