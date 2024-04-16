package Long.nhanvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Long.nhanvien.entity.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long>{
	List<NhanVien> findByTenPhongBanContainingAndTuoiLessThanEqual(String tenPhongBan, int tuoi);
}
