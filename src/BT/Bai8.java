/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT;

/**
 *import javax.swing.*;
 * @author LinhHa
 */

    import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Bai8 extends JFrame {

    private JList<String> studentList;
    private DefaultListModel<String> listModel;
    private JTextField txtID, txtName, txtAge;

    public Bai8() {
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

        // ====== Center Panel (Main Layout) ======
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // Left Panel - Danh sách sinh viên
        listModel = new DefaultListModel<>();
      
        studentList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(studentList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sach sinh vien..."));

        mainPanel.add(scrollPane);

        // Right Panel - Form nhập thông tin
        JPanel infoPanel = new JPanel(new GridLayout(3, 2, 5, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));

        txtID = new JTextField();
        txtName = new JTextField();
        txtAge = new JTextField();

        infoPanel.add(new JLabel("Ma sinh vien:"));
        infoPanel.add(txtID);
        infoPanel.add(new JLabel("Ho va ten:"));
        infoPanel.add(txtName);
        infoPanel.add(new JLabel("Tuoi:"));
        infoPanel.add(txtAge);

        mainPanel.add(infoPanel);

        add(mainPanel, BorderLayout.CENTER);

        // ====== Nút chức năng ======
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnAdd = new JButton("Add");
        JButton btnRemove = new JButton("Remove");
        JButton btnUpdate = new JButton("Update");
        JButton btnClear = new JButton("Clear");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRemove);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnClear);

        add(buttonPanel, BorderLayout.SOUTH);

        // ====== Sự kiện nút ======
        btnAdd.addActionListener(e -> {
            String name = txtName.getText().trim();
            if (!name.isEmpty()) {
                listModel.addElement(name);
                clearFields();
            }
        });

        btnRemove.addActionListener(e -> {
            int index = studentList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
                clearFields();
            }
        });

        btnUpdate.addActionListener(e -> {
            int index = studentList.getSelectedIndex();
            if (index != -1) {
                String name = txtName.getText().trim();
                if (!name.isEmpty()) {
                    listModel.set(index, name);
                }
            }
        });

        btnClear.addActionListener(e -> clearFields());

        studentList.addListSelectionListener(e -> {
            int index = studentList.getSelectedIndex();
            if (index != -1) {
                txtName.setText(listModel.getElementAt(index));
                // Dữ liệu mẫu
                txtID.setText("0732263");
                txtAge.setText("20");
            }
        });

        setVisible(true);
    }

    private void clearFields() {
        txtID.setText("");
        txtName.setText("");
        txtAge.setText("");
        studentList.clearSelection();
    }

    public static void main(String[] args) {
        new Bai8();
    }
}


