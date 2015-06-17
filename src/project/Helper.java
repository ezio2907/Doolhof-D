/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class Helper extends Voorwerpen {
    
    @Override
    public ImageIcon tekenJezelf(){
        ImageIcon image = new ImageIcon("graphics/map.png");
        return image;
    }
    
    @Override
    public Vierkant teken() {
        Vierkant plaatje = new Vierkant(this.getX() + 1, this.getY() + 1, "blauw");
        return plaatje;
    }
    
    @Override
    public int pickUp() {
        return 4;
    }
    
    @Override
    public String toString() {
        return "H";
    }
    
    private int spelerX;
    private int spelerY;
    private int uitgangX;
    private int uitgangY;
    private Voorwerpen[][] Doolhof;
    public ArrayList<String> paden = new ArrayList<>();
    public ArrayList<Integer> length = new ArrayList<>();
    public ArrayList<int[]> bezocht = new ArrayList<>();
    public ArrayList<Boolean> actief = new ArrayList<>();
    public Muur m = new Muur(true);

    public ArrayList<Voorwerpen> solve() {
        //deze method word aangeroepen vanuit FrameDoolhof
        //vanuit hier wordt alles aangeroepen wat benodigd is om het kortste pad te vinden
        int[] eerste = new int[3];
        eerste[0] = spelerY;
        eerste[1] = spelerX;
        eerste[2] = 0;
        bezocht.add(eerste);
        int a = 0;
        length.add(a);
        String begin = String.valueOf(spelerX) + "," + String.valueOf(spelerY) + "/";
        paden.add(begin);
        actief.add(true);
        String answer = checkNodes();
        return showPad(answer);
    }

    private ArrayList<Voorwerpen> showPad(String answer) {
        ArrayList<Voorwerpen> snel = new ArrayList<>();
        for (int i = 0; i < Doolhof.length; i++) {
            for (int j = 0; j < Doolhof.length; j++) {
                snel.add(m);
            }

        }
        int positie;
        int[] nummers = new int[2];
        String numbers[] = answer.split("/");
        for (String part : numbers) {
            nummers[0] = Integer.parseInt(part.split(",")[0]);
            nummers[1] = Integer.parseInt(part.split(",")[1]);
            positie = nummers[0] * Doolhof.length + nummers[1];
            Pad p = new Pad();
            snel.set(positie, p);
        }
        return snel;
    }

    public void setGegevens(int sX, int sY, int uX, int uY, Voorwerpen[][] d) {
        spelerX = sX;
        spelerY = sY;
        uitgangX = uX;
        uitgangY = uY;
        Doolhof = d;
    }

    private int selectNode() {
        //selecteert de coordinaten van het kortste bekende pad
        int min = 9999;
        int minIndex = 0;
        for (int i = 0; i < length.size(); i++) {
            int j = length.get(i);
            if (j < min && actief.get(i)) {
                min = j;
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    private String checkNodes() {
        int x;
        int y;
        boolean first;
        while (checkEinde() == false) {
            first = true;
            int node = selectNode();
            String pad = paden.get(node);
            ArrayList<int[]> coordinaten;
            coordinaten = getLaatsteCoords(node);
            int aantal = coordinaten.size();
            final int X = coordinaten.get(aantal - 1)[1];
            final int Y = coordinaten.get(aantal - 1)[0];
            for (int i = 0; i < 4; i++) {
                
            }
            y = Y;
            x = X;
            //kijkt of de tile naar het noorden een muur is of of deze al bezocht is.
            //als dat beide niet het geval is dan voegt hij deze toe aan bezochte paden
            if (Doolhof[y - 1][x].equals(m) || bezocht(x, (y - 1))) {
            } else {
                String NieuwPad = pad + (y - 1) + "," + x + "/";
                if (first) {
                    paden.set(node, NieuwPad);
                    length.set(node, (length.get(node) + 1));
                    first = false;
                } else {
                    paden.add(NieuwPad);
                    length.add(length.get(node) + 1);
                    actief.add(true);
                }
            }
            y = Y;
            x = X;
            //kijkt of de tile naar het oosten een muur is of of deze al bezocht is.
            //als dat beide niet het geval is dan voegt hij deze toe aan bezochte paden
            if (Doolhof[y][x + 1].equals(m) || bezocht((x + 1), y)) {
            } else {
                String NieuwPad = pad + y + "," + (x + 1) + "/";
                if (first) {
                    first = false;
                    paden.set(node, NieuwPad);
                    length.set(node, (length.get(node) + 1));
                } else {
                    paden.add(NieuwPad);
                    length.add(length.get(node) + 1);
                    actief.add(true);
                }
            }
            y = Y;
            x = X;
            //kijkt of de tile naar het zuiden een muur is of of deze al bezocht is.
            //als dat beide niet het geval is dan voegt hij deze toe aan bezochte paden
            if (Doolhof[y + 1][x].equals(m) || bezocht(x, (y + 1))) {
            } else {
                String NieuwPad = pad + (y + 1) + "," + x + "/";
                if (first) {
                    first = false;
                    paden.set(node, NieuwPad);
                    length.set(node, (length.get(node) + 1));
                } else {
                    paden.add(NieuwPad);
                    length.add(length.get(node) + 1);
                    actief.add(true);
                }
            }
            y = Y;
            x = X;
            //kijkt of de tile naar het westen een muur is of of deze al bezocht is.
            //als dat beide niet het geval is dan voegt hij deze toe aan bezochte paden
            if (Doolhof[y][x - 1].equals(m) || bezocht((x - 1), y)) {
            } else {
                String NieuwPad = pad + y + "," + (x - 1) + "/";
                if (first) {
                    first = false;
                    paden.set(node, NieuwPad);
                    length.set(node, (length.get(node) + 1));
                } else {
                    paden.add(NieuwPad);
                    length.add(length.get(node) + 1);
                    actief.add(true);
                }
            }
            if (first) {
                actief.set(node, false);
            }
        }
        return (paden.get(selectNode()));
    }

    private boolean checkEinde() {
        //checkt of de solver al een weg naar de uitgang heeft gevonden
        int node = selectNode();
        ArrayList<int[]> coordinaten = new ArrayList<>();
        coordinaten = getLaatsteCoords(node);
        for (int i = 0; i < 10; i++) {
            
        }
        if(node>=coordinaten.size()){
            node = (coordinaten.size()-1);
        }
        int x = coordinaten.get(node)[0];
        int y = coordinaten.get(node)[1];
        if (uitgangX == x && uitgangY == y) {
            return true;
        }
        return false;
    }

    private ArrayList<int[]> getLaatsteCoords(int node) {
        //de paden zijn opgeslagen als strings. deze method haalt de laatste coordinaten van de geselecteerde string op
        int[] nummers = new int[2];
        ArrayList<int[]> coords = new ArrayList<>();
        String numbers[] = paden.get(node).split("/");
        for (String part : numbers) {
            nummers[0] = Integer.parseInt(part.split(",")[0]);
            nummers[1] = Integer.parseInt(part.split(",")[1]);
            coords.add(nummers);
        }
        return coords;
    }

    private boolean bezocht(int x, int y) {
        //checkt of een x,y coordinaat al een keer bezocht is
        final boolean NODE_IS_AL_BEZOCHT = true;
        final boolean NODE_IS_NOG_NIET_BEZOCHT = false;
        int lengte = bezocht.size();
        int[] lengtes = new int[2];
        for (int i = 0; i < lengte; i++) {
            if (bezocht.get(i)[0] == x && bezocht.get(i)[1] == y) {
                return NODE_IS_AL_BEZOCHT;
            }
        }
        lengtes[0] = x;
        lengtes[1] = y;
        bezocht.add(lengtes);
        return NODE_IS_NOG_NIET_BEZOCHT;
    }
}
