/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vidu;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author LinhHa
 */


public class vidu4 extends JFrame {

    public vidu4() {
        setTitle("Ví dụ BorderLayout");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo JPanel chính và set layout là BorderLayout
        JPanel pnBorder = new JPanel();
        pnBorder.setLayout(new BorderLayout());

        // NORTH panel (màu đỏ)
        JPanel pnNorth = new JPanel();
        pnNorth.setBackground(Color.RED);
        pnBorder.add(pnNorth, BorderLayout.NORTH);

        // SOUTH panel (màu đỏ)
        JPanel pnSouth = new JPanel();
        pnSouth.setBackground(Color.RED);
        pnBorder.add(pnSouth, BorderLayout.SOUTH);

        // WEST panel (màu xanh dương)
        JPanel pnWest = new JPanel();
        pnWest.setBackground(Color.BLUE);
        pnBorder.add(pnWest, BorderLayout.WEST);

        // EAST panel (màu xanh dương)
        JPanel pnEast = new JPanel();
        pnEast.setBackground(Color.BLUE);
        pnBorder.add(pnEast, BorderLayout.EAST);

        // CENTER panel (màu vàng)
        JPanel pnCenter = new JPanel();
        pnCenter.setBackground(Color.YELLOW);
        pnBorder.add(pnCenter, BorderLayout.CENTER);

        // Thêm layout chính vào cửa sổ
        getContentPane().add(pnBorder);

        setVisible(true);
    }

    public static void main(String[] args) {
        new vidu4();
    }
}


