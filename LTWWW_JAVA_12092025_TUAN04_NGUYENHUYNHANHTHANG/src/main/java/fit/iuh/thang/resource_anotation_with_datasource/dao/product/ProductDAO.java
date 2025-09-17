package fit.iuh.thang.resource_anotation_with_datasource.dao.product;

import fit.iuh.thang.resource_anotation_with_datasource.model.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> findAll();
}
