/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author LinhHa
 */
public class Bai2 extends JFrame {

    private JTextField txtF, txtC;
    private JButton btnTinh, btnTiepTuc, btnThoat;

    public Bai2() {
        setTitle("Convert from F to C!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 180);
        setLayout(new GridLayout(3, 1));
        setLocationRelativeTo(null);
        
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(new JLabel("Nhập vào độ F:"));
        txtF = new JTextField(15);
        panel1.add(txtF);
        add(panel1);

        
        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(new JLabel("Độ C tương ứng:"));
        txtC = new JTextField(15);
        txtC.setEditable(false);
        panel2.add(txtC);
        add(panel2);

        
        JPanel panel3 = new JPanel(new FlowLayout());
        btnTinh = new JButton("Tính");
        btnTiepTuc = new JButton("Tiếp tục");
        btnThoat = new JButton("Thoát");

        panel3.add(btnTinh);
        panel3.add(btnTiepTuc);
        panel3.add(btnThoat);
        add(panel3);

        
        btnTinh.addActionListener((ActionEvent e) -> {
            try {
                double f = Double.parseDouble(txtF.getText());
                double c = (f - 32) / 1.8;
                txtC.setText(String.format("%.3f", c));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ!", "Message", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Sự kiện nút "Tiếp tục"
        btnTiepTuc.addActionListener((ActionEvent e) -> {
            txtF.setText("");
            txtC.setText("");
            txtF.requestFocus();
        });

        // Sự kiện nút "Thoát"
        btnThoat.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        Bai2 bai2 = new Bai2();
    }
}
