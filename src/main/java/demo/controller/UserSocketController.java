package demo.controller;

import demo.service.IUserService;
import demo.valueobject.entity.UserModel;
import demo.valueobject.id.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Random;
import java.util.UUID;

@Controller
public class UserSocketController {

    private SimpMessagingTemplate messageTemplate;
    private IUserService userService;

    @Autowired
    public void setGameService(
            final SimpMessagingTemplate messageTemplate,
            final IUserService userService) {
        this.messageTemplate = messageTemplate;
        this.userService = userService;
    }

    @MessageMapping("/user/create/{uuid}")
    @SendTo("/topic/user/create")
    public UserModel createUser(@DestinationVariable final String uuid) {
        final UserId userId = new UserId(UUID.fromString(uuid));
        final Integer integer = new Random().nextInt();

        final UserModel userModel = userService.createUser(new UserModel(userId, integer.toString()));

        this.messageTemplate.convertAndSend("/topic/user/create", userModel);
        return userModel;
    }
}