package fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.controller;

import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao.DienthoaiDAO;
import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao.DienthoaiDAOImpl;
import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao.NhaCungCapDAO;
import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao.NhaCungCapDAOImpl;
import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.DienThoai;
import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.NhaCungCap;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DienThoaiFormServlet", value = "/add-phone")
@MultipartConfig
public class DienThoaiFormServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlydienthoai")
    private DataSource dataSource;
    private DienthoaiDAO dienthoaiDAO;
    private NhaCungCapDAO nhaCungCapDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dienthoaiDAO = new DienthoaiDAOImpl(dataSource);
        nhaCungCapDAO = new NhaCungCapDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhaCungCap> nccList = nhaCungCapDAO.getAllNCC();
        request.setAttribute("nccList", nccList);
        request.getRequestDispatcher("/views/DienThoaiForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        String maDT = request.getParameter("maDT");
        String tenDT = request.getParameter("tenDT");
        String namSX = request.getParameter("namSX");
        String cauHinh = request.getParameter("cauHinh");
        String maNCC = request.getParameter("maNCC");
        Part hinhAnhPart = request.getPart("hinhAnh");
        String hinhAnhFileName = null;

        // Validate
        if (maDT == null || maDT.trim().isEmpty()) errors.add("Mã ĐT bắt buộc nhập.");
        if (tenDT == null || tenDT.trim().isEmpty()) errors.add("Tên điện thoại bắt buộc nhập.");
        if (namSX == null || !namSX.matches("\\d{4}")) errors.add("Năm sản xuất phải là số nguyên 4 chữ số.");
        if (cauHinh == null || cauHinh.trim().isEmpty()) errors.add("Thông tin cấu hình bắt buộc nhập.");
        else if (cauHinh.length() > 255) errors.add("Thông tin cấu hình không quá 255 ký tự.");
        if (hinhAnhPart == null || hinhAnhPart.getSize() == 0) errors.add("Hình ảnh bắt buộc chọn.");
        else {
            hinhAnhFileName = hinhAnhPart.getSubmittedFileName();
            String ext = hinhAnhFileName.substring(hinhAnhFileName.lastIndexOf('.') + 1).toLowerCase();
            if (!(ext.equals("png") || ext.equals("jpg") || ext.equals("jpeg"))) {
                errors.add("Chỉ chấp nhận file png, jpg, jpeg.");
            }
        }
        if (maNCC == null || maNCC.trim().isEmpty()) errors.add("Nhà cung cấp bắt buộc chọn.");

        if (!errors.isEmpty()) {
            List<NhaCungCap> nccList = nhaCungCapDAO.getAllNCC();
            request.setAttribute("nccList", nccList);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/views/DienThoaiForm.jsp").forward(request, response);
            return;
        }

        // Save image to /views/img
        String uploadPath = getServletContext().getRealPath("/views/img");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();
        hinhAnhPart.write(uploadPath + File.separator + hinhAnhFileName);

        // Insert to DB
        DienThoai dt = new DienThoai();
        dt.setMaDT(maDT.trim());
        dt.setTenDT(tenDT.trim());
        dt.setNamSX(Integer.parseInt(namSX.trim()));
        dt.setCauHinh(cauHinh.trim());
        dt.setHinhAnh(hinhAnhFileName);
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMaNCC(maNCC);
        dt.setNhaCungCap(ncc);
        dienthoaiDAO.insertDienThoai(dt);

        // Redirect to main list
        response.sendRedirect(request.getContextPath() + "/home");
    }
}

