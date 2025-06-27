/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Bai7 extends JFrame {
    private JTextField txtInput;
    private JCheckBox chkAllowNegative;
    private DefaultListModel<Integer> listModel;
    private JList<Integer> numberList;

    public Bai7() {
        setTitle("Thao tác trên JList");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        // Panel chính chia làm 3 phần
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Thao tác trên JList - Checkbox", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitle, BorderLayout.NORTH);

        // Panel bên trái - các nút chức năng
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(6, 1, 5, 5));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));

        JButton btnEven = new JButton("Tô đen số chẵn");
        JButton btnOdd = new JButton("Tô đen số lẻ");
        JButton btnPrimes = new JButton("Tô đen số nguyên tố");
        JButton btnClearSelection = new JButton("Bỏ tô đen");
        JButton btnRemoveSelected = new JButton("Xóa các giá trị đang tô đen");
        JButton btnSum = new JButton("Tổng giá trị trong JList");

        leftPanel.add(btnEven);
        leftPanel.add(btnOdd);
        leftPanel.add(btnPrimes);
        leftPanel.add(btnClearSelection);
        leftPanel.add(btnRemoveSelected);
        leftPanel.add(btnSum);

        add(leftPanel, BorderLayout.WEST);

        // Panel trung tâm chứa nhập liệu và danh sách
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Nhập thông tin:"));

        JPanel inputPanel = new JPanel();
        txtInput = new JTextField(10);
        JButton btnAdd = new JButton("Nhập");
        chkAllowNegative = new JCheckBox("Cho nhập số âm");
        inputPanel.add(btnAdd);
        inputPanel.add(txtInput);
        inputPanel.add(chkAllowNegative);

        listModel = new DefaultListModel<>();
        numberList = new JList<>(listModel);
        numberList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(numberList);

        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Nút đóng chương trình
        JButton btnClose = new JButton("Đóng chương trình");
        add(btnClose, BorderLayout.SOUTH);

        // Xử lý sự kiện
        btnAdd.addActionListener(e -> addNumber());
        btnEven.addActionListener(e -> selectEven());
        btnOdd.addActionListener(e -> selectOdd());
        btnPrimes.addActionListener(e -> selectPrimes());
        btnClearSelection.addActionListener(e -> numberList.clearSelection());
        btnRemoveSelected.addActionListener(e -> removeSelected());
        btnSum.addActionListener(e -> showSum());
        btnClose.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    private void addNumber() {
        try {
            int num = Integer.parseInt(txtInput.getText().trim());
            if (!chkAllowNegative.isSelected() && num < 0) {
                JOptionPane.showMessageDialog(this, "Không được nhập số âm!");
                return;
            }
            listModel.addElement(num);
            txtInput.setText("");
            txtInput.requestFocus();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ!");
        }
    }

    private void selectEven() {
        numberList.clearSelection();
        Vector<Integer> data = new Vector<>();
        for (int i = 0; i < listModel.size(); i++) {
            if (listModel.get(i) % 2 == 0) {
                numberList.addSelectionInterval(i, i);
            }
        }
    }

    private void selectOdd() {
        numberList.clearSelection();
        for (int i = 0; i < listModel.size(); i++) {
            if (listModel.get(i) % 2 != 0) {
                numberList.addSelectionInterval(i, i);
            }
        }
    }

    private void selectPrimes() {
        numberList.clearSelection();
        for (int i = 0; i < listModel.size(); i++) {
            if (isPrime(listModel.get(i))) {
                numberList.addSelectionInterval(i, i);
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private void removeSelected() {
        var selected = numberList.getSelectedValuesList();
        for (int val : selected) {
            listModel.removeElement(val);
        }
    }

    private void showSum() {
        int sum = 0;
        for (int i = 0; i < listModel.size(); i++) {
            sum += listModel.get(i);
        }
        JOptionPane.showMessageDialog(this, "Tổng giá trị trong JList là: " + sum);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai7().setVisible(true));
    }
}
