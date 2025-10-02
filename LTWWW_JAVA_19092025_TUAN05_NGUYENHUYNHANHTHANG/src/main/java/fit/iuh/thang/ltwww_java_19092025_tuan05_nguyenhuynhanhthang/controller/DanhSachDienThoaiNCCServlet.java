package fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.controller;

import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao.DienthoaiDAO;
import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao.DienthoaiDAOImpl;
import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.DienThoai;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import javax.sql.DataSource;
import java.util.List;

@WebServlet(name="DanhSachDienThoaiNCCServlet", value = "/home")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/quanlydienthoai")
    private DataSource dataSource;

    private DienthoaiDAO dienthoaiDAO;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        this.dienthoaiDAO = new DienthoaiDAOImpl(this.dataSource);
    }

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, java.io.IOException {
        String tenNCC = request.getParameter("tenNCC");
        List<DienThoai> listDt;
        if (tenNCC != null && !tenNCC.trim().isEmpty()) {
            listDt = dienthoaiDAO.searchDienThoaiByTenNCC(tenNCC.trim());
        } else {
            listDt = dienthoaiDAO.getAllDienThoaiWithNCC();
        }
        request.setAttribute("dienthoaiList", listDt);
        request.setAttribute("tenNCC", tenNCC);
        request.getRequestDispatcher("/views/DanhSachDienThoaiNCC.jsp").forward(request, response);
    }
}
