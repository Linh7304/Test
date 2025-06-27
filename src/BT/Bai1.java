/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author LinhHa
 */
public class Bai1 {
    public static void main(String[] args) {
        try {
            
            String input1 = JOptionPane.showInputDialog("Nhập số thứ nhất:");
            int so1 = Integer.parseInt(input1);

            String input2 = JOptionPane.showInputDialog("Nhập số thứ hai:");
            int so2 = Integer.parseInt(input2);

            if (so2 < so1) {
                JOptionPane.showMessageDialog(null, "Lỗi: Số thứ hai phải lớn hơn hoặc bằng số thứ nhất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                Random rand = new Random();
                int soNgauNhien = rand.nextInt(so2 - so1 + 1) + so1;  // sinh số trong khoảng [so1, so2]
                JOptionPane.showMessageDialog(null, "Số ngẫu nhiên: " + soNgauNhien, "Phát sinh số ngẫu nhiên", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên hợp lệ.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        }
    }
}
