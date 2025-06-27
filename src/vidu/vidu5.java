/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vidu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author LinhHa
 */
public class vidu5 extends JFrame {

    public void doshow() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        vidu5();
        setVisible(true);
    }

    public void vidu5() {
        JPanel pn = new JPanel();
        pn.setLayout(new BorderLayout());
        JPanel north = new JPanel();
        JLabel title = new JLabel("Giải phương trình bậc 2");
        north.add(title);
        pn.add(north, BorderLayout.NORTH);
        Font ft = new Font("arial", Font.BOLD, 15);
        title.setFont(ft);
        add(pn);

        JPanel center = new JPanel();
        pn.add(center, BorderLayout.CENTER);
        Border centerborder = BorderFactory.createLineBorder(Color.RED);
        TitledBorder centerTitleBorder = new TitledBorder(centerborder, "nhập 2 số a và b:");
        center.setBorder(centerTitleBorder);

        JPanel a = new JPanel();
        JLabel na = new JLabel("Nhập a: ");
        JTextField txa = new JTextField(15);
        a.add(na);
        a.add(txa);
        center.add(a);

        JPanel b = new JPanel();
        JLabel nb = new JLabel("Nhập b:");
        JTextField txb = new JTextField(15);
        b.add(nb);
        b.add(txb);
        center.add(b);

        JPanel c = new JPanel();
        JLabel nc = new JLabel("Nhập c:");
        JTextField txc = new JTextField(15);
        c.add(nc);
        c.add(txc);
        center.add(c);

        JPanel kq = new JPanel();
        JLabel nkq = new JLabel("Kết quả:\n");
        JTextField txkq = new JTextField(15);
        kq.add(nkq);
        kq.add(txkq);
        txkq.setEditable(false);
        center.add(kq);

        JPanel south = new JPanel();
        pn.add(south, BorderLayout.SOUTH);
        Border bn = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder tb = new TitledBorder(bn, "Thao tác:");
        south.setBorder(tb);
        JButton nut1, nut2, nut3;
        south.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        nut1 = new JButton("Giải:");
        nut2 = new JButton("Xoá trắng:");
        nut3 = new JButton("Thoát:");
        south.add(nut1);
        south.add(nut2);
        south.add(nut3);
        nut3.addActionListener((ActionEvent arg0) -> {
            int ret = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thoát?", "Thoát", JOptionPane.YES_NO_OPTION);
            if (ret == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        nut2.addActionListener((ActionEvent arg0) -> {
            txa.setText("");
            txb.setText("");
            txc.setText("");
            txa.requestFocus();
        });
        nut1.addActionListener((ActionEvent arg0) -> {
            String sa = txa.getText();
            int x, y, z;
            double ketqua = 0;

            try {
                x = Integer.parseInt(sa);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Nhập sai định dạng!");
                txa.selectAll();
                txa.requestFocus();
                return;
            }
            String sb = txb.getText();
            try {
                y = Integer.parseInt(sb);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Nhập sai định dạng!");
                txb.selectAll();
                txb.requestFocus();
                return;
            }
            String sc = txc.getText();
            try {
                z = Integer.parseInt(sc);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Nhập sai định dạng!");
                txc.selectAll();
                txc.requestFocus();
                return;
            }

            if (x == 0) {
                if (y == 0) {
                    if (z == 0) {
                        txkq.setText("Vô số nghiệm");
                    } else {
                        txkq.setText("Vô nghiệm");
                    }
                } else {
                    double nghiem = -(double) z / y;
                    txkq.setText("" + nghiem);
                }
            } else {
                double delta = y * y - 4 * x * z;
                if (delta < 0) {
                    txkq.setText("Phương trình vô nghiệm");
                } else if (delta == 0) {
                    double nghiemKep = -(double) y / (2 * x);
                    txkq.setText("" + nghiemKep);
                } else {
                    double x1 = (-y + Math.sqrt(delta)) / (2 * x);
                    double x2 = (-y - Math.sqrt(delta)) / (2 * x);
                    txkq.setText("" + x1 + "," + x2);
                }
            }

        });
    }

    public static void main(String[] args) {
        vidu5 ui = new vidu5();
        ui.doshow();
    }
}
