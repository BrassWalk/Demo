package demo.controller;

import demo.domain.service.ILobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class ScheduleController {

    private final SimpMessagingTemplate template;
    private final ILobbyService lobbyService;

    @Autowired
    public ScheduleController(
            final SimpMessagingTemplate template,
            final ILobbyService lobbyService) {
        this.template = template;
        this.lobbyService = lobbyService;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println("sending update");
        this.template.convertAndSend("/topic/lobby-updates", this.lobbyService.getAll());
    }
}
