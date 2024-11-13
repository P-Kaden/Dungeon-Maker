package dev.dungeonmaker;

public class MazeCell {

    int top;
    int bottom;
    int left;
    int right;

    boolean visited;
    int x;
    int y;

    public MazeCell(int x, int y){
        this.x = x;
        this.y = y;
    }

}
