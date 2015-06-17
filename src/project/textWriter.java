/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class textWriter {

    JLabel eerste = new JLabel();
    JLabel tweede = new JLabel();
    JLabel derde = new JLabel();
    JTextField name = new JTextField(8);
    JLabel label = new JLabel("voer naam in:");
    JButton voegToe = new JButton("highscore");
    GridBagLayout grid = new GridBagLayout();
    JPanel panel = new JPanel(grid);
    int score;
    int level;

    public textWriter(int LVL, int Score) {
        score = Score;
        level = LVL;
        int laagsteScore = getScores();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        JFrame frame = new JFrame("highscore");
        JLabel score = new JLabel("jouw score: " + Score);

        JLabel een = new JLabel("1:");
        JLabel twee = new JLabel("2:");
        JLabel drie = new JLabel("3:");
        JLabel leeg = new JLabel(" ");
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 10;
        gc.gridy = 1;


        panel.add(eerste, gc);
        gc.gridx = 4;
        panel.add(een, gc);
        gc.gridx = 10;
        gc.gridy = 2;
        panel.add(tweede, gc);
        gc.gridx = 4;
        panel.add(twee, gc);
        gc.gridx = 10;
        gc.gridy = 3;
        panel.add(derde, gc);
        gc.gridx = 4;
        panel.add(drie, gc);
        gc.gridx = 10;
        gc.gridy = 4;
        panel.add(leeg, gc);
        gc.gridy = 5;
        panel.add(label, gc);
        gc.gridy = 6;
        panel.add(name, gc);
        gc.gridy = 7;
        panel.add(voegToe, gc);
        gc.gridy = 9;
        panel.add(score, gc);
        if (Score < laagsteScore) {
            voegToe.setVisible(false);
        }
        frame.add(panel);
        frame.setSize(150, 200);
        frame.setLocation((width / 2 - 75), (height / 2 - 90));
        frame.setVisible(true);
        ActionListener highscore = new highscore();
        voegToe.addActionListener(highscore);
    }

    public int getScores() {
        int laagsteScore = -10;
        try {
            File file = new File("highscores/highscoresDoolhof" + level + ".txt");
            if (!file.exists()) {
                file.createNewFile();
                String content = "Speler:NaN";
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.newLine();
                bw.write(content);
                bw.newLine();
                bw.write(content);
                bw.close();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i = 0;
            String[] scores = new String[3];
            while ((line = bufferedReader.readLine()) != null) {
                scores[i] = line;
                i++;
            }
            eerste.setText(scores[0]);
            tweede.setText(scores[1]);
            derde.setText(scores[2]);
            try {
                laagsteScore = Integer.parseInt(scores[2].split(":")[1]);
            } catch (Exception e) {
                laagsteScore = -10;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return laagsteScore;
    }

    public void schrijven() {
        try {

            String naam = name.getText();

            String content = naam + ":" + score;

            File file = new File("highscores/highscoresDoolhof" + level + ".txt");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i = 0;
            String[] scores = new String[3];
            while ((line = bufferedReader.readLine()) != null) {
                scores[i] = line;
                i++;
            }
            fileReader.close();

            int plaats = 4;

            for (int j = 3; j > 0; j--) {
                int a = -10000;
                try {
                    a = Integer.parseInt(scores[j - 1].split(":")[1]);
                } catch (Exception e) {
                }
                if (a < score) {
                    plaats = j;
                }
            }


            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            if (plaats == 1) {
                eerste.setText(content);
                tweede.setText(scores[0]);
                derde.setText(scores[1]);
                content = naam + ":" + score;
                bw.write(content);
                content = scores[0];
                bw.newLine();
                bw.write(content);
                content = scores[1];
                bw.newLine();
                bw.write(content);
            } else if (plaats == 2) {
                tweede.setText(content);
                derde.setText(scores[1]);
                content = scores[0];
                bw.write(content);
                bw.newLine();
                content = naam + ":" + score;
                bw.write(content);
                bw.newLine();
                content = scores[1];
                bw.write(content);
            } else if (plaats == 3) {
                derde.setText(content);
                content = scores[0];
                bw.write(content);
                bw.newLine();
                content = scores[1];
                bw.write(content);
                bw.newLine();
                content = naam + ":" + score;
                bw.write(content);
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        voegToe.setEnabled(false);
    }

    class highscore implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            schrijven();
        }
    }
}
