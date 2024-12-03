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
    void testEasyMaze() {
        MazeGenerator mazeEasy = new MazeGenerator(10, 10)
        MazeCell[][] smallMaze = mazeEasy.generateMaze()
        assert (smallMaze.length == 10)
        assert (smallMaze[0].length == 10)
    }

    @Test
    void testMediumMaze() {
        MazeGenerator mazeMedium = new MazeGenerator(25, 25)
        MazeCell[][] medMaze = mazeMedium.generateMaze()
        assert (medMaze.length == 25)
        assert (medMaze[0].length == 25)
    }

    @Test
    void testLargeMaze() {
        MazeGenerator mazeLarge = new MazeGenerator(50, 50)
        MazeCell[][] largeMaze = mazeLarge.generateMaze()
        assert (largeMaze.length == 50)
        assert (largeMaze[0].length == 50)
    }

    @Test
    void testHugeMaze() {
        MazeGenerator mazeHuge = new MazeGenerator(100, 100)
        MazeCell[][] hugeMaze = mazeHuge.generateMaze()
        assert (hugeMaze.length == 100)
        assert (hugeMaze[0].length == 100)
    }

}
