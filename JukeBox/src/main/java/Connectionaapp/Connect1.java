package Connectionaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect1 {
    static Connection con;

    public static Connection establishconnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/JB", "root", "root");
        return con;
    }
}

