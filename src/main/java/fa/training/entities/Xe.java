package fa.training.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "dbo", name="xe")
@NamedNativeQueries({
	@NamedNativeQuery(name="findJoin", query = "SELECT X.*,NX.*,LX.* FROM xe AS X INNER JOIN nhaxe NX ON X.manhaxe = NX.manhaxe INNER JOIN loaixe AS LX ON X.maloaixe = LX.maloaixe", resultClass = Xe.class)
})
public class Xe {
	
	@Id
	@Column(name = "maxe", columnDefinition = "varchar(10)")
	private String maXe;
	
	@Column(name = "hangsanxuat", columnDefinition = "varchar(50)")
	private String hangSanXuat;
	
	@Column(name = "bienso", columnDefinition = "varchar(30)")
	private String bienSo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "xe")
	List<LichTrinhXe> listLichTrinhXe;
	
	@ManyToOne
	@JoinColumn(name = "maloaixe", referencedColumnName = "maloaixe", columnDefinition = "varchar(10)")
	private LoaiXe loaiXe;
	
	@ManyToOne
	@JoinColumn(name = "manhaxe", referencedColumnName = "manhaxe", columnDefinition = "varchar(10)")
	private NhaXe nhaXe;
	
	@Column(name = "hangkiemdinh", columnDefinition = "varchar(40)")
	private String hanKiemDinh;

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public String getBienSo() {
		return bienSo;
	}

	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}

	public List<LichTrinhXe> getListLichTrinhXe() {
		return listLichTrinhXe;
	}

	public void setListLichTrinhXe(List<LichTrinhXe> listLichTrinhXe) {
		this.listLichTrinhXe = listLichTrinhXe;
	}

	public LoaiXe getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}

	public NhaXe getNhaXe() {
		return nhaXe;
	}

	public void setNhaXe(NhaXe nhaXe) {
		this.nhaXe = nhaXe;
	}

	public String getHanKiemDinh() {
		return hanKiemDinh;
	}

	public void setHanKiemDinh(String hanKiemDinh) {
		this.hanKiemDinh = hanKiemDinh;
	}

	public Xe(String maXe, String hangSanXuat, String bienSo, LoaiXe loaiXe,
			NhaXe nhaXe, String hanKiemDinh) {
		super();
		this.maXe = maXe;
		this.hangSanXuat = hangSanXuat;
		this.bienSo = bienSo;
		this.loaiXe = loaiXe;
		this.nhaXe = nhaXe;
		this.hanKiemDinh = hanKiemDinh;
	}

	public Xe() {
		super();
	}
}
