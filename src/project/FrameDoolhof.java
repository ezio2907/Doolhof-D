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
        
        labels.get(positie).setText(" ");
        
        labels.get(nPositie).setText("S");

        if(Dh.setStappen(Dh.getStappen() + 1)){
            stappenLabel.setText(" GAME OVER!");
            pauze = true;
            startButton.setFocusable(false);
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
        
        if (objecten.get(positie).pickUp() == 1) { //Uitgang
            pauzeButton.doClick();
            Dh.levelUp();
            try {
                LevelCreater(Dh.getLevel());
                opnieuwButton.doClick();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            opnieuwButton.doClick();
            return false;
        } else if (objecten.get(positie).pickUp() == 2){ //Valsspeler
            Dh.setMaxStappen(Integer.parseInt(labels.get(positie).getText()) + Dh.getMaxStappen());
            
            Pad P = new Pad();
            P.setP(x, y);
            objecten.set(positie, P);
            labels.get(positie).setText(P.teken());
        } else if (objecten.get(positie).pickUp() == 3){ //Bazooka
            S.setBazooka(true);
            
            Pad P = new Pad();
            P.setP(x, y);
            objecten.set(positie, P);
            labels.get(positie).setText(P.teken());
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
                            S.setDirection('W');
                            if (canMove("Links")) {
                                int X = S.getX();
                                int Y = S.getY();
                                beweegSpeler(X - 1, Y);
                                S.setP(X - 1, Y);
                            }
                        }
                        if (e.getKeyCode() == 38) { //Omhoog
                            S.setDirection('N');
                            if (canMove("Omhoog")) {
                                int X = S.getX();
                                int Y = S.getY();
                                beweegSpeler(X, Y - 1);
                                S.setP(X, Y - 1);
                            }
                        }
                        if (e.getKeyCode() == 39) { //Rechts
                            S.setDirection('E');
                            if (canMove("Rechts")) {
                                int X = S.getX();
                                int Y = S.getY();
                                beweegSpeler(X + 1, Y);
                                S.setP(X + 1, Y);
                            }
                        }
                        if (e.getKeyCode() == 40) { //Omlaag
                            S.setDirection('S');
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
//                                vuur(S.getDirection());
                                if (S.getDirection() == 'N') {
                                    vernietigN();
                                }else if (S.getDirection() == 'E'){
                                    vernietigE();
                                }else if (S.getDirection() == 'S'){
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

//    public void vuur(Character direction) {
//        int KogelX = S.getX();
//        int KogelY = S.getY();
//        int positie = Doolhof.length * KogelY + KogelX;
//        if(direction == 'N'){
//            while (KogelY >= 0) {
//                if (objecten.get(positie).vernietigbaar) {
//                    Pad P = new Pad();
//                    P.setP(objecten.get(positie).getX(), objecten.get(positie).getY());
//                    objecten.set(positie, P);
//                    labels.get(positie).setText(P.teken());
//                }
//                KogelY--;
//                positie = Doolhof.length * KogelY + KogelX;
//            }
//        }else if(direction == 'E'){
//            while (KogelX <= Doolhof.length) {
//                if (objecten.get(positie).vernietigbaar) {
//                    Pad P = new Pad();
//                    P.setP(objecten.get(positie).getX(), objecten.get(positie).getY());
//                    objecten.set(positie, P);
//                    labels.get(positie).setText(P.teken());
//                }
//                KogelX++;
//                positie = Doolhof.length * KogelY + KogelX;
//            }
//        }else if(direction == 'S'){
//            while (KogelY <= Doolhof.length) {
//                    if (objecten.get(positie).vernietigbaar) {
//                        Pad P = new Pad();
//                        P.setP(objecten.get(positie).getX(), objecten.get(positie).getY());
//                        objecten.set(positie, P);
//                        labels.get(positie).setText(P.teken());
//                    }
//                KogelY++;
//                positie = Doolhof.length * KogelY + KogelX;
//            } 
//        } else {
//            while (KogelX >= 0) {
//                if (objecten.get(positie).vernietigbaar) {
//                    Pad P = new Pad();
//                    P.setP(objecten.get(positie).getX(), objecten.get(positie).getY());
//                    objecten.set(positie, P);
//                    labels.get(positie).setText(P.teken());
//                } 
//                KogelX--;
//                positie = Doolhof.length * KogelY + KogelX;
//            }
//        }
//    }
    
    public void vernietigN() {
        Muur m = new Muur(true);
        Muur x = new Muur(false);
        int KogelX = S.getX();
        int KogelY = S.getY();
        int positie = Doolhof.length * KogelY + KogelX;
        outerloop:
        while (KogelY >= 0) {
            if (objecten.get(positie).equals(m)) {
                if (objecten.get(positie).vernietigbaar) {
                    Pad P = new Pad();
                    P.setP(objecten.get(positie).getX(), objecten.get(positie).getY());
                    objecten.set(positie, P);
                    labels.get(positie).setText(P.teken());
                }
                break outerloop;
            }
            KogelY--;
            positie = Doolhof.length * KogelY + KogelX;
        }
    }

    public void vernietigE() {
        Muur m = new Muur(true);
        Muur x = new Muur(false);
        int KogelX = S.getX();
        int KogelY = S.getY();
        int positie = Doolhof.length * KogelY + KogelX;
        outerloop:
        while (KogelX <= Doolhof.length) {
            if (objecten.get(positie).equals(m)) {
                if (objecten.get(positie).vernietigbaar) {
                    Pad P = new Pad();
                    P.setP(objecten.get(positie).getX(), objecten.get(positie).getY());
                    objecten.set(positie, P);
                    labels.get(positie).setText(P.teken());
                }
                break outerloop;
            }
            System.out.println(objecten.get(positie).toString());
            KogelX++;
            positie = Doolhof.length * KogelY + KogelX;
        }
    }

    public void vernietigS() {
        Muur m = new Muur(true);
        Muur x = new Muur(false);
        int KogelX = S.getX();
        int KogelY = S.getY();
        int positie = Doolhof.length * KogelY + KogelX;
        outerloop:
        while (KogelY <= Doolhof.length) {
            if (objecten.get(positie).equals(m)) {
                if (objecten.get(positie).vernietigbaar) {
                    Pad P = new Pad();
                    P.setP(objecten.get(positie).getX(), objecten.get(positie).getY());
                    objecten.set(positie, P);
                    labels.get(positie).setText(P.teken());
                }
                break outerloop;
            }
            System.out.println(objecten.get(positie).toString());
            KogelY++;
            positie = Doolhof.length * KogelY + KogelX;
        }
    }

    public void vernietigW() {
        Muur m = new Muur(true);
        Muur x = new Muur(false);
        int KogelX = S.getX();
        int KogelY = S.getY();
        int positie = Doolhof.length * KogelY + KogelX;
        outerloop:
        while (KogelX >= 0) {
            if (objecten.get(positie).equals(m)) {
                if (objecten.get(positie).vernietigbaar) {
                    Pad P = new Pad();
                    P.setP(objecten.get(positie).getX(), objecten.get(positie).getY());
                    objecten.set(positie, P);
                    labels.get(positie).setText(P.teken());
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
