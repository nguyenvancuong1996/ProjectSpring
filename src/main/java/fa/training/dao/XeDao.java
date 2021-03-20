package fa.training.dao;

import java.util.List;

import fa.training.entities.Xe;

public interface XeDao {
	boolean save(Xe xe);
	List<Xe> getAllXe();
	List<Xe> getAllXeJoin(String maXe);
	boolean update(Xe xe);
	boolean delete(String maXe);
	List<Xe> findById(String maXe);
	List<Xe> findByNameNhaXe(String nameNhaXe);
}
