package demo.controller;

import demo.beans.GameState;
import demo.beans.Move;
import demo.temp.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class GameController {
    private GameService gameService;

    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/create/{uuid}")
    @SendTo("/topic/board/{uuid}")
    public GameState createGame(@DestinationVariable String uuid) {
        GameState gameState = gameService.createGame(UUID.fromString(uuid));

        return gameState;
    }

    @MessageMapping("/move/{uuid}")
    @SendTo("/topic/move/{uuid}")
    public GameState makeMove(@DestinationVariable String uuid, Move move) {
        GameState gameState = gameService.move(UUID.fromString(uuid), move);

        return gameState;
    }
}