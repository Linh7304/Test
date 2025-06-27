/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vidu;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
/**
 *
 * @author LinhHa
 */
public class FlowLayoutEx extends JFrame {

    public FlowLayoutEx() {
        JPanel pnFlow = new JPanel();
        pnFlow.setLayout(new FlowLayout());
        pnFlow.setBackground(Color.PINK);
        JButton btn1 = new JButton("FlowLayout");
        JButton btn2 = new JButton("Add các control");
        JButton btn3 = new JButton("Trên 1 dòng");
        JButton btn4 = new JButton("Hết chỗ chứa");
        JButton btn5 = new JButton("Thì xuống dòng");
        pnFlow.add(btn1);
        pnFlow.add(btn2);
        pnFlow.add(btn3);
        pnFlow.add(btn4);
        pnFlow.add(btn5);
        Container con = getContentPane();
        con.add(pnFlow);
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
     public static void main(String[] args) {
  
        FlowLayoutEx flowLayoutEx = new FlowLayoutEx ();
    }
}
