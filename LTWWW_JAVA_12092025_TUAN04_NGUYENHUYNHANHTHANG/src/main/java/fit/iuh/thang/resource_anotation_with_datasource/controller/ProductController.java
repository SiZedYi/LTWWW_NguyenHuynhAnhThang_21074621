package fit.iuh.thang.resource_anotation_with_datasource.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import javax.sql.DataSource;
import jakarta.annotation.Resource;

@WebServlet(name = "productController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/myDatasource")
    private DataSource dataSource;
}
