package org.esports;

import org.esports.Model.Player;
import org.esports.Service.PlayerService;
import org.esports.View.ConsoleUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsoleUI consoleUI = (ConsoleUI) context.getBean("consoleUI");
        consoleUI.showMenu();
    }
}