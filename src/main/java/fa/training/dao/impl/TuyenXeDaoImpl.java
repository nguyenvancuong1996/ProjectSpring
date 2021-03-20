package fa.training.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.TuyenXeDao;
import fa.training.entities.TuyenXe;

@Repository
public class TuyenXeDaoImpl implements TuyenXeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TuyenXe> getAllTuyenXe() {
		Session currentSession = sessionFactory.openSession();
		Query<TuyenXe> theQuery = currentSession.createQuery("from TuyenXe", TuyenXe.class);
		List<TuyenXe> tuyenXe = theQuery.getResultList();
		return tuyenXe;
	}

}
