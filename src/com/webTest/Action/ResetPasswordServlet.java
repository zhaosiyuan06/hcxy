package com.webTest.Action;




import java.io.IOException;

import javax.annotation.Resource;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.webTest.Bean.Adm;

import com.webTest.tools.Md5Test;


@Controller("/ResetPasswordServlet")
public class ResetPasswordServlet extends CheckServlet  {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private Md5Test md5Test;
	
	public Md5Test getMd5Test() {
		return md5Test;
	}
	public void setMd5Test(Md5Test md5Test) {
		this.md5Test = md5Test;
	}
	public static void main(String[] args) throws ServletException, IOException {
		CheckServlet.check();
	}

	public void newpassword() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse(); 
        String newPassword = request.getParameter("admPassword"); 
        md5Test=new Md5Test();
        newPassword=md5Test.toMD5(newPassword);
        String code1=CheckServlet.code;
		Adm ad=getAdmService().findAdmByCode(code1);
		if (ad != null) {
			ad.setAdmPassword(newPassword);
			ad.setCode(null);
			getAdmService().updateAdm(ad);
			request.setAttribute("mesg", "修改成功");
			request.getRequestDispatcher("/WEB-INF/return.jsp").forward(request, response);
		}else {
			request.setAttribute("mesg", "链接失效");
		}
		request.getRequestDispatcher("/WEB-INF/return.jsp").forward(request, response);
	}

}
