    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author LinhHa
 */
public class Bai3 extends JFrame{
    JTextField text ; 
    JCheckBox bold, italic; 
   public Bai3(){
       setTitle("JCheckBox Test");
       setSize(400,200);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new FlowLayout());   
       setLocationRelativeTo(null);
        text = new JTextField("Watch the font style change", 20);
        text.setFont(new Font("Serif", Font.PLAIN, 14));
        add(text);
        bold = new JCheckBox("Bold");
        italic = new JCheckBox("Italic");
        add(bold);
        add(italic);

        ItemListener styleListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int style = Font.PLAIN;
                if (bold.isSelected()) style += Font.BOLD;
                if (italic.isSelected()) style += Font.ITALIC;
                text.setFont(new Font("Serif", style, 14));
            }
        };

        bold.addItemListener(styleListener);
        italic.addItemListener(styleListener);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Bai3();
    }
}

   
   
   
   
