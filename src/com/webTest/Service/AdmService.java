package com.webTest.Service;

import java.sql.SQLException;
import java.util.List;


import com.webTest.Bean.Adm;

public interface AdmService {
	 List<Adm> getAdmlist();
	 Adm get(String admEmail,String password);
	 Adm get(int aid);
	 void deletAdm(int aid);
	 void updateAdm(Adm adm) throws Exception;
	 boolean Register(Adm adm) throws Exception;
	 Adm findAdmByCode(String code) throws Exception;
	 Adm findEmail(String admEmail) throws SQLException, Exception;
}
