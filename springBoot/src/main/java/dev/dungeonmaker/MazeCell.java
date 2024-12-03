package dev.dungeonmaker;

public class MazeCell {

    boolean top;
    boolean bottom;
    boolean left;
    boolean right;

    boolean visited;
    int x;
    int y;
    private int width;
    private int height;

    public MazeCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setMe(int y) {
        top = true;
        left = true;
        right = true;
        bottom = true;
    }

    public void printTop() {
        if (top) {
            System.out.print("⬛⬛⬛");
        } else {
            System.out.print("⬛⬜⬛");
        }
    }
    public void printBody() {
        if (left && right) {
            System.out.print("⬛⬜⬛");
        } else if (left) {
            System.out.print("⬛⬜⬜");
        } else if (right) {
            System.out.print("⬜⬜⬛");
        } else {
            System.out.print("⬜⬜⬜");
        }
    }
    public void printBottom() {
        if (bottom) {
            System.out.print("⬛⬛⬛");
        } else {
            System.out.print("⬛⬜⬛");
        }
    }
}
