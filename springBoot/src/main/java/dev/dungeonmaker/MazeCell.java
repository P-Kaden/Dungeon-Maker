package dev.dungeonmaker;

public class MazeCell {

    boolean top;
    boolean bottom;
    boolean left;
    boolean right;

    boolean visited;
    int x;
    int y;

    public MazeCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void printMe() {
        if (top) {
            System.out.print(" _ ");
        } else {
            System.out.print("    ");
        }
        if (bottom && left && right) {
            System.out.print("|_|");
        } else if (bottom && left) {
            System.out.print("|_ ");
        } else if (bottom && right) {
            System.out.print(" _|");
        } else if (bottom) {
            System.out.print(" _ ");
        } else if (left) {
            System.out.print("|  ");
        } else if (right) {
            System.out.print("  |");
        }

    }
}
