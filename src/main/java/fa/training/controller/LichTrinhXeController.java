package fa.training.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.entities.LichTrinhXe;
import fa.training.entities.MultykeyLichTrinhXe;
import fa.training.entities.TuyenXe;
import fa.training.entities.Xe;
import fa.training.service.LichTrinhXeService;
import fa.training.service.TuyenXeService;
import fa.training.service.XeService;

@Controller
@RequestMapping("/lichtrinhxe")
public class LichTrinhXeController {
	
	@Autowired
	private LichTrinhXeService lichTrinhXeService;
	
	@Autowired
	private XeService xeService;
	
	@Autowired
	private TuyenXeService tuyenXeService;
	
	@GetMapping("/getAllLichTrinhXe")
	public String getLichTrinhXe(Model model) {
		List<LichTrinhXe> listLichTrinhXe = lichTrinhXeService.getAllLichTrinhXe();
		if(listLichTrinhXe.isEmpty()) {
			model.addAttribute("listNull", "Không có dữ liệu !!!");
		}else {
			model.addAttribute("listLichTrinhXe", listLichTrinhXe);
		}
		return "ListLichTrinhXe";
	}
	@GetMapping("/getAddLichTrinhXe")
	public String getAddLichTrinhXe(Model model) {
		List<Xe> listXe = xeService.getAllXe();
		List<TuyenXe> listTuyenXe = tuyenXeService.getAllTuyenXe();
		if(listXe.isEmpty() || listTuyenXe.isEmpty()) {
			model.addAttribute("listNull", "Không có dữ liệu !!!");
		}else {
			model.addAttribute("listXeSelect", listXe);
			model.addAttribute("listTuyenXe", listTuyenXe);
		}
		return "addLichTrinhXe";
	}
	
	@PostMapping("/addLichTrinhXe")
	public String addLictTrinh(Model model,  RedirectAttributes redirectAtt, @RequestParam("maxe") String maXe, @RequestParam("taixe") String taiXe, 
			@RequestParam("matuyen") String maTuyen,@RequestParam("ngayxuatben") String ngayXuatBen, 
			@RequestParam("gioxb") String gioXB, @RequestParam("slhanhkhach") String soluonghk) {
		
		LocalDate parseNgayXB = LocalDate.parse(ngayXuatBen);
		LocalTime parseGioXB = LocalTime.parse(gioXB);
		int soLuongHanhKhach = Integer.parseInt(soluonghk);
		
		/*
		 * Xe xe = new Xe(); xe.setMaXe(maXe);
		 */
		
		TuyenXe tuyenXe = new TuyenXe();
		tuyenXe.setMaTuyen(maTuyen);
		
		MultykeyLichTrinhXe multykey = new MultykeyLichTrinhXe();
		multykey.setMaXe(maXe);
		multykey.setNgayXuatBen(parseNgayXB);
		multykey.setGioXuatBen(parseGioXB);
		
		LichTrinhXe lichTrinhXe = new LichTrinhXe(multykey, taiXe, soLuongHanhKhach, tuyenXe);
		
		if(lichTrinhXeService.save(lichTrinhXe)) {
			List<LichTrinhXe> listLichTrinhXe = lichTrinhXeService.getAllLichTrinhXe();
			model.addAttribute("listLichTrinhXe", listLichTrinhXe);
			redirectAtt.addFlashAttribute("addSuccess", "OK");
		}
		return "redirect:/lichtrinhxe/getAllLichTrinhXe";
	}
	
	@GetMapping("/editlichtrinhxe")
	public String getEditLichTrinhXe(Model model, @RequestParam("maXe") String maXe) {
		List<LichTrinhXe> listLTX = lichTrinhXeService.getLichTrinhXeById(maXe);
		if(listLTX.isEmpty()) {
			model.addAttribute("listNull", "Khong co du lieu !!!");
		}else {
			model.addAttribute("listLTX", listLTX);
			List<Xe> listXe = xeService.getAllXe();
			model.addAttribute("listXe", listXe);
			List<TuyenXe> listTuyenXe = tuyenXeService.getAllTuyenXe();
			model.addAttribute("tuyenXe", listTuyenXe);
		}
		return "EditLichTrinhXe";
	}
	
	@PostMapping("/editLTX")
	public String editLTX(Model model,RedirectAttributes redirectAtt, @RequestParam("maxe") String maXe, 
			@RequestParam("tuyenxe") String tuyenXe, 
			@RequestParam("tentaixe") String tenTaiXe, 
			@RequestParam("slHanhKhach") String slKH, 
			@RequestParam("ngayxuatben") String ngayXB, 
			@RequestParam("gioxuatben") String gioXB,
			@RequestParam("tuyenxe") String maTuyen) {
		LocalDate parseDate = LocalDate.parse(ngayXB);
		LocalTime parseTime = LocalTime.parse(gioXB);
		int soluongHK = Integer.parseInt(slKH);
		
		MultykeyLichTrinhXe multykeyLichTrinhXe = new MultykeyLichTrinhXe();
		multykeyLichTrinhXe.setMaXe(maXe);
		multykeyLichTrinhXe.setNgayXuatBen(parseDate);
		multykeyLichTrinhXe.setGioXuatBen(parseTime);
		
		TuyenXe tuyenxe = new TuyenXe();
		tuyenxe.setMaTuyen(maTuyen);
		
		LichTrinhXe lichTrinhXe = new LichTrinhXe();
		lichTrinhXe.setMultykeyLTX(multykeyLichTrinhXe);
		lichTrinhXe.setSoLuongHanhKhach(soluongHK);
		lichTrinhXe.setTenTaiXe(tenTaiXe);
		lichTrinhXe.setTuyenXe(tuyenxe);
		if(lichTrinhXeService.update(lichTrinhXe)) {
			redirectAtt.addFlashAttribute("editOk", "OK");
			List<LichTrinhXe> listLichTrinhXe = lichTrinhXeService.getAllLichTrinhXe();
			model.addAttribute("listLichTrinhXe", listLichTrinhXe);
		}
		return "redirect:/lichtrinhxe/getAllLichTrinhXe";
	}
	
	@GetMapping("/delete")
	public String delete(Model model,@RequestParam("maXe") String maXe, RedirectAttributes redirectAtt) {
		if(lichTrinhXeService.delete(maXe)) {
			List<LichTrinhXe> listLichTrinhXe = lichTrinhXeService.getAllLichTrinhXe();
			model.addAttribute("listLichTrinhXe", listLichTrinhXe);
		}
		return "redirect:/lichtrinhxe/getAllLichTrinhXe";
	}
}
