package fit.iuh.thang.resource_anotation_with_datasource.dao.product;

import fit.iuh.thang.resource_anotation_with_datasource.model.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private final DataSource dataSource;
    public ProductDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<Product> findAll() {
        String sql = "SELECT id, name, price, image FROM products";
        List<Product> products = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                products.add(new Product(id, name, price, image));
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
