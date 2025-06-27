/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT.connection;

/**
 *
 * @author LinhHa
 */
public class User {
    private int id ; 
    private String email , phone , name; 

    public User() {
    }

    public User(int id, String name , String email , String phone) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", phone=" + phone + ", name=" + name + '}';
    }
    
}
