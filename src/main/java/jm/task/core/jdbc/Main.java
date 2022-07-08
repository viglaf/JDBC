package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Util.getSessionFactory();
        Util.getConnection();
        UserService user = new UserServiceImpl();

        user.createUsersTable();

        user.saveUser("Иван", "Петров", (byte) 20);
        user.saveUser("Степан", "Стариков", (byte) 25);
        user.saveUser("Илья", "Прутков", (byte) 31);
        user.saveUser("Геннадий", "Житный", (byte) 38);

        user.removeUserById(1);
        user.getAllUsers();
        user.cleanUsersTable();
        user.dropUsersTable();

        Util.closeConnect(Util.getConnection());
    }
}
