package BT;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Bai5 extends JFrame {
    private JLabel label;
    private JList<String> dayList;

    public Bai5() {
        setTitle("Bai5");
        setSize(250, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Tạo JLabel với định dạng
        label = new JLabel("Sunday", SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        label.setForeground(Color.BLACK);
        label.setBorder(new LineBorder(Color.BLACK));
        label.setFont(new Font("Arial", Font.BOLD, 16));
        add(label, BorderLayout.NORTH);

        // Dữ liệu danh sách
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        dayList = new JList<>(days);
        dayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        dayList.setSelectedIndex(0); 
        add(new JScrollPane(dayList), BorderLayout.CENTER);

       
        dayList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                label.setText(dayList.getSelectedValue());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bai5().setVisible(true);
        });
    }
}
