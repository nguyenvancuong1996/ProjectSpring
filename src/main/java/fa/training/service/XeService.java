package fa.training.service;

import java.util.List;

import fa.training.entities.Xe;

public interface XeService {
	boolean save(Xe xe);
	List<Xe> getAllXe();
	boolean update(Xe xe);
	boolean delete(String maXe);
	List<Xe> findById(String maXe);
	List<Xe> getAllXeJoin(String maXe);
	List<Xe> findByNameNhaXe(String nameNhaXe);
}
