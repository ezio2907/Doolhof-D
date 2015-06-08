/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Arrays;

/**
 *
 * @author bram
 */
public class mazeSolver {

    final static int TRIED = 2;
    final static int PATH = 3;
    private Voorwerpen[][] grid;
    private int height;
    private int width;
    private int[][] map;

    public mazeSolver(Voorwerpen[][] grid) {
        this.grid = grid;
        this.height = grid.length;
        this.width = grid[0].length;
        this.map = new int[height][width];
    }

    public boolean solve() {
        return traverse(1, 1);
    }

    private boolean traverse(int i, int j) {
        if (!isValid(i, j)) {
            return false;
        }

        if (isEnd(i, j)) {
            map[i][j] = PATH;
            return true;
        } else {
            map[i][j] = TRIED;
        }

        // North
        if (traverse(i - 1, j)) {
            map[i - 1][j] = PATH;
            return true;
        }
        // East
        if (traverse(i, j + 1)) {
            map[i][j + 1] = PATH;
            return true;
        }
        // South
        if (traverse(i + 1, j)) {
            map[i + 1][j] = PATH;
            return true;
        }
        // West
        if (traverse(i, j - 1)) {
            map[i][j - 1] = PATH;
            return true;
        }

        return false;
    }

    private boolean isEnd(int i, int j) {
        return i == 12 - 1 && j == 13 - 1;
    }

    private boolean isValid(int i, int j) {
        if (inRange(i, j) && isOpen(i, j) && !isTried(i, j)) {
            return true;
        }

        return false;
    }

    private boolean isOpen(int i, int j) {
        Pad p = new Pad();
        Uitgang u = new Uitgang();
        if (grid[i][j].equals(u) || grid[i][j].equals(p)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isTried(int i, int j) {
        return map[i][j] == TRIED;
    }

    private boolean inRange(int i, int j) {
        return inHeight(i) && inWidth(j);
    }

    private boolean inHeight(int i) {
        return i >= 0 && i < height;
    }

    private boolean inWidth(int j) {
        return j >= 0 && j < width;
    }

    public String toString() {
        String s = "";
        for (int[] row : map) {
            s += Arrays.toString(row) + "\n";
        }

        return s;
    }
}
