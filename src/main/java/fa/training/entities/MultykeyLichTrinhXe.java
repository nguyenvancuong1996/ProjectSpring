package fa.training.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

public class MultykeyLichTrinhXe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "maxe", columnDefinition = "varchar(10)")
	private String maXe;
	
	@Column(name = "ngayxuatben", columnDefinition = "date")
	private LocalDate ngayXuatBen;
	
	@Column(name = "gioxuatben", columnDefinition = "time(7)")
	private LocalTime gioXuatBen;

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}

	public LocalDate getNgayXuatBen() {
		return ngayXuatBen;
	}

	public void setNgayXuatBen(LocalDate ngayXuatBen) {
		this.ngayXuatBen = ngayXuatBen;
	}

	public LocalTime getGioXuatBen() {
		return gioXuatBen;
	}

	public void setGioXuatBen(LocalTime gioXuatBen) {
		this.gioXuatBen = gioXuatBen;
	}

	public MultykeyLichTrinhXe(String maXe, LocalDate ngayXuatBen, LocalTime gioXuatBen) {
		super();
		this.maXe = maXe;
		this.ngayXuatBen = ngayXuatBen;
		this.gioXuatBen = gioXuatBen;
	}

	public MultykeyLichTrinhXe() {
		super();
	}
}
