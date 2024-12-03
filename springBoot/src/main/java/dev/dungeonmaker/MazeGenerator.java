package dev.dungeonmaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MazeGenerator {

    private int i = 0;
    private int width;
    private int height;
    private MazeCell[][] cells;
    private Random random = new Random();

    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new MazeCell[height][width];
    }

    public MazeCell[][] generateMaze() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new MazeCell(x, y);
            }
        }

        setMaze(cells);
        System.out.println("Print Maze");
        printMaze(cells);
        System.out.println("Generate Maze");
        generateMaze(0, 0);
        System.out.println();
        return cells;
    }

    private void generateMaze(int x, int y) {
        MazeCell current = cells[y][x];
        current.visited = true;

        List<MazeCell> neighbors = getUnvisitedNeighbors(current);
        Collections.shuffle(neighbors);

        if (allCellsVisited()) {
            i++;
            System.out.println();
            System.out.println("Generation " + i);
            endMaze();
            printMaze(cells);
        }else {
            for (MazeCell neighbor : neighbors) {
                if (!neighbor.visited) {
                    removeWall(current, neighbor);
                    generateMaze(neighbor.x, neighbor.y);
                }
            }
        }
    }

    public boolean allCellsVisited() {
        for (MazeCell[] cell : cells) {
            for (MazeCell mazeCell : cell) {
                if (!mazeCell.visited) {
                    return false;  // If any cell is unvisited, return false
                }
            }
        }
        return true;  // All cells visited
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
        if (current.x == 0 && current.y == 0) {
            current.top = false;
        }
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

    protected void endMaze() {
        int y = height-1;
        boolean findExit = true;
        for(int x = width-1; x != 0; x--) {
            MazeCell current = cells[y][x];
            if (!current.left && current.top && current.bottom && current.right) {
                current.bottom = false;
                findExit = false;
                break;
            }else if (!current.top && current.bottom && current.left && current.right) {
                current.bottom = false;
                findExit = false;
                break;
            }else if (!current.right && current.top && current.left && current.bottom) {
                current.bottom = false;
                findExit = false;
                break;
            }
        }
        if (findExit) {
            int x = width - 1;
            for(y = height-1; y != 0; y--) {
                MazeCell current = cells[y][x];
                if (!current.left && current.top && current.bottom && current.right) {
                    current.right = false;
                    break;
                }else if (!current.top && current.bottom && current.left && current.right) {
                    current.right = false;
                    break;
                }else if (!current.bottom && current.top && current.left && current.right) {
                    current.right = false;
                    break;
                }
            }
        }
    }

    public void printMaze(MazeCell[][] cells) {
        for (int y = 0; y < height; y++) {
            for (int i = 0; i < 3; i++) {
                for (int x = 0; x < width; x++) {
                    if (i == 0) {
                        cells[y][x].printTop();
                    }
                    if (i == 1) {
                        cells[y][x].printBody();
                    }
                    if (i == 2) {
                        cells[y][x].printBottom();
                    }
                }
                    System.out.println();
            }
        }
    }

    public void setMaze(MazeCell[][] cells) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x].setMe(y);

            }
        }
    }
}
