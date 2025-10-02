package fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao;

import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.DienThoai;

import java.util.List;

public interface DienthoaiDAO {
    List<DienThoai> getAllDienThoaiWithNCC();
    List<DienThoai> searchDienThoaiByTenNCC(String tenNCC);
    void insertDienThoai(fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.DienThoai dt);
    boolean deleteDienThoai(String maDT);
}
