package demo.controller;

import demo.domain.service.ILobbyService;
import demo.valueobject.LobbyRecord;
import demo.valueobject.WelcomeMessage;
import demo.valueobject.id.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController("api/lobby")
public class LobbyController {

    final ILobbyService lobbyService;

    @Autowired
    public LobbyController(final ILobbyService lobbyService) {
        this.lobbyService = lobbyService;
    }

    @GetMapping("/check-in")
    public List<LobbyRecord> checkIn(final HttpServletRequest httpServletRequest) {
        final UserId userId = new UserId(httpServletRequest.getRemoteAddr());
        final LocalDateTime localDateTime = LocalDateTime.now();

        return this.lobbyService.put(userId, new LobbyRecord(userId, localDateTime));
    }

    @GetMapping("/refresh")
    public List<LobbyRecord> hello() {
        return this.lobbyService.getAll();
    }
}