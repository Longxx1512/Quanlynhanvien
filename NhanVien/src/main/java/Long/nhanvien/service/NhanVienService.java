package Long.nhanvien.service;

import java.util.List;

import org.springframework.data.domain.Page;

import Long.nhanvien.entity.NhanVien;


public interface NhanVienService {

	List<NhanVien> getAllNhanViens();
	void saveNhanVien(NhanVien nhanvien);
	NhanVien getNhanVienById(long id);
	void deleteNhanVienById(long id);
	Page<NhanVien> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	List<NhanVien> searchNhanViens(String tenPhongBan, int tuoi);
}
