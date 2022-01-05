package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;

import java.sql.*;

/*Требования к классам приложения:

        Классы dao/service должны реализовывать соответствующие интерфейсы
        Класс dao должен иметь конструктор пустой/по умолчанию
        Все поля должны быть private
 service переиспользует методы dao
         Обработка всех исключений, связанных с работой с базой данных должна находиться в dao
         Класс Util должен содержать логику настройки соединения с базой данных


         Необходимые операции:

         Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
         Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
         Очистка содержания таблицы
         Добавление User в таблицу
         Удаление User из таблицы ( по id )
         Получение всех User(ов) из таблицы*/


public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getConnect();
        Statement statement = connection.createStatement();

        ResultSet result =  statement.executeQuery("SELECT * FROM User");
        while (result.next()) {
            int empId = result.getInt(1);
            String empNo = result.getString(2);
            String empName = result.getString("Name");
            System.out.println("--------------------");
            System.out.println("EmpId:" + empId);
            System.out.println("EmpNo:" + empNo);
            System.out.println("EmpName:" + empName);
        }

        // Close connection.
        connection.close();

    }
}
