package fa.training.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "dbo", name = "loaixe")
public class LoaiXe {
	
	@Id
	@Column(name = "maloaixe", columnDefinition = "varchar(10)")
	private String maLoaiXe;
	
	@Column(name = "motaloaixe", columnDefinition = "varchar(50)")
	private String moTaLoaiXe;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiXe")
	private List<Xe> listXe;
	
	@Column(name = "soluongchongoi", columnDefinition = "int")
	private int soLuongChoNgoi;

	public String getMaLoaiXe() {
		return maLoaiXe;
	}

	public void setMaLoaiXe(String maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}

	public String getMoTaLoaiXe() {
		return moTaLoaiXe;
	}

	public void setMoTaLoaiXe(String moTaLoaiXe) {
		this.moTaLoaiXe = moTaLoaiXe;
	}

	public List<Xe> getListXe() {
		return listXe;
	}

	public void setListXe(List<Xe> listXe) {
		this.listXe = listXe;
	}

	public int getSoLuongChoNgoi() {
		return soLuongChoNgoi;
	}

	public void setSoLuongChoNgoi(int soLuongChoNgoi) {
		this.soLuongChoNgoi = soLuongChoNgoi;
	}

	public LoaiXe(String maLoaiXe, String moTaLoaiXe, List<Xe> listXe, int soLuongChoNgoi) {
		super();
		this.maLoaiXe = maLoaiXe;
		this.moTaLoaiXe = moTaLoaiXe;
		this.listXe = listXe;
		this.soLuongChoNgoi = soLuongChoNgoi;
	}

	public LoaiXe() {
		super();
	}
}
