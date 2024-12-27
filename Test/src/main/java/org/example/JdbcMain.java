package org.example;

import java.sql.*;
import java.util.Random;

public class JdbcMain {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connect();
            createTableEx();
            insertEx();
            readEx();
            updateEx();
            System.out.println("After update:");
            readEx();
            deleteEx();
            System.out.println("After delete:");
            readEx();
            clearTableEx();
            psBatchEx();
            transactionEx();
            readEx();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void connect() throws SQLException {
        System.out.println("Открывается соединение с БД");
        String url = "jdbc:postgresql://localhost:5432/sdet_db";
        String user = "postgres";
        String password = "123";
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    private static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Соединение закрыто");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTableEx() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Employee (\n" +
                " id SERIAL PRIMARY KEY,\n" +
                " name TEXT NOT NULL,\n" +
                " department TEXT NOT NULL,\n" +
                " salary INTEGER NOT NULL\n" +
                " );");
    }

    private static void dropTableEx() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS Employee;");
    }

    private static void readEx() throws SQLException {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM Employee;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " +
                        rs.getString("department") + " " + rs.getInt("salary"));
            }
        }
    }

    private static void clearTableEx() throws SQLException {
        statement.executeUpdate("DELETE FROM Employee;");
    }

    private static void deleteEx() throws SQLException {
        statement.executeUpdate("DELETE FROM Employee WHERE name = 'Alice';");
    }

    private static void insertEx() throws SQLException {
        statement.executeUpdate("INSERT INTO Employee (name, department, salary) VALUES ('Alice', 'HR', 60000);");
        statement.executeUpdate("INSERT INTO Employee (name, department, salary) VALUES ('Bob', 'Engineering', 70000);");
        statement.executeUpdate("INSERT INTO Employee (name, department, salary) VALUES ('Charlie', 'Marketing', 55000);");
        statement.executeUpdate("INSERT INTO Employee (name, department, salary) VALUES ('David', 'Finance', 65000);");
    }

    private static void updateEx() throws SQLException {
        statement.executeUpdate("UPDATE Employee SET salary = 75000 WHERE name = 'Bob';");
    }

    private static void psBatchEx() {
        Random random = new Random();
        String[] departments = {"HR", "Engineering", "Marketing", "Finance", "IT", "Sales", "Support", "Legal", "Operations", "R&D"};

        try (PreparedStatement prepInsert =
                     connection.prepareStatement("INSERT INTO Employee(name, department, salary) VALUES(?,?,?)")) {
            for (int i = 1; i <= 10; i++) {
                prepInsert.setString(1, "Employee" + i);
                prepInsert.setString(2, departments[random.nextInt(departments.length)]);
                prepInsert.setInt(3, 30000 + random.nextInt(70001));
                prepInsert.addBatch();
            }
            int[] result = prepInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void transactionEx() throws SQLException {
        connection.setAutoCommit(false);
        try {
            statement.execute("INSERT INTO Employee (name, department, salary) values ('Catherine', 'IT', 80000)");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }
}