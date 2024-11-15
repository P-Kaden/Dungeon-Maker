package dev.dungeonmaker

import org.junit.jupiter.api.Test

class MazeGeneratorTest {

    @Test
    void testInitialization() {
        MazeGenerator mazeGenerator = new MazeGenerator(20, 20)
        print mazeGenerator ;
    }

}
