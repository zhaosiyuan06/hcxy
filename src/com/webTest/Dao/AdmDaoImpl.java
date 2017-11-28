package com.webTest.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import com.webTest.Bean.Adm;
@Repository("admDao")
public class AdmDaoImpl implements AdmDao {
	private Session session;  
	
	public  SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession() {  
        if(session!=null)  
            return session;  
        return sessionFactory.getCurrentSession();  
    }  
	@SuppressWarnings("unchecked")
	@Override

	public List<Adm> getAdmlist() {
		List<Adm> lista =new ArrayList<>();
		String queryString = "from Adm";
		Query q = this.getCurrentSession().createQuery(queryString);  
		lista=q.list();
		return lista;
	}


	
	
	@Override
	public Adm get(String admEmail,String password) {
		String hsql="from Adm a where a.admEmail='"+admEmail+"' and a.admPassword='"+password+"'";
		Query q = this.getCurrentSession().createQuery(hsql);  
		Adm result=(Adm)q.uniqueResult();
		return result;
	}


	@Override
	public Adm get(int aid) {
	Adm adm=new Adm();
	adm.setAid(aid);
	adm=(Adm) this.getCurrentSession().get(Adm.class,adm.getAid());
	return adm;
	}	


	@Override
	public void delet(int aid) {
		Adm adm=new Adm();
		adm.setAid(aid);
		this.getCurrentSession().delete(adm);
	}


	@Override
	public void update(Adm adm) {
		this.getCurrentSession().update(adm);
	}
	

	@Override
	public boolean Register(Adm adm) throws Exception {
		try {
			this.getCurrentSession().save(adm);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	// DAO中 根据激活码查询用户的方法
	public Adm findAdmByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		String hsql="from Adm a where a.code='"+code+"'";
		Query q = this.getCurrentSession().createQuery(hsql);  
		Adm result=(Adm)q.uniqueResult();
		return result;
	}

	@Override
	public Adm findEmail(String admEmail) throws SQLException {
		String hsql="from Adm a where a.admEmail= '"+admEmail+"' ";
		Query q = this.getCurrentSession().createQuery(hsql);  
		Adm result=(Adm)q.uniqueResult();
		return result;
	}
	


}
