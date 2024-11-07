package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Nikita", "First", (byte) 25);
        userService.saveUser("Mikhail", "Second", (byte) 30);
        userService.saveUser("Alice", "Third", (byte) 22);
        userService.saveUser("Chloe", "Fourth", (byte) 28);

        List<User> users = userService.getAllUsers();
        System.out.println("List of users:");
        for (User user : users) {
            System.out.println(user);
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
