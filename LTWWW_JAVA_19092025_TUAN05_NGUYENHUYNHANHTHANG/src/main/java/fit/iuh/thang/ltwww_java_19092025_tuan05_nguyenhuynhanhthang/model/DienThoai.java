package fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model;

public class DienThoai {
    private String maDT;
    private String tenDT;
    private Integer namSX;
    private String cauHinh;
    private NhaCungCap nhaCungCap;
    private String hinhAnh;

    public DienThoai() {
    }

    public DienThoai(String maDT, String tenDT, Integer namSX, String cauHinh, NhaCungCap nhaCungCap, String hinhAnh) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namSX = namSX;
        this.cauHinh = cauHinh;
        this.nhaCungCap = nhaCungCap;
        this.hinhAnh = hinhAnh;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public Integer getNamSX() {
        return namSX;
    }

    public void setNamSX(Integer namSX) {
        this.namSX = namSX;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
