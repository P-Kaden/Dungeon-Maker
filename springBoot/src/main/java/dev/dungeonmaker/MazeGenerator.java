package dev.dungeonmaker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MazeGenerator {

            private int width;
            private int height;
            private MazeCell[][] cells;
            private Random random = new Random();

            public MazeGenerator(int width, int height) {
                this.width = width;
                this.height = height;
                cells = new MazeCell[height][width];
                generateMaze();
            }

            public MazeCell[][] generateMaze() {
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        cells[y][x] = new MazeCell(x, y);
                    }
                }

                generateMaze(0, 0);
                return cells;
            }

            private void generateMaze(int x, int y) {
                MazeCell current = cells[y][x];
                current.visited = true;

                List<MazeCell> neighbors = getUnvisitedNeighbors(current);
                Collections.shuffle(neighbors);

                for (MazeCell neighbor : neighbors) {
                    if (!neighbor.visited) {
                        removeWall(current, neighbor);
                        generateMaze(neighbor.x, neighbor.y);
                    }
                }
                printMaze(cells);
            }

            private List<MazeCell> getUnvisitedNeighbors(MazeCell cell) {
                List<MazeCell> neighbors = new ArrayList<>();
                if (cell.x > 0) {
                    neighbors.add(cells[cell.y][cell.x - 1]);
                }
                if (cell.x < width - 1) {
                    neighbors.add(cells[cell.y][cell.x + 1]);
                }
                if (cell.y > 0) {
                    neighbors.add(cells[cell.y - 1][cell.x]);
                }
                if (cell.y < height - 1) {
                    neighbors.add(cells[cell.y + 1][cell.x]);
                }
                return neighbors;
            }

            protected void removeWall(MazeCell current, MazeCell neighbor) {
                if (current.x == neighbor.x) {
                    if (current.y < neighbor.y) {
                        current.bottom = false;
                        neighbor.top = false;
                    } else {
                        current.top = false;
                        neighbor.bottom = false;
                    }
                } else {
                    if (current.x < neighbor.x) {
                        current.right = false;
                        neighbor.left = false;
                    } else {
                        current.left = false;
                        neighbor.right = false;
                    }
                }

            }

            public void printMaze(MazeCell[][] cells) {
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        cells[y][x].printMe() ;
                    }
                    System.out.println();
                }
            }

}
