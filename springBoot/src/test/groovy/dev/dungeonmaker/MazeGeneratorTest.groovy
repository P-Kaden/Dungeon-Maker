package dev.dungeonmaker

import org.junit.jupiter.api.Test

class MazeGeneratorTest {

    @Test
    void testSuperSmallMaze() {
        MazeGenerator twoByTwoGenerator = new MazeGenerator(2, 2)
        MazeCell[][] twoByTwo = twoByTwoGenerator.generateMaze()
        assert (twoByTwo.length == 2)
        assert (twoByTwo[0].length == 2)
    }

    @Test
    void testOtherMazes() {
        MazeGenerator mazeEasy = new MazeGenerator(10, 10)
        MazeCell[][] smallMaze = mazeEasy.generateMaze()
        assert (smallMaze.length == 10)
        assert (smallMaze[0].length == 10)
        assert(mazeEasy.generateMaze().length == 10)
        mazeEasy.printMaze(smallMaze)
    }

    @Test
    void testMediumMaze() {
        MazeGenerator mazeMedium = new MazeGenerator(25, 25)
    }

    @Test
    void testLargeMaze() {
        MazeGenerator mazeLarge = new MazeGenerator(50, 50)
    }

    @Test
    void testXtrLargeMaze() {
        MazeGenerator mazeXtrLarge = new MazeGenerator(100, 100)
    }

}
