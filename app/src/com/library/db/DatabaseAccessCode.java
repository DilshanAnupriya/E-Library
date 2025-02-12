package com.library.db;

import com.library.entity.SystemUser;
import com.library.util.PasswordGenerator;

import java.sql.*;

public class DatabaseAccessCode {

    public static  boolean createUser(SystemUser user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/e_library",
                "root",
                "12345678"
        );
        String sql = "INSERT INTO system_user VALUES(?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,user.getUserId());
        stm.setString(2,user.getFullName());
        stm.setString(3,user.getEmail());
        stm.setString(4,user.getContact());
        stm.setString(5,user.getPassword());
        return stm.executeUpdate()>0;
    }

    public static  boolean loginUser(String email, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/e_library",
                "root",
                "12345678"
        );
        String sql = "SELECT * FROM system_user WHERE email=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,email);
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            return PasswordGenerator.check(password, rs.getString(5));
        }
        return false;
    }
}
