package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.dao.TuyenXeDao;
import fa.training.entities.TuyenXe;
import fa.training.service.TuyenXeService;

@Service
public class TuyenXeServiceImpl implements TuyenXeService{

	@Autowired
	private TuyenXeDao tuyenXeDao;
	
	@Override
	@Transactional
	public List<TuyenXe> getAllTuyenXe() {
		return tuyenXeDao.getAllTuyenXe();
	}

}
