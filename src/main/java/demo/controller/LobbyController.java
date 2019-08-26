package demo.controller;

import demo.domain.service.ILobbyService;
import demo.valueobject.Lobby;
import demo.valueobject.record.UserLobbyRecord;
import demo.valueobject.id.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LobbyController {

    private final ILobbyService lobbyService;

    @Autowired
    public LobbyController(final ILobbyService lobbyService) {
        this.lobbyService = lobbyService;
    }

    @GetMapping("api/lobby/update-and-read")
    public Lobby getLobby(final HttpServletRequest httpServletRequest) {
        final UserId userId = new UserId(httpServletRequest.getRemoteAddr());
        final LocalDateTime localDateTime = LocalDateTime.now();

        return this.lobbyService.put(userId, new UserLobbyRecord(userId, localDateTime));
    }

    @MessageMapping("message/lobby/update")
    @SendTo("/topic/lobby-updates")
    public Lobby getLobbySocket(final HttpServletRequest httpServletRequest) {
        final UserId userId = new UserId(httpServletRequest.getRemoteAddr());
        final LocalDateTime localDateTime = LocalDateTime.now();

        return this.lobbyService.put(userId, new UserLobbyRecord(userId, localDateTime));
    }
}