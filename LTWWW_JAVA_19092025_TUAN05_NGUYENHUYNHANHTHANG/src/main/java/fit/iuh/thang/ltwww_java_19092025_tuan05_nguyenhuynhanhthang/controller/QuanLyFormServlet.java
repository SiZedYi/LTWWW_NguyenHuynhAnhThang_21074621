package fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.controller;

import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao.DienthoaiDAO;
import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao.DienthoaiDAOImpl;
import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.DienThoai;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuanLyFormServlet", value = "/quan-ly")
public class QuanLyFormServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlydienthoai")
    private DataSource dataSource;
    private DienthoaiDAO dienthoaiDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dienthoaiDAO = new DienthoaiDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DienThoai> dienthoaiList = dienthoaiDAO.getAllDienThoaiWithNCC();
        request.setAttribute("dienthoaiList", dienthoaiList);
        request.getRequestDispatcher("/views/QuanLyForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDT = request.getParameter("maDT");
        String message = null;
        if (maDT != null && !maDT.trim().isEmpty()) {
            boolean deleted = dienthoaiDAO.deleteDienThoai(maDT.trim());
            if (deleted) {
                message = "Xóa thành công điện thoại có mã: " + maDT;
            } else {
                message = "Không thể xóa điện thoại có mã: " + maDT;
            }
        }
        List<DienThoai> dienthoaiList = dienthoaiDAO.getAllDienThoaiWithNCC();
        request.setAttribute("dienthoaiList", dienthoaiList);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/views/QuanLyForm.jsp").forward(request, response);
    }
}

