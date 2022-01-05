package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public void createUsersTable() throws SQLException {
        Connection connection = Util.getConnect();
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS user.USER " +
                "                   (id INT not NULL AUTO_INCREMENT UNIQUE PRIMARY KEY," +
                "                   name VARCHAR(255)," +
                "                   lastname VARCHAR(255)," +
                "                   age tinyint)");
        System.out.println("");
        connection.close();

    }

    public void dropUsersTable() throws SQLException {


        Connection connection = Util.getConnect();
        Statement statement = connection.createStatement();

        statement.executeUpdate("DROP TABLE IF EXISTS user.USER ");
        System.out.println("");
        connection.close();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        Connection connection = Util.getConnect();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO user.USER VALUES (id , '"+ name +"', '" + lastName +"', '" + age +"')";
        statement.executeUpdate(sql);
        System.out.println("Пользователь сохранен");
        connection.close();
    }

    public void removeUserById(long id) throws SQLException {
        Connection connection = Util.getConnect();
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM user.USER WHERE id = " + id + ";");
        System.out.println("Пользователь удален");
        connection.close();
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = Util.getConnect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from USER;");
        List<User> users = new LinkedList<>();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            System.out.println(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            System.out.println(resultSet.getString("name"));
            user.setLastName(resultSet.getString("lastname"));
            user.setAge(resultSet.getByte("age"));
            users.add(user);
            System.out.println(user);
            System.out.println(users);
        }
        connection.close();
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        Connection connection = Util.getConnect();
        Statement statement = connection.createStatement();
        statement.executeUpdate("TRUNCATE TABLE USER");
        connection.close();
    }
}
