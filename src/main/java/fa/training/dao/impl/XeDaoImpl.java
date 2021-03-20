package fa.training.dao.impl;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.XeDao;
import fa.training.entities.Xe;

@Repository()
public class XeDaoImpl implements XeDao{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public boolean save(Xe xe) {
		boolean success = false;
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			currentSession.saveOrUpdate(xe);
			success = true;
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return success;
	}

	@Override
	public List<Xe> getAllXe() {
		Session currentSession = sessionFactory.openSession();
		Query<Xe> theQuery = currentSession.createQuery("from Xe", Xe.class);
		List<Xe> xes = theQuery.getResultList();
		return xes;
	}

	@Override
	public boolean update(Xe xe) {
		Transaction transaction = null;
		Session session = sessionFactory.openSession();
		try {
			transaction =   session.beginTransaction();
			//Neu truong da ton tai thi update con neu khong ton tai thi insert
			session.saveOrUpdate(xe);
			transaction.commit();
			return true;
		} finally {
			if (session != null) {
				session.close();
            }
		}
	}

	@Override
	public List<Xe> findById(String maXe) {
		Session currentSession = sessionFactory.openSession();
		Query<Xe> theQuery = currentSession.createQuery("SELECT X FROM Xe AS X WHERE X.maXe = :maXe", Xe.class);
		theQuery.setParameter("maXe", maXe);
		List<Xe> xes = theQuery.getResultList();
		return xes;
	}

	@Override
	public List<Xe> getAllXeJoin(String maXe) {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Query<Xe> list = session.createQuery("SELECT X, LX, NX FROM Xe AS X INNER JOIN X.loaiXe AS LX INNER JOIN X.nhaXe AS NX WHERE X.maXe = :maXe");
			list.setParameter("maXe", maXe);
			return list.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public boolean delete(String maXe) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();
			Object persitentInstance = session.load(Xe.class, maXe);
			
			if(persitentInstance != null) {
				session.delete(persitentInstance);
				transaction.commit();
				return true;
			}else {
				return false;
			}
			
		} finally {
			if (session != null) {
                session.close();
            }
		}
	}

	@Override
	public List<Xe> findByNameNhaXe(String nameNhaXe) {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Query<Xe> list = session.createQuery("SELECT X,LX,NX FROM Xe AS X INNER JOIN X.loaiXe AS LX INNER JOIN X.nhaXe AS NX WHERE X.nhaXe.maNhaXe = :maNhaXe");
			list.setParameter("maNhaXe","%"+ nameNhaXe +"%");
			return list.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
