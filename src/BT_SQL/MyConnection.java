/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author LinhHa
 */
public class MyConnection {

    private String host;
    private String user;
    private String pass;
    private String url;
    Connection conn;

    public MyConnection() {
        host = "localhost";
        user = "root";
        pass = "";
        url = "jdbc:mysql://localhost:3306/BT";
    }

    public MyConnection(String host, String user, String pass, String url) {
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.url = url;

    }

    public Connection getConnection() {
        try {
            if (conn != null) {
                return conn;
            }
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
    
    





