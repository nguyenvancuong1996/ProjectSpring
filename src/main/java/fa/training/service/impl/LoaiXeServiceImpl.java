package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.dao.LoaiXeDao;
import fa.training.entities.LoaiXe;
import fa.training.service.LoaiXeService;

@Service
public class LoaiXeServiceImpl implements LoaiXeService{
	
	@Autowired
	private LoaiXeDao loaiXeDao;
	
	@Override
	@Transactional
	public List<LoaiXe> getAllLoaiXe() {
		return loaiXeDao.getAllLoaiXe();
	}

}
