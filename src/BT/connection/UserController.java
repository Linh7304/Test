/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LinhHa
 */
public class UserController {

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();

        try {
            if (conn != null) {
                Statement stmt = conn.createStatement() ; 
                ResultSet rs = stmt.executeQuery("select *from tbl_user");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    System.out.println(id + "-"+  name +"-"+  email + "-" + phone  );
                }
            } else {
                System.out.println("Kết nối thành công"); // This seems incorrect
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
