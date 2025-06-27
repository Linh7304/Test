/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT;

/**
 *
 * @author LinhHa
 */
  import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.xml.sax.SAXException;

import java.awt.*;
public class jlist extends JFrame{
    public class sinhvien{
        public int id;
        public String name;
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public sinhvien(int a, String b){
            this.id = a;
            this.name = b;
        }
        public String tostring(){
            return id + " - " + name;
        }
    }
    public jlist(){
        setTitle("Multiple Selection Lists");
    
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // căn giữa
        setLayout(new BorderLayout());
        DefaultListModel <sinhvien> lst1 = new DefaultListModel<>();
        int i=0;
        int n = 50;
        for (i = 1; i<=50;i++){
            String str = "kkkkk";
            sinhvien s = new sinhvien(i, str);
            lst1.addElement(s);
        }
        JList jlst = new JList<>(lst1);
           DefaultTableModel tbl = new DefaultTableModel();

        // DefaultListModel <String> lst1 = new DefaultListModel<>();
        // int i=0;
        // int n = 50;
        // for (i = 1; i<=50;i++){
        //     String str = "kkkkk";
        //     sinhvien s = new sinhvien(i, str);
            
        //     lst1.addElement(s.tostring());
        // }
        // JList jlst = new JList<>(lst1);
        jlst.setVisibleRowCount(2);
        
        add(jlst, BorderLayout.CENTER);
        setVisible(true);
    }
    public static void main(String[] args) {
        new jlist();
    }
}


