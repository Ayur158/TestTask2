package test.task2.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Model {
    private final Connection connection;

    public Model () throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "12q123wa");
    }

    public void getCommand() throws IOException, SQLException {
        System.out.println("0 - show database");
        System.out.println("1 - add new student");
        System.out.println("2 - delete student by ID");
        System.out.println("3 - Exit");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        if (command.length() == 1 && (command.charAt(0) <= 51 || command.charAt(0) >=48) ) {
        int commandParse;
        commandParse = Integer.parseInt(command);
        switch (commandParse) {
            case (0):
                show();
                getCommand();
            case(1):
                add();
                getCommand();
            case (2):
                delete();
                getCommand();
            default: System.exit(0);
        }
        } else getCommand();
    }

    public void delete() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id of student you want to delete, or Q to return");
        try {
            String temp = reader.readLine();
            if (temp.length() == 1 && temp.charAt(0) == 81) getCommand();
            int id = Integer.parseInt(reader.readLine());
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from students where id=" + id);
            System.out.println("Student was deleted!"); }
        catch (Exception e) {
            System.out.println("No student with this id");
            getCommand();
        }
    }

    public void add() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter values splited by \":\"  Format: FirstName:LastName:MiddleName:yyyy-dd-mm:Group" );
        String value = reader.readLine();
        String[] arr = value.split(":");
        if (arr.length!=5) {
            System.out.println(("Not enough values, type 0 to return in menu or type 1 to repeat command"));
            Integer answer = -1;
            while (answer == -1) {
                answer = Integer.parseInt(reader.readLine());
            }
        }
        try {
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into students (firstName, lastName, middleName, dateOfBirth, studyGroup) " +
                "values ('" + arr[0] + "', '" + arr[1] + "', '" + arr[2] + "', '" + arr[3] + "', '" + arr[4] +"');");
        System.out.println("Student was added!"); } catch (Exception e) {
            System.out.println("Invalid input format");
            getCommand();
        }
    }

    public void show () throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students");
        while (resultSet.next()) {
            Student newStudent = new Student(Integer.parseInt(resultSet.getString(1)),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(6),
                    resultSet.getString(5));
            System.out.println(newStudent.toString());
        }
    }
}
