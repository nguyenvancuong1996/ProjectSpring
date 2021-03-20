package fa.training.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.NhaXeDao;
import fa.training.entities.NhaXe;

@Repository()
public class NhaXeDaoImpl implements NhaXeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<NhaXe> getAllNhaXe() {
		Session currentSession = sessionFactory.openSession();
		Query<NhaXe> theQuery = currentSession.createQuery("from NhaXe", NhaXe.class);
		List<NhaXe> nhaXe = theQuery.getResultList();
		return nhaXe;
	}

}
