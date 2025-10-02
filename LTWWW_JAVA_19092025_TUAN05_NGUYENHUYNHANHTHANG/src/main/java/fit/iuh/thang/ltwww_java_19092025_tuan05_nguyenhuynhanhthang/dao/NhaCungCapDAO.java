package fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao;

import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.NhaCungCap;

public interface NhaCungCapDAO {
    NhaCungCap findByMaNCC(String maNCC);
    java.util.List<NhaCungCap> getAllNCC();
}
