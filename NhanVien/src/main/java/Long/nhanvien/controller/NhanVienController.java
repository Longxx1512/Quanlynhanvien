package Long.nhanvien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Long.nhanvien.entity.NhanVien;
import Long.nhanvien.service.NhanVienService;

@Controller
public class NhanVienController {

	@Autowired
	private NhanVienService nhanVienService;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listNhanViens", nhanVienService.getAllNhanViens());
		return "index";
	}

	
	@GetMapping("/showNewNhanVienForm")
	public String showNewNhanVienForm(Model model) {
		// create model attribute to bind form data
		NhanVien nhanvien = new NhanVien();
		model.addAttribute("nhanvien", nhanvien);
		return "new_nhanvien";
	}
	
	
	@PostMapping("/saveNhanVien")
	public String saveKhoangSan(@ModelAttribute("nhanvien") NhanVien nhanvien) {
		// save 
		nhanVienService.saveNhanVien(nhanvien);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		NhanVien nhanvien = nhanVienService.getNhanVienById(id);

		model.addAttribute("nhanvien", nhanvien);
		return "update_nhanvien";
	}

	@GetMapping("/deleteNhanVien/{id}")
	public String deleteNhanVien(@PathVariable(value = "id") long id) {

		this.nhanVienService.deleteNhanVienById(id);
		return "redirect:/";
	}
	
	@GetMapping("/searchNhanViens")
	public String searchNhanViens(@RequestParam(value = "tenPhongBan", required = false) String tenPhongBan,
	                                @RequestParam(value = "tuoi", required = false) Integer tuoi,
	                                Model model) {

	    List<NhanVien> nhanviens;
	    
	    if (tenPhongBan != null && tuoi != null) {
	        nhanviens = nhanVienService.searchNhanViens(tenPhongBan, tuoi);
	    } else {
	    	nhanviens = nhanVienService.getAllNhanViens();
	    }

	    model.addAttribute("listNhanViens", nhanviens);
	    return "index";
	}
}
