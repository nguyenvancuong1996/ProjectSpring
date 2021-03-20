package fa.training.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "dbo", name = "nhaxe")
public class NhaXe {
	
	@Id
	@Column(name = "manhaxe", columnDefinition = "varchar(10)")
	private String maNhaXe;
	
	@Column(name = "tennhaxe", columnDefinition = "varchar(30)")
	private String tenNhaXe;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nhaXe")
	private List<Xe> listXe;
	
	@Column(name = "namthanhlap", columnDefinition = "varchar(10)")
	private String namThanhLap;

	public String getMaNhaXe() {
		return maNhaXe;
	}

	public void setMaNhaXe(String maNhaXe) {
		this.maNhaXe = maNhaXe;
	}

	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	public List<Xe> getListXe() {
		return listXe;
	}

	public void setListXe(List<Xe> listXe) {
		this.listXe = listXe;
	}

	public String getNamThanhLap() {
		return namThanhLap;
	}

	public void setNamThanhLap(String namThanhLap) {
		this.namThanhLap = namThanhLap;
	}

	public NhaXe(String maNhaXe, String tenNhaXe, List<Xe> listXe, String namThanhLap) {
		super();
		this.maNhaXe = maNhaXe;
		this.tenNhaXe = tenNhaXe;
		this.listXe = listXe;
		this.namThanhLap = namThanhLap;
	}

	public NhaXe() {
		super();
	}
}
