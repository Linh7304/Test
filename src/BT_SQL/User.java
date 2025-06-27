/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT_SQL;

/**
 *
 * @author LinhHa
 */
class User {
 private String msv , name ;
 private int age ;

    public User() {
    }

    public User(String msv, String name, int age) {
        this.msv = msv;
        this.name = name;
        this.age = age;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
         return msv + " - " + name + " - " + age;
    }
      
}