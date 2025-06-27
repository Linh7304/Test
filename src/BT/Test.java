/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author LinhHa
 */
public class Test  extends JFrame {
    public Test(){ 
      setTitle("Quan ly sinh vien");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ====== Tiêu đề ======
        JLabel titleLabel = new JLabel("THONG TIN SINH VIEN", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.RED);
        add(titleLabel, BorderLayout.NORTH);
        setVisible(true);
}
    public static void main(String[] args) {
         new Test();
    }
      
}