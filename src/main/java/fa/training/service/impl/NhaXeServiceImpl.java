package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.dao.NhaXeDao;
import fa.training.entities.NhaXe;
import fa.training.service.NhaXeService;

@Service
public class NhaXeServiceImpl implements NhaXeService{
	
	@Autowired
	private NhaXeDao nhaXeDao;
	
	@Override
	@Transactional
	public List<NhaXe> getAllNhaXe() {
		return nhaXeDao.getAllNhaXe();
	}

}
