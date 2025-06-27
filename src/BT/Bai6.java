/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author LinhHa
 */
public class Bai6 extends JFrame{
    
 
    private JList<String> listLeft, listRight;
    private DefaultListModel<String> modelLeft, modelRight;
    private JButton btnCopy;

    public Bai6() {
        setTitle("Multiple Selection Lists");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        modelLeft = new DefaultListModel<>();
        modelRight = new DefaultListModel<>();
        listLeft = new JList<>(modelLeft);
        listRight = new JList<>(modelRight);

        listLeft.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listRight.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollLeft = new JScrollPane(listLeft);
        JScrollPane scrollRight = new JScrollPane(listRight);
        scrollLeft.setPreferredSize(new Dimension(100, 100));
        scrollRight.setPreferredSize(new Dimension(100, 100));

        btnCopy = new JButton("Copy >>>>");
        btnCopy.addActionListener(e -> {
            for (String selected : listLeft.getSelectedValuesList()) {
                if (!modelRight.contains(selected)) {
                    modelRight.addElement(selected);
                }
            }
        });

        add(scrollLeft);
        add(btnCopy);
        add(scrollRight);

        loadFromFile("input.txt");

        // Ghi file khi đóng
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                saveToFile("output.txt");
            }
        });
    }

    private void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                modelLeft.addElement(line.trim());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Không đọc được file input.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < modelRight.size(); i++) {
                bw.write(modelRight.getElementAt(i));
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Không ghi được file output.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai6().setVisible(true));
    }
}

        
     
  