package com.webTest.Action;

import java.io.IOException;


import javax.annotation.Resource;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.webTest.Bean.Adm;
import com.webTest.Service.AdmService;


@Controller("/CheckServlet")
public class CheckServlet extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public static String code;
	
	public static String getCode() {
		return code;
	}

	public static void setCode(String code) {
		CheckServlet.code = code;
	}
	@Resource
	protected static AdmService admService; 

	public AdmService getAdmService() {
		return admService;
	}

	public void setAdmService(AdmService admService) {
		CheckServlet.admService = admService;
	}
	public static void check() throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			code = request.getParameter("code");
			Adm adm =admService.findAdmByCode(code);
			if (adm != null) {
				request.getRequestDispatcher("/WEB-INF/reset.html").forward(request, response);	
			}else {
				request.setAttribute("mesg", "链接失效");
				request.getRequestDispatcher("/WEB-INF/return.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
		
	
	}
	
	
	

}
