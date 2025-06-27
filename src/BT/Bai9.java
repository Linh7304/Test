/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LinhHa
 */
public class Bai9 extends JFrame{
    public Bai9(){
        setTitle("Quản lý sản phẩm!");
        setSize(800,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());    
        
        JLabel title = new JLabel("Quản lý sản phẩm ",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,20));
        add(main);
        title.setForeground(Color.BLUE);
        main.add(title, BorderLayout.NORTH);   
        
       JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // ==== DANH MỤC (trái) ====
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Mặt hàng điện tử");
        model.addElement("Mặt hàng hóa chất");
        model.addElement("Mặt hàng gia dụng");
        model.addElement("Hàng hàng");
        JList<String> categoryList = new JList<>(model);
        JScrollPane categoryScroll = new JScrollPane(categoryList);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Danh mục sản phẩm"));
        leftPanel.add(categoryScroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(new JButton("New"));
        buttonPanel.add(new JButton("Update"));
        buttonPanel.add(new JButton("Remove"));
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        // ==== CHI TIẾT (phải) ====
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));

        // Bảng thông tin
        String[] cols = {"Product ID", "Product Name", "UnitPrice", "Quantity", "Description"};
        String[][] data = {{"p1", "đèn huỳnh quang", "888.0", "1", "đèn huỳnh quang"}};
        JTable table = new JTable(new DefaultTableModel(data, cols));
        JScrollPane tableScroll = new JScrollPane(table);
        rightPanel.add(tableScroll, BorderLayout.NORTH);

        // Form nhập dữ liệu
        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));
        form.add(new JLabel("Category:"));
        form.add(new JComboBox<>(new String[]{"Mặt hàng điện tử", "Mặt hàng hóa chất", "Mặt hàng gia dụng"}));

        form.add(new JLabel("Product ID:"));
        form.add(new JTextField());

        form.add(new JLabel("Product Name:"));
        form.add(new JTextField());

        form.add(new JLabel("Unit Price:"));
        form.add(new JTextField());

        form.add(new JLabel("Quantity:"));
        form.add(new JTextField());

        form.add(new JLabel("Description:"));
        form.add(new JTextArea(2, 10));

        rightPanel.add(form, BorderLayout.CENTER);

        // Nút Save
        JPanel savePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        savePanel.add(new JButton("New"));
        savePanel.add(new JButton("Save"));
        savePanel.add(new JButton("Remove"));
        rightPanel.add(savePanel, BorderLayout.SOUTH);

        // Thêm 2 panel vào mainPanel
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // Thêm mainPanel vào Frame
        add(mainPanel, BorderLayout.CENTER);
    }
        
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai9().setVisible(true));
        
    }
    
    }
    

