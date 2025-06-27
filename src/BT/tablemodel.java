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
import java.util.Vector;
import java.util.Random;
public class tablemodel extends JFrame {
public class person{
    public int id;
    public String name;
    public int age;
    public person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
  public String getName() {
      return name;
  }

}
  
    public  tablemodel() {
         setTitle("demo defaulttablemodel");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // căn giữa
        // setLayout(new BorderLayout());
        setLayout(new FlowLayout());

        Vector <person> data = new Vector <person>();
        Vector <String> colname = new Vector <String>();
        colname.add("id");
        colname.add("name");
        colname.add("age");
        int i, n=50;
        for (i=0; i<n; i++){
            String str = "nguyen zzz" + i;
            person p = new person(i, str, 19 + (i%3));
            data.add(p);
        }
        Vector<Vector<Object>> vt = new Vector<>();
        for(person item : data){
            Vector<Object> tmp = new Vector<>();
            tmp.add(item.getId());
            tmp.add(item.getName());
            tmp.add(item.getAge());
            vt.add(tmp);
        }
        DefaultTableModel tbl = new DefaultTableModel(vt, colname);
        JTable table = new JTable(tbl);
        JScrollPane scrollpanel = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollpanel);
        add(panel);
        setVisible(true);
}
public static void main(String[] args) {
    new tablemodel();
}
    
}

