package Long.nhanvien.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import Long.nhanvien.entity.NhanVien;
import Long.nhanvien.repository.NhanVienRepository;

@Service
public class NhanVienServiceImpl implements NhanVienService{

	
	@Autowired
	private NhanVienRepository nhanVienRepository;
	@Override
	public List<NhanVien> getAllNhanViens() {
		// TODO Auto-generated method stub
		return nhanVienRepository.findAll();
	}

	@Override
	public void saveNhanVien(NhanVien nhanvien) {
		// TODO Auto-generated method stub
		this.nhanVienRepository.save(nhanvien);
	}

	@Override
	public NhanVien getNhanVienById(long id) {
		// TODO Auto-generated method stub
		Optional<NhanVien> optional = nhanVienRepository.findById(id);
		NhanVien nhanvien = null;
		if(optional.isPresent()) {
			nhanvien = optional.get();
			}else {
				throw new RuntimeException("Không có nhân viên với mã nhân viên là: "+id);
			}
		return nhanvien;
	}

	@Override
	public void deleteNhanVienById(long id) {
		// TODO Auto-generated method stub
		this.nhanVienRepository.deleteById(id);
	}

	@Override
	public Page<NhanVien> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NhanVien> searchNhanViens(String tenPhongBan, int tuoi) {
		// TODO Auto-generated method stub
		return nhanVienRepository.findByTenPhongBanContainingAndTuoiLessThanEqual(tenPhongBan, tuoi);
	}

}
