package fa.training.dao;

import java.util.List;

import fa.training.entities.LichTrinhXe;

public interface LichTrinhXeDao {
	List<LichTrinhXe> getAllLichTrinhXe();
	boolean save(LichTrinhXe lichTrinhXe);
	List<LichTrinhXe> getLichTrinhXeById(String maXe);
	boolean update(LichTrinhXe lichtrinhxe);
	boolean delete(String maXe);
}
