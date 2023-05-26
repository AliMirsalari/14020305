package org.example.repository;

import org.example.config.MyConnection;
import org.example.entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public void saveUser(Users users) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "insert into users( user_name, user_password, singup_date) values (?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, users.getUserName());
        preparedStatement.setString(2, users.getPassword());
        preparedStatement.setDate(3, new Date(users.getSinginDate().getTime()));
        preparedStatement.executeUpdate();
        connection.close();
    }

    public Users loadUser(int id) throws SQLException {
        String userName = "";
        String userPassword = "";
        Date singInDate = null;
        int userId = 0;
        Connection connection = MyConnection.getConnection();
        String sql = "SELECT * FROM  users where user_id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            userId = resultSet.getInt("user_id");
            userName = resultSet.getString("user_name");
            userPassword = resultSet.getString("user_name");
            singInDate = resultSet.getDate("singup_date");
        }
        Users users = new Users(userId, userName, userPassword, singInDate);

        resultSet.close();
        preparedStatement.close();
        return users;
    }

    public void updateUser(String password, String username, int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "UPDATE users set user_password = ?, user_name = ? where user_id = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, username);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void useDelete(int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String query = "DELETE FROM users WHERE user_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }



    public List<Users> loadAll () throws SQLException {

        String userName = "";
        String userPassword = "";
        Date singInDate = null;
        int userId = 0;

        Connection connection = MyConnection.getConnection();
        List<Users> usersList = new ArrayList<>();
        String sql = "SELECT * FROM  users ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            userId = resultSet.getInt("user_id");
            userName = resultSet.getString("user_name");
            userPassword = resultSet.getString("user_name");
            singInDate = resultSet.getDate("singup_date");
            Users users = new Users(userId, userName, userPassword, singInDate);

            usersList.add(users);
        }

        resultSet.close();
        preparedStatement.close();
        return usersList;

    }


    public void saveAll(Users[] users) throws SQLException {
        Connection connection = MyConnection.getConnection();
        for (Users user : users) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users( user_name, user_password, singup_date) values (?,?,?) ");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setDate(3, new Date(user.getSinginDate().getTime()));
            preparedStatement.executeUpdate();
        }
        connection.close();


    }





}
