package fa.training.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "dbo", name = "tuyenxe")
public class TuyenXe {
	
	@Id
	@Column(name = "matuyen",columnDefinition = "varchar(10)")
	private String maTuyen;
	
	@Column(name = "tentuyen", columnDefinition = "varchar(50)")
	private String tenTuyen;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tuyenXe")
	private List<LichTrinhXe> listLichTrinhXe;
	
	@Column(name = "dongia", columnDefinition = "int")
	private double donGia;

	public String getMaTuyen() {
		return maTuyen;
	}

	public void setMaTuyen(String maTuyen) {
		this.maTuyen = maTuyen;
	}

	public String getTenTuyen() {
		return tenTuyen;
	}

	public void setTenTuyen(String tenTuyen) {
		this.tenTuyen = tenTuyen;
	}

	public List<LichTrinhXe> getListLichTrinhXe() {
		return listLichTrinhXe;
	}

	public void setListLichTrinhXe(List<LichTrinhXe> listLichTrinhXe) {
		this.listLichTrinhXe = listLichTrinhXe;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public TuyenXe(String maTuyen, String tenTuyen, List<LichTrinhXe> listLichTrinhXe, double donGia) {
		super();
		this.maTuyen = maTuyen;
		this.tenTuyen = tenTuyen;
		this.listLichTrinhXe = listLichTrinhXe;
		this.donGia = donGia;
	}

	public TuyenXe() {
		super();
	}
}
