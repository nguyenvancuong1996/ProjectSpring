package fa.training.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "dbo", name = "lichtrinhxe")
public class LichTrinhXe {
	
	@EmbeddedId
	private MultykeyLichTrinhXe multykeyLTX;
	
	@ManyToOne
	@JoinColumn(name ="maxe", referencedColumnName = "maxe", columnDefinition = "varchar(10)", insertable = false, updatable = false)
	private Xe xe;
	
	@Column(name ="tentaixe", columnDefinition = "varchar(30)")
	private String tenTaiXe;
	
	@Column(name = "soluonghanhkhach", columnDefinition = "int")
	private int soLuongHanhKhach;
	
	@ManyToOne
	@JoinColumn(name = "matuyen", referencedColumnName = "matuyen", columnDefinition = "varchar(10)")
	private TuyenXe tuyenXe;

	public MultykeyLichTrinhXe getMultykeyLTX() {
		return multykeyLTX;
	}

	public void setMultykeyLTX(MultykeyLichTrinhXe multykeyLTX) {
		this.multykeyLTX = multykeyLTX;
	}

	public Xe getXe() {
		return xe;
	}

	public void setXe(Xe xe) {
		this.xe = xe;
	}

	public String getTenTaiXe() {
		return tenTaiXe;
	}

	public void setTenTaiXe(String tenTaiXe) {
		this.tenTaiXe = tenTaiXe;
	}

	public int getSoLuongHanhKhach() {
		return soLuongHanhKhach;
	}

	public void setSoLuongHanhKhach(int soLuongHanhKhach) {
		this.soLuongHanhKhach = soLuongHanhKhach;
	}

	public TuyenXe getTuyenXe() {
		return tuyenXe;
	}

	public void setTuyenXe(TuyenXe tuyenXe) {
		this.tuyenXe = tuyenXe;
	}

	

	public LichTrinhXe(MultykeyLichTrinhXe multykeyLTX, String tenTaiXe, int soLuongHanhKhach, TuyenXe tuyenXe) {
		super();
		this.multykeyLTX = multykeyLTX;
		this.tenTaiXe = tenTaiXe;
		this.soLuongHanhKhach = soLuongHanhKhach;
		this.tuyenXe = tuyenXe;
	}

	public LichTrinhXe() {
		super();
	}
	
}
