package dev.dungeonmaker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class DungeonMakerController {
    @PostMapping("/submit")
    public String handleFormSubmission(@RequestParam("mazesize") String mazeSize) {
        MazeGenerator mazeGen = null;
        if (Objects.equals(mazeSize, "small")) {
            mazeGen = new MazeGenerator(10,10);
        }else if (Objects.equals(mazeSize, "med")) {
            mazeGen = new MazeGenerator(25, 25);
        }else if (Objects.equals(mazeSize, "large")) {
            mazeGen = new MazeGenerator(50, 50);
        }else if (Objects.equals(mazeSize, "huge")) {
            mazeGen = new MazeGenerator(100, 100);
        }
        MazeCell[][] cells = mazeGen.generateMaze();
        return mazeGen.toString(cells);

    }
}
