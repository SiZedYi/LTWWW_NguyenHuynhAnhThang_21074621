package fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao;

import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.NhaCungCap;

import javax.sql.DataSource;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {
    private final DataSource dataSource;

    public NhaCungCapDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public NhaCungCap findByMaNCC(String maNCC) {
        return null;
    }

    @Override
    public java.util.List<NhaCungCap> getAllNCC() {
        java.util.List<NhaCungCap> list = new java.util.ArrayList<>();
        String sql = "SELECT * FROM NHACUNGCAP";
        try (var conn = dataSource.getConnection();
             var ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getString("maNCC"));
                ncc.setTenNCC(rs.getString("tenNhaCC"));
                ncc.setDiaChi(rs.getString("diaChi"));
                ncc.setSoDienThoai(rs.getString("sodienthoai"));
                list.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
