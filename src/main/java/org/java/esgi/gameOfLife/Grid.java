package org.java.esgi.gameOfLife;

import java.util.Arrays;

public class Grid {
    public Integer[][] grid;
    public final Integer MINSIZE = 1;
    public final Integer MAXSIZE = 500;

    public Integer height;
    public Integer width;

    public Integer[][] getGrid() {
        return grid;
    }

    public Integer getMINSIZE() {
        return MINSIZE;
    }

    public Integer getMAXSIZE() {
        return MAXSIZE;
    }

    public Grid(Integer x, Integer y) {
        if(x >= MINSIZE && x <= MAXSIZE && y >= MINSIZE && y <= MAXSIZE) {
            height = y;
            width = x;
            grid = new Integer[x][y];
            for (int i = 0; i < x; i++) {
                Arrays.fill(grid[i], 0);
            }
        }

    }

    public void reAwake(Integer x, Integer y) {
        grid[x][y] = 1;
        System.out.println(this);
    }

    public boolean isAlive(Integer x, Integer y) {
        return grid[x][y] == 1;
    }

    public Integer nbNeightboorsAlive(Integer x, Integer y){
        Integer nbNeighbours = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j<= 1; j++){
                if(x + i < 0 || y + j < 0 || x + i >= width || y + j >= height){
                    continue;
                }
                if(x+i == x && y+j == y)
                    continue;
                if(grid[x + i][y + j] == 1){
                    nbNeighbours++;
                }
            }
        }
        return nbNeighbours;
    }

    public void nextStep() {
        Integer[][] newGrid = new Integer[width][height];
        for(int i = 0; i < width ; i++){
            for(int j=0; j< height; j++){
                newGrid[i][j] = grid[i][j];
                if(nbNeightboorsAlive(i,j) == 3 && grid[i][j] == 0){
                    newGrid[i][j] = 1;
                }
                if(nbNeightboorsAlive(i,j) < 2 || nbNeightboorsAlive(i,j) > 3 && grid[i][j] == 1){
                    newGrid[i][j] = 0;
                }
            }
        }
        grid = newGrid;
        System.out.println(this);
    }

    public void resize(Integer x1, Integer y1) {
        if(x1 >= MINSIZE && x1 <= MAXSIZE && y1 >= MINSIZE && y1 <= MAXSIZE) {
            height = y1;
            width = x1;
            Integer[][] newGrid = new Integer[x1][y1];
            for(int i = 0; i< width; i++){
                for(int j = 0; j< height;j++){
                    newGrid[i][j] = grid[i][j];
                }
            }
            grid = newGrid;
        }
        System.out.println(this);
    }

    public String toString() {
        StringBuilder game = new StringBuilder();
        for(int i = 0; i< width; i++){
            for(int j = 0; j< height;j++){
                game.append(grid[i][j]);
                game.append(" ");
            }
            game.append("\n");
        }
        game.append("\n");
        return String.valueOf(game);
    }

    public void kill(Integer x1, Integer y1) {
        grid[x1][y1] = 0;
        System.out.println(this);
    }
}
