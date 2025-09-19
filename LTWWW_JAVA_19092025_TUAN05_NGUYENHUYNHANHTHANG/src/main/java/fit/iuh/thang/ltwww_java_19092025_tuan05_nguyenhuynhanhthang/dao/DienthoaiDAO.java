package fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.dao;

import fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.DienThoai;

import java.util.List;

public interface DienthoaiDAO {
    List<DienThoai> getAllDienThoaiByNCC(String maNCC);

}
