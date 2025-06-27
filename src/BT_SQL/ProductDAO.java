package BT_SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private MyConnection myConn = new MyConnection();

    // Thêm sản phẩm mới
    public boolean insertProduct(Product product) {
        String sql = "INSERT INTO products (id, name, price, quantity, description) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = myConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setString(5, product.getDescription());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
            return false;
        }
    }

    // Lấy danh sách tất cả sản phẩm
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = myConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("description")
                );
                list.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Load failed: " + e.getMessage());
        }

        return list;
    }

    // Xóa sản phẩm theo ID
    public boolean deleteProduct(String id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = myConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
            return false;
        }
    }

    // Cập nhật sản phẩm
    public boolean updateProduct(Product product) {
        String sql = "UPDATE products SET name=?, price=?, quantity=?, description=? WHERE id=?";

        try (Connection conn = myConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setString(4, product.getDescription());
            stmt.setString(5, product.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    // Tìm sản phẩm theo ID (bổ sung thêm cho hoàn chỉnh)
    public Product findProductById(String id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = myConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("description")
                );
            }

        } catch (SQLException e) {
            System.err.println("Find by ID failed: " + e.getMessage());
        }

        return null;
    }
}
