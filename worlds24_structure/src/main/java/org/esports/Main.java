package org.esports;

import org.esports.Model.Player;
import org.esports.Service.PlayerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Player player = (Player) context.getBean("player");
        PlayerService playerService = (PlayerService) context.getBean("playerService");
        player.setAge(23);
        player.setNickname("vortexxx");
        playerService.addPlayer(player);

    }
}