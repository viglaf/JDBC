package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection = Util.getConnection();
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try ( Statement statement = connection.createStatement())
        {
            statement.execute("CREATE TABLE if not exists users (\n" +
                    "                       id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "                       name VARCHAR(100),\n" +
                    "                       lastname VARCHAR(100),\n" +
                    "                       age SMALLINT (3));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement())
        {
            statement.execute("DROP TABLE if exists users;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)")
            )
        {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем - " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try (
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "DELETE FROM users WHERE id =?")
        )
        {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (ResultSet resultSet = connection.createStatement()
                        .executeQuery("SELECT * FROM users;");
            )
        {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                userList.add(user);
            }
                for (User user: userList) {
                    System.out.println(user);
                }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public void cleanUsersTable() {
            try (Statement conn = connection.createStatement())
            {
                        conn.execute("DELETE FROM users;");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
