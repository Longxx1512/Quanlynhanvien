package Long.nhanvien.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_nhanvien")
public class NhanVien {

	@Id
	@Column(name = "manv")
	private Long maNV;
	@Column(name = "tennhanvien")
	private String tenNhanVien;
	@Column(name = "tenphongban")
	private String  tenPhongBan;
	@Column(name = "gioitinh")
	private String gioiTinh;
	@Column(name = "tuoi")
	private Integer tuoi;
	private String tinhTrang;
	public Long getMaNV() {
		return maNV;
	}
	public void setMaNV(Long maNV) {
		this.maNV = maNV;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Integer getTuoi() {
		return tuoi;
	}
	public void setTuoi(Integer tuoi) {
		this.tuoi = tuoi;
	}
	public String getTinhTrang() {
        if (tuoi >= 35) {
            return "Cao tuổi";
        } else if (tuoi >= 20) {
            return "Trung niên";
        } else {
            return "Trẻ";
        }
    }
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	
}
