/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vidu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author LinhHa
 */
public class vidu3 extends JFrame{
 public vidu3(){
        setTitle("Ví dụ BoxLayout");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Căn giữa màn hình

        // Tạo panel và đặt layout là BoxLayout theo chiều ngang
        JPanel pnBox = new JPanel();
        pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));

        // Tạo font dùng chung cho các nút
        Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 25);

        // Nút 1
        JButton btn1 = new JButton("BoxLayout");
        btn1.setForeground(Color.RED);
        btn1.setFont(font);
        pnBox.add(btn1);

        // Nút 2
        JButton btn2 = new JButton("X_AXIS");
        btn2.setForeground(Color.BLUE);
        btn2.setFont(font);
        pnBox.add(btn2);

        // Nút 3
        JButton btn3 = new JButton("Y_AXIS");
        btn3.setForeground(Color.ORANGE);
        btn3.setFont(font);
        pnBox.add(btn3);

        // Thêm panel vào JFrame
        Container con = getContentPane();
        con.add(pnBox);

        setVisible(true);
    }

    public static void main(String[] args) {
        new vidu3();
    }

}
