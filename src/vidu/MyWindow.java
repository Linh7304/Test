/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vidu;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;

/**
 *
 * @author LinhHa
 */
public class MyWindow extends JFrame {

    public MyWindow() {
        super("Demo Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MyWindow ui = new MyWindow(); // Tạo đối tượng cửa sổ
        ui.setSize(400, 300); // Đặt kích thước cửa sổ (rộng 400, cao 300)
        ui.setLocationRelativeTo(null); // Đặt vị trí cửa sổ giữa màn hình
        ui.setVisible(true); // Hiển thị cửa sổ
    }

}
