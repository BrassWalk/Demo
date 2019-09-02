package demo.controller;

import demo.beans.GameState;
import demo.beans.Move;
import demo.temp.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class GameController {
    private GameService gameService;

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/create/{uuid}")
    @SendTo("/topic/board/{uuid}")
    public GameState createGame(@DestinationVariable String uuid) {
        System.out.println("CREATE");
        GameState gameState = gameService.createGame(UUID.fromString(uuid));

        this.template.convertAndSend("/topic/move/" + uuid, gameState);

        return gameState;
    }

    @MessageMapping("/move/{uuid}")
    @SendTo("/topic/move/{uuid}")
    public GameState makeMove(@DestinationVariable String uuid, Move move) {
        System.out.println("MOVE");
        GameState gameState = gameService.move(UUID.fromString(uuid), move);

        this.template.convertAndSend("/topic/move/" + uuid, gameState);

        return gameState;
    }
}