package fit.iuh.thang.resource_anotation_with_datasource.controller;

import fit.iuh.thang.resource_anotation_with_datasource.dao.product.ProductDAO;
import fit.iuh.thang.resource_anotation_with_datasource.dao.product.ProductDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import javax.sql.DataSource;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "productController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/myDatasource")
    private DataSource dataSource;

    private ProductDAO productDAO;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.productDAO = new ProductDAOImpl(this.dataSource);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.setAttribute("products", productDAO.findAll());
        req.getRequestDispatcher("views/product/index.jsp").forward(req, resp);
    }
}
