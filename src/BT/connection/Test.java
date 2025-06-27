/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT.connection;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author LinhHa
 */
public class Test {
    public static void main(String[] args) {
      

    UserController uc = new UserController();
    List<User> list = uc.getAll();
     
    }
}

    


