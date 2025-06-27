package BT_SQL;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Bai9 extends JFrame {

    private JList<String> list;
    private JTable table;
    private DefaultListModel<String> model;
    private DefaultTableModel tablemodel;
    private JComboBox<String> combobox;
    private JTextField txtID, txtName, txtPrice, txtQuan;
    private JTextArea txtDes;
private void updateComboBoxFromList() {
    combobox.removeAllItems();
    for (int i = 0; i < model.size(); i++) {
        combobox.addItem(model.get(i));
    }
}
    public Bai9() {

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Write Data to disk");
        JMenuItem loadItem = new JMenuItem("Open Data from disk");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        setTitle("Quản lý sản phẩm!");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Quản lý sản phẩm", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.BLUE);
        root.add(titleLabel, BorderLayout.NORTH);
        TitledBorder bo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED),"Danh mục sản phẩm");                                           
        model = new DefaultListModel<>();
        list = new JList<>(model);
        JScrollPane pane = new JScrollPane(list);

        JPanel button = new JPanel();
        JButton them = new JButton("New");
        JButton sua = new JButton("Update");
        JButton xoa = new JButton("Remove");
        button.add(them);
        button.add(sua);
        button.add(xoa);

        JPanel left = new JPanel(new BorderLayout());
        left.add(pane, BorderLayout.CENTER);
        left.add(button, BorderLayout.SOUTH);

        tablemodel = new DefaultTableModel(new String[]{"Product ID", "Product Name", "UnitPrice", "Quantity", "Description"}, 0);
        table = new JTable(tablemodel);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setPreferredSize(new Dimension(400, 150));

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        combobox = new JComboBox<>();
        txtID = new JTextField();
        txtName = new JTextField();
        txtPrice = new JTextField();
        txtQuan = new JTextField();
        txtDes = new JTextArea(3, 20);

        formPanel.add(new JLabel("Category:"));
        formPanel.add(combobox);
        formPanel.add(new JLabel("Product ID:"));
        formPanel.add(txtID);
        formPanel.add(new JLabel("Product Name:"));
        formPanel.add(txtName);
        formPanel.add(new JLabel("Unit Price:"));
        formPanel.add(txtPrice);
        formPanel.add(new JLabel("Quantity:"));
        formPanel.add(txtQuan);
        formPanel.add(new JLabel("Description:"));
        formPanel.add(new JScrollPane(txtDes));

        JButton btnNew = new JButton("New");
        JButton btnSave = new JButton("Save");
        JButton btnRemove = new JButton("Remove");

        JPanel productButtonPanel = new JPanel();
        productButtonPanel.add(btnNew);
        productButtonPanel.add(btnSave);
        productButtonPanel.add(btnRemove);

        JPanel right = new JPanel(new BorderLayout());
        right.add(tableScroll, BorderLayout.NORTH);
        right.add(formPanel, BorderLayout.CENTER);
        right.add(productButtonPanel, BorderLayout.SOUTH);

        // Layout
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
        root.add(splitPane, BorderLayout.CENTER);
        setContentPane(root);

        // Exit handler
        //  exitItem.addActionListener(e -> System.exit(0));
        btnSave.addActionListener(e -> {
          String id = txtID.getText().trim();
    String name = txtName.getText().trim();
    String priceStr = txtPrice.getText().trim();
    String quanStr = txtQuan.getText().trim();
    String des = txtDes.getText().trim();

    try {
        double price = Double.parseDouble(priceStr);
        int quantity = Integer.parseInt(quanStr);

        Product p = new Product(id, name, price, quantity, des);
        ProductDAO dao = new ProductDAO();
        dao.insertProduct(p); // Lưu vào CSDL

        // Cập nhật bảng
        tablemodel.addRow(new Object[]{id, name, price, quantity, des});
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng giá và số lượng!");
    }
        });

        btnNew.addActionListener(e -> {
            txtID.setText("");
            txtName.setText("");
            txtPrice.setText("");
            txtQuan.setText("");
            txtDes.setText("");
        });
        btnRemove.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                tablemodel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to remove.");
            }
        });
   them.addActionListener(e -> {
             String newItem = JOptionPane.showInputDialog(list, "Nhập tên danh mục mới:");
    if (newItem != null && !newItem.trim().isEmpty()) {
        model.addElement(newItem.trim());
        updateComboBoxFromList();  // Cập nhật ComboBox
    }
            
        });
   sua.addActionListener(e -> {        
   int index = list.getSelectedIndex();
    if (index != -1) {
        String currentItem = model.getElementAt(index);
        String updatedItem = JOptionPane.showInputDialog(list, "Sửa danh mục:", currentItem);
        if (updatedItem != null && !updatedItem.trim().isEmpty()) {
            model.set(index, updatedItem.trim());
            updateComboBoxFromList();  // Cập nhật ComboBox
        }
    } else {
        JOptionPane.showMessageDialog(list, "Hãy chọn mục cần sửa!");
    }
              });
 xoa.addActionListener(e -> {
    int index = list.getSelectedIndex();
    if (index != -1) {
        int confirm = JOptionPane.showConfirmDialog(list, "Bạn có chắc muốn xóa mục này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            model.remove(index);
            updateComboBoxFromList();  // Cập nhật ComboBox
        }
    } else {
        JOptionPane.showMessageDialog(list, "Hãy chọn mục cần xóa!");
    }
});

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bai9().setVisible(true);
        });
    }
}
