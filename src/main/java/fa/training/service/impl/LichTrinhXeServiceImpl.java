package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.dao.LichTrinhXeDao;
import fa.training.entities.LichTrinhXe;
import fa.training.service.LichTrinhXeService;

@Service
public class LichTrinhXeServiceImpl implements LichTrinhXeService{

	@Autowired
	private LichTrinhXeDao lichTrinhXeDao;
	
	@Override
	@Transactional
	public List<LichTrinhXe> getAllLichTrinhXe() {
		return lichTrinhXeDao.getAllLichTrinhXe();
	}

	@Override
	@Transactional
	public boolean save(LichTrinhXe lichTrinhXe) {
		return lichTrinhXeDao.save(lichTrinhXe);
	}

	@Override
	@Transactional
	public List<LichTrinhXe> getLichTrinhXeById(String maXe) {
		return lichTrinhXeDao.getLichTrinhXeById(maXe);
	}

	@Override
	@Transactional
	public boolean update(LichTrinhXe lichtrinhxe) {
		return lichTrinhXeDao.update(lichtrinhxe);
	}

	@Override
	@Transactional
	public boolean delete(String maXe) {
		return lichTrinhXeDao.delete(maXe);
	}
}
