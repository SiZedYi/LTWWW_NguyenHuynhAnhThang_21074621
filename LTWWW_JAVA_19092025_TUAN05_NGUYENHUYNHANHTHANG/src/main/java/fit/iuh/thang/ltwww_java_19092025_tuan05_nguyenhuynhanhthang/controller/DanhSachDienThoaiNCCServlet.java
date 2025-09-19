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

@WebServlet(name="DanhSachDienThoaiNCCServlet", value = "/")
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
        // Lấy mã nhà cung cấp từ request parameter
        String maNCC = request.getParameter("maNCC");
        if (maNCC == null || maNCC.isEmpty()) {
            maNCC = "1";
        }
        System.out.println("MaNCC: " + maNCC);
        // Lấy danh sách điện thoại từ cơ sở dữ liệu
        List<DienThoai> listDt = dienthoaiDAO.getAllDienThoaiByNCC(maNCC);
        request.setAttribute("dienthoaiList", listDt);
        request.getRequestDispatcher("/views/DanhSachDienThoaiNCC.jsp").forward(request, response);

    }
}
