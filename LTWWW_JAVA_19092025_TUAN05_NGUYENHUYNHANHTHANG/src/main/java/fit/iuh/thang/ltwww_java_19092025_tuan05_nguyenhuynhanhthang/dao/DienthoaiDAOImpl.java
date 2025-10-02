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
    public List<DienThoai> getAllDienThoaiWithNCC() {
        String query = "SELECT dt.*, ncc.* FROM DIENTHOAI dt JOIN NHACUNGCAP ncc ON dt.maNCC = ncc.maNCC";
        List<DienThoai> dienthoaiList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             var rs = pstmt.executeQuery()) {
            while (rs.next()) {
                DienThoai dt = new DienThoai();
                dt.setMaDT(rs.getString("maDT"));
                dt.setTenDT(rs.getString("tenDT"));
                dt.setNamSX(rs.getInt("namSanXuat"));
                dt.setCauHinh(rs.getString("cauHinh"));
                dt.setHinhAnh(rs.getString("hinhAnh"));
                NhaCungCap nhaCungCap = new NhaCungCap(
                    rs.getString("maNCC"),
                    rs.getString("tenNhaCC"),
                    rs.getString("diaChi"),
                    rs.getString("sodienthoai")
                );
                dt.setNhaCungCap(nhaCungCap);
                dienthoaiList.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dienthoaiList;
    }

    public List<DienThoai> searchDienThoaiByTenNCC(String tenNCC) {
        String query = "SELECT dt.*, ncc.* FROM DIENTHOAI dt JOIN NHACUNGCAP ncc ON dt.maNCC = ncc.maNCC WHERE ncc.tenNhaCC LIKE ?";
        List<DienThoai> dienthoaiList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + tenNCC + "%");
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                DienThoai dt = new DienThoai();
                dt.setMaDT(rs.getString("maDT"));
                dt.setTenDT(rs.getString("tenDT"));
                dt.setNamSX(rs.getInt("namSanXuat"));
                dt.setCauHinh(rs.getString("cauHinh"));
                dt.setHinhAnh(rs.getString("hinhAnh"));
                NhaCungCap nhaCungCap = new NhaCungCap(
                        rs.getString("maNCC"),
                        rs.getString("tenNhaCC"),
                        rs.getString("diaChi"),
                        rs.getString("sodienthoai")
                );
                dt.setNhaCungCap(nhaCungCap);
                dienthoaiList.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dienthoaiList;
    }

    @Override
    public void insertDienThoai(fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.DienThoai dt) {
        String sql = "INSERT INTO DIENTHOAI (maDT, tenDT, namSanXuat, cauHinh, hinhAnh, maNCC) VALUES (?, ?, ?, ?, ?, ?)";
        try (var conn = dataSource.getConnection();
             var ps = conn.prepareStatement(sql)) {
            ps.setString(1, dt.getMaDT());
            ps.setString(2, dt.getTenDT());
            ps.setInt(3, dt.getNamSX());
            ps.setString(4, dt.getCauHinh());
            ps.setString(5, dt.getHinhAnh());
            ps.setString(6, dt.getNhaCungCap().getMaNCC());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteDienThoai(String maDT) {
        String sql = "DELETE FROM DIENTHOAI WHERE maDT = ?";
        try (var conn = dataSource.getConnection();
             var ps = conn.prepareStatement(sql)) {
            ps.setString(1, maDT);
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
