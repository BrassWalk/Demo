package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class ScheduleController {

    private final SimpMessagingTemplate template;

    @Autowired
    public ScheduleController(
            final SimpMessagingTemplate template) {
        this.template = template;
    }

//    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
//    public void scheduleFixedDelayTask() {
//        System.out.println("sending update");
//        this.template.convertAndSend("/topic/lobby-updates", this.lobbyService.getAll());
//    }
}
