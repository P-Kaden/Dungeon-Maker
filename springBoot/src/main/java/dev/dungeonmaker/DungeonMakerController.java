package dev.dungeonmaker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DungeonMakerController {
    @PostMapping("/submit")
    public String handleFormSubmission(@RequestParam("mazesize") String mazeSize) {
        return switch (mazeSize) {
            case "small" -> "<html><body><h1>Hello from Spring Boot!</h1></body></html>";
            case "med" -> "redirect:/you";
            case "large" -> "redirect:/win";
            case "huge" -> "redirect:/kys";
            default -> "success";
        };
    }
}
