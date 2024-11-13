package dev.dungeonmaker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DungeonMakerController {
    @PostMapping("/submit")
    public String handleFormSubmission(@RequestParam("mazedifficulty") Integer mazeDifficulty,
                                       @RequestParam("mazesize") Integer mazeSize
                                       ) {
        return "success"; // Assuming you have a success page named "success.html"
    }
}
