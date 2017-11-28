package com.webTest.Dao;

import java.sql.SQLException;
import java.util.List;
import com.webTest.Bean.Adm;

public interface AdmDao {
	
	 List<Adm> getAdmlist();
	 
	 Adm get(String admEmail,String password);
	 
	 boolean Register(Adm adm) throws Exception;
	 
	 Adm get(int aid);
	 
	 void delet(int aid);
	 
	 void update(Adm adm) throws Exception;
	 
	 Adm findAdmByCode(String code) throws Exception;
	 
	 Adm findEmail(String admEmail) throws SQLException;
	 
}
