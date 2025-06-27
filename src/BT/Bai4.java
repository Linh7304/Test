/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author LinhHa
 */
public class Bai4 extends JFrame {

    JTextField txtName, txtResult;
    JRadioButton radMr, radMiss;
    JButton btnWelcome, btnClear, btnCancel;

    public Bai4() {
        setTitle("Welcome to!");
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));
        setLocationRelativeTo(null);

        // Hàng 1: Họ tên
        JPanel row1 = new JPanel(new FlowLayout());
        row1.add(new JLabel("Full name:"));
        txtName = new JTextField(15);
        row1.add(txtName);
        add(row1);

        // Hàng 2: Giới tính
        JPanel row2 = new JPanel(new FlowLayout());
        row2.add(new JLabel("Gender:"));
        radMr = new JRadioButton("Mr.");
        radMiss = new JRadioButton("Miss");
        ButtonGroup group = new ButtonGroup();
        group.add(radMr);
        group.add(radMiss);
        row2.add(radMr);
        row2.add(radMiss);
        add(row2);

        // Hàng 3: Kết quả
        JPanel row3 = new JPanel(new FlowLayout());
        row3.add(new JLabel("Result:"));
        txtResult = new JTextField(20);
        txtResult.setEditable(false);
        row3.add(txtResult);
        add(row3);

        // Hàng 4: Nút
        JPanel row4 = new JPanel(new FlowLayout());
        btnWelcome = new JButton("Welcome");
        btnClear = new JButton("Clear");
        btnCancel = new JButton("Cancel");
        row4.add(btnWelcome);
        row4.add(btnClear);
        row4.add(btnCancel);
        add(row4);

        // Xử lý sự kiện
        btnWelcome.addActionListener(e -> {
            String name = txtName.getText().trim();
            if (name.isEmpty()) {
                txtResult.setText("Please enter your name!");
                return;
            }
            String prefix = radMr.isSelected() ? "Mr. " : radMiss.isSelected() ? "Miss " : "";
            txtResult.setText("Welcome " + prefix + name);
        });

        btnClear.addActionListener(e -> {
            txtName.setText("");
            txtResult.setText("");
            group.clearSelection();
            txtName.requestFocus();
        });

        btnCancel.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Bai4();
    }
}
