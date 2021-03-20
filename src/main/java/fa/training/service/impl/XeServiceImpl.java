package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.dao.XeDao;
import fa.training.entities.Xe;
import fa.training.service.XeService;

@Service
public class XeServiceImpl implements XeService{
	
	@Autowired
	private XeDao xeDao;
	
	@Override
	@Transactional
	public boolean save(Xe xe) {
		return xeDao.save(xe);
	}

	@Override
	@Transactional
	public List<Xe> getAllXe() {
		return xeDao.getAllXe();
	}

	@Override
	@Transactional
	public boolean update(Xe xe) {
		return xeDao.update(xe);
	}

	@Override
	@Transactional
	public List<Xe> findById(String maXe) {
		return xeDao.findById(maXe);
	}

	@Override
	@Transactional
	public List<Xe> getAllXeJoin(String maXe) {
		return xeDao.getAllXeJoin(maXe);
	}

	@Override
	@Transactional
	public boolean delete(String maXe) {
		return xeDao.delete(maXe);
	}

	@Override
	@Transactional
	public List<Xe> findByNameNhaXe(String nameNhaXe) {
		return xeDao.findByNameNhaXe(nameNhaXe);
	}

}
