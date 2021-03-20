package fa.training.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.LoaiXeDao;
import fa.training.entities.LoaiXe;

@Repository()
public class LoaiXeImpl implements LoaiXeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<LoaiXe> getAllLoaiXe() {
		Session currentSession = sessionFactory.openSession();
		Query<LoaiXe> theQuery = currentSession.createQuery("from LoaiXe", LoaiXe.class);
		List<LoaiXe> loaiXe = theQuery.getResultList();
		return loaiXe;
	}

}
