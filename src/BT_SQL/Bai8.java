package BT_SQL;

import javax.swing.*;
import java.awt.*;

public class Bai8 extends JFrame {

    private JList<User> studentList;
    private DefaultListModel<User> listModel;
    private JTextField txtID, txtName, txtAge;
    private UserDAO userDAO = new UserDAO(); 

    public Bai8() {
        setTitle("Quan ly sinh vien");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("THÔNG TIN SINH VIÊN", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.RED);
        add(titleLabel, BorderLayout.NORTH);

        
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        listModel = new DefaultListModel<>();
        studentList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(studentList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách sinh viên"));

        mainPanel.add(scrollPane);

       
        JPanel infoPanel = new JPanel(new GridLayout(3, 2, 5, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));

        txtID = new JTextField();
        txtName = new JTextField();
        txtAge = new JTextField();

        infoPanel.add(new JLabel("Mã sinh viên:"));
        infoPanel.add(txtID);
        infoPanel.add(new JLabel("Họ và tên:"));
        infoPanel.add(txtName);
        infoPanel.add(new JLabel("Tuổi:"));
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

        
       btnAdd.addActionListener(e -> {
    String msv = txtID.getText().trim();
    String name = txtName.getText().trim();
    String ageStr = txtAge.getText().trim();

    if (!msv.isEmpty() && !name.isEmpty() && !ageStr.isEmpty()) {
        try {
            int age = Integer.parseInt(ageStr);
            User user = new User(msv, name, age);

            if (userDAO.addUser(user)) {
                listModel.addElement(user);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Không thể thêm vào cơ sở dữ liệu!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số nguyên!");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
    }
});


       btnRemove.addActionListener(e -> {
    int index = studentList.getSelectedIndex();
    if (index != -1) {
        User selectedUser = listModel.getElementAt(index);
        if (userDAO.deleteUser(selectedUser.getMsv())) {
            listModel.remove(index);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa không thành công trong cơ sở dữ liệu!");
        }
    }
});

btnUpdate.addActionListener(e -> {
    int index = studentList.getSelectedIndex();
    if (index != -1) {
        String msv = txtID.getText().trim();
        String name = txtName.getText().trim();
        String ageText = txtAge.getText().trim();

        if (!msv.isEmpty() && !name.isEmpty() && !ageText.isEmpty()) {
            try {
                int age = Integer.parseInt(ageText);
                User updatedUser = new User(msv, name, age);

                if (userDAO.updateUser(updatedUser)) {
                    listModel.set(index, updatedUser);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật không thành công trong cơ sở dữ liệu!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Tuổi phải là số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }
});

        btnClear.addActionListener(e -> {
    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa tất cả sinh viên?", "Xác nhận", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        if (userDAO.deleteAllUsers()) {
            listModel.clear();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Không thể xóa dữ liệu trong cơ sở dữ liệu!");
        }
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
