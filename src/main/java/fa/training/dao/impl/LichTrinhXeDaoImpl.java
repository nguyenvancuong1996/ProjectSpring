package fa.training.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.LichTrinhXeDao;
import fa.training.entities.LichTrinhXe;
import fa.training.entities.MultykeyLichTrinhXe;
import fa.training.entities.Xe;

@Repository
public class LichTrinhXeDaoImpl implements LichTrinhXeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<LichTrinhXe> getAllLichTrinhXe() {
		Session currentSession = sessionFactory.openSession();
		try {
			Transaction transaction = currentSession.beginTransaction();
			List<LichTrinhXe> list = currentSession.createQuery("SELECT LTX,TX,X FROM LichTrinhXe AS LTX INNER JOIN LTX.tuyenXe AS TX INNER JOIN LTX.xe AS X").list();
			return list;
		} finally {
			if (currentSession != null) {
				currentSession.close();
			}
		}
	}

	@Override
	public boolean save(LichTrinhXe lichTrinhXe) {
		boolean success = false;
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			currentSession.saveOrUpdate(lichTrinhXe);
			success = true;
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return success;
	}

	@Override
	public List<LichTrinhXe> getLichTrinhXeById(String maXe) {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Query<LichTrinhXe> list = session.createQuery("SELECT LTX,TX,X FROM LichTrinhXe AS LTX INNER JOIN LTX.tuyenXe AS TX INNER JOIN LTX.xe AS X WHERE LTX.multykeyLTX.maXe = :maXe");
			list.setParameter("maXe", maXe);
			return list.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public boolean update(LichTrinhXe lichtrinhxe) {
		Transaction transaction = null;
		Session session = sessionFactory.openSession();
		try {
			transaction =   session.beginTransaction();
			//Neu truong da ton tai thi update con neu khong ton tai thi insert
			session.saveOrUpdate(lichtrinhxe);
			transaction.commit();
			return true;
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
			Object persitentInstance = session.load(LichTrinhXe.class, maXe);
			
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

}
