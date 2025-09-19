package fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao;

import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.DienThoai;
import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.NhaCungCap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class DienthoaiDAOImpl implements DienthoaiDAO {
    private final DataSource dataSource;
    public DienthoaiDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<DienThoai> getAllDienThoaiByNCC(String maNCC) {
        String query = "select * from DIENTHOAI where maNCC=?";
        List<DienThoai> dienthoaiList = new ArrayList<DienThoai>();
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, maNCC);
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                DienThoai dt = new DienThoai();
                dt.setMaDT(rs.getString("maDT"));
                dt.setTenDT(rs.getString("tenDT"));
                dt.setNamSX(rs.getInt("namSanXuat"));
                dt.setCauHinh(rs.getString("cauHinh"));
                dt.setHinhAnh(rs.getString("hinhAnh"));
                NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("maNCC"), null, null, null);
                dt.setNhaCungCap(nhaCungCap);
                dienthoaiList.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dienthoaiList;
    }
}
