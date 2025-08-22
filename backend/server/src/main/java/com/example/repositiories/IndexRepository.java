package com.example.repositiories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.models.Priem;

@Repository
public class IndexRepository {

    private static int id = 0;
    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String USER = "test";
    private static final String PASSWORD = "test";


    public List<Priem> getTable() {

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM priems");
            List<Priem> priems = new ArrayList<>();

            while (resultSet.next()) {
                Priem priem = new Priem();
                priem.setId(resultSet.getInt("id"));
                priem.setName(resultSet.getString("name"));
                priem.setCategory(resultSet.getString("category"));
                priem.setResume(resultSet.getString("resume"));
                priem.setExecution(resultSet.getString("execution"));
                priem.setUrl_on_img(resultSet.getString("url_on_img"));
                priem.setUrl_on_video(resultSet.getString("url_on_video"));

                priems.add(priem);
            }

            resultSet.close();
            statement.close();
            connection.close();

            return priems;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void postTable(Priem priem) {

        id++;

        try {     
            //Вставка данных
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String insertSQL = "INSERT INTO priems (id, name, category, resume, execution, url_on_img, url_on_video) VALUES (" 
            + Integer.toString(id)
            + ",'" + priem.getName() + "',"
            + "'" + priem.getCategory() + "',"
            + "'" + priem.getResume() + "',"
            + "'" + priem.getExecution() + "',"
            + "'" + priem.getUrl_on_img() + "',"
            + "'" + priem.getUrl_on_video() + "'"
            + ")";

            statement.executeUpdate(insertSQL);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void deleteTable(int id) {
        try {     
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String insertSQL = "DELETE FROM priems WHERE id = " + Integer.toString(id);
            statement.executeUpdate(insertSQL);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void putTable(int id, Priem priem) {
        try {     
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String insertSQL = "UPDATE priems SET " + 
            "id = " + Integer.toString(id) + ", " +
            "name = " + "'" + priem.getName() + "', " +
            "name = " + "'" + priem.getCategory() + "', " +
            "resume = " + "'" + priem.getResume() + "', " +
            "name = " + "'" + priem.getExecution() + "', " +
            "url_on_img = " + "'" + priem.getUrl_on_img() + "', " +
            "url_on_video = " + "'" + priem.getUrl_on_video() + "' " +
            "WHERE id = " + Integer.toString(id);
            statement.executeUpdate(insertSQL);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
