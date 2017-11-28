package com.webTest.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webTest.Bean.Adm;
import com.webTest.Dao.AdmDao;
import com.webTest.tools.MailUtils;
@Service("admService")
public class AdmServiceImpl implements AdmService {
	private AdmDao admDao;

	
	public AdmDao getAdmDao() {
		return admDao;
	}


	public void setAdmDao(AdmDao admDao) {
		this.admDao = admDao;
	}


	@Override
	public List<Adm> getAdmlist() {
		// TODO Auto-generated method stub
		List<Adm> lists=admDao.getAdmlist();
		return lists;
	}


	
	
	@Override
	public Adm get(String admEmail,String password) {
		// TODO Auto-generated method stub
		return admDao.get(admEmail,password);
	}


	@Override
	public Adm get(int aid) {
		// TODO Auto-generated method stub
		Adm adm=admDao.get(aid);
		return adm;
	}



	@Override
	public void deletAdm(int aid) {
		admDao.delet(aid);
	
	}


	

	@Override
	public void updateAdm(Adm adm) throws Exception {
		// TODO Auto-generated method stub
		admDao.update(adm);
	}


	@Override
	public boolean Register(Adm adm)throws Exception {
		// TODO Auto-generated method stub
		MailUtils.sendMail(adm.getAdmEmail(), adm.getCode(), "来自华诚兴业的邮件");
		return admDao.Register(adm);
	}


	@Override
	public Adm findAdmByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return admDao.findAdmByCode(code);
	}



	@Override
	public Adm findEmail(String admEmail) throws Exception {
		Adm adma=admDao.findEmail(admEmail);
		return adma;
	}



}
