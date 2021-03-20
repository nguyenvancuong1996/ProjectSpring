package fa.training.controller;

import java.time.LocalDate;
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

import fa.training.dao.LoaiXeDao;
import fa.training.entities.LoaiXe;
import fa.training.entities.NhaXe;
import fa.training.entities.Xe;
import fa.training.service.NhaXeService;
import fa.training.service.XeService;

@Controller
@RequestMapping("/xe")
public class XeController {

	@Autowired
	private XeService xeService;

	@Autowired
	private LoaiXeDao loaiXeService;

	@Autowired
	private NhaXeService nhaXeService;

	@GetMapping("/getAllXe")
	public String loadXe(Model model) {

		List<Xe> listXe = xeService.getAllXe();
		if (listXe.isEmpty()) {
			model.addAttribute("listNull", "Không có dữ liệu !!!");
		} else {
			model.addAttribute("listXe", listXe);
		}
		return "listXe";
	}

	@GetMapping("/addXe")
	public String loadAddXe(Model model) {

		List<NhaXe> listNhaXe = nhaXeService.getAllNhaXe();
		List<LoaiXe> listLoaiXe = loaiXeService.getAllLoaiXe();

		if (listNhaXe.isEmpty() || listLoaiXe.isEmpty()) {

			model.addAttribute("listNull", "Không có dữ liệu !!!");

		} else {

			model.addAttribute("listNhaXe", listNhaXe);
			model.addAttribute("listLoaiXe", listLoaiXe);

		}
		return "addXe";
	}

	@PostMapping("/addXe")
	public String addXe(Model model, RedirectAttributes redirectAtt, @RequestParam("maxe") String maXe,
			@RequestParam("hangsanxuat") String hangsanxuat, @RequestParam("maloaixe") String maloaixe,
			@RequestParam("bienso") String bienso, @RequestParam("hangkiemdinh") String hangkiemdinh,
			@RequestParam("manhaxe") String manhaxe) {

		LoaiXe loaiXe = new LoaiXe();
		loaiXe.setMaLoaiXe(maloaixe);

		NhaXe nhaXe = new NhaXe();
		nhaXe.setMaNhaXe(manhaxe);
		// Validate date Hang Kiem Dinh
		// Date Now
		LocalDate dateNow = LocalDate.now();
		LocalDate dateInput = LocalDate.parse(hangkiemdinh);
		// Plus 1 month
		dateNow = dateNow.plusMonths(1);
		// Compare
		int compare = dateInput.compareTo(dateNow);
		// dateNow > dateInput
		if (compare < 0) {
			redirectAtt.addFlashAttribute("errorDate", "error");
			return "redirect:/xe/addXe";
		} else {
			Xe xe = new Xe(maXe, hangsanxuat, bienso, loaiXe, nhaXe, hangkiemdinh);
			if (xeService.save(xe)) {
				List<Xe> listXe = xeService.getAllXe();
				redirectAtt.addFlashAttribute("message", "success");
				model.addAttribute("listXe", listXe);
			}
			return "redirect:/xe/getAllXe";
		}
	}
	
	@GetMapping("/editXe")
	public String loadEditXe(Model model,@RequestParam("maXe") String maXe) {
		List<NhaXe> listNhaXe = nhaXeService.getAllNhaXe();
		List<LoaiXe> listLoaiXe = loaiXeService.getAllLoaiXe();
		List<Xe> listXe = xeService.getAllXeJoin(maXe);
		
		model.addAttribute("listNhaXe", listNhaXe);
		model.addAttribute("listLoaiXe", listLoaiXe);
		model.addAttribute("listXe", listXe);
		return "EditXe";
	}
	
	@PostMapping("/editXe")
	public String EditXe(Model model, RedirectAttributes redirectAtt, @RequestParam("maxe") String maXe, @RequestParam("hangsanxuat") String hangSanXuat, @RequestParam("bienso") String bienSo, @RequestParam("hangkiemdinh") String hangKiemDinh, @RequestParam("maloaixe") String maLoaiXe, @RequestParam("manhaxe") String maNhaXe) {
		NhaXe nhaXe = new NhaXe();
		nhaXe.setMaNhaXe(maNhaXe);
		LoaiXe loaiXe = new LoaiXe();
		loaiXe.setMaLoaiXe(maLoaiXe);
		Xe xe = new Xe(maXe, hangSanXuat, bienSo, loaiXe, nhaXe, hangKiemDinh);
		if(xeService.update(xe) == true) {
			redirectAtt.addFlashAttribute("messageEdit", "Success");
			List<Xe> listXe =	xeService.getAllXe();
			model.addAttribute("listXe", listXe);
		}
		return "redirect:/xe/getAllXe";
	}
	
	@GetMapping("/delete")
	public String deleteXe(Model model, RedirectAttributes redirectAtt, @RequestParam("maXe") String maXe) {
		if(xeService.delete(maXe) == true) {
			redirectAtt.addFlashAttribute("messageDelete", "Success");
		}
		return "redirect:/xe/getAllXe";
	}
	
	@GetMapping("/searchXe")
	public String searchXe(Model model, @RequestParam("search") String data) {
		if(data == null || data == "") {
			model.addAttribute("dataNull", "Bạn chưa nhập dữ liệu !!!");
			return "listXe";
		}else {
			List<Xe> listXe = xeService.findByNameNhaXe(data);
			if(!listXe.isEmpty()) {
				model.addAttribute("listXe", listXe);
				return "listXe";
			}else {
				model.addAttribute("listNull", "Không có dữ liệu !!!");
				return "listXe";
			}
		}
	}
}
