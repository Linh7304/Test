package BT_SQL;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserDAO {

    private Connection conn;

    public UserDAO() {
        MyConnection myConn = new MyConnection();
        conn = myConn.getConnection();
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String msv = rs.getString("msv");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                User user = new User(msv, name, age);
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void loadSinhVienToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (User sv : getAllUsers()) {
            model.addRow(new Object[]{sv.getMsv(), sv.getName(), sv.getAge()});
        }
    }

    public boolean addUser(User sinhvien) {
        String sql = "INSERT INTO sinhvien (msv, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sinhvien.getMsv());
            ps.setString(2, sinhvien.getName());
            ps.setInt(3, sinhvien.getAge());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE sinhvien SET name=?, age=? WHERE msv=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getMsv());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(String msv) {
        String sql = "DELETE FROM sinhvien WHERE msv=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, msv);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAllUsers() {
        String sql = "DELETE FROM sinhvien";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
