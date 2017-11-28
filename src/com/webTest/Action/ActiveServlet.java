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



@Controller("/ActiveServlet")
public class ActiveServlet extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private AdmService admService; 

	public AdmService getAdmService() {
		return admService;
	}
	public void setAdmService(AdmService admService) {
		this.admService = admService;
	}
	public void active()throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			String code = request.getParameter("code");
			// 调用业务层查询用户
		    Adm adm =admService.findAdmByCode(code);
			if (adm != null) {
				if (adm.getState()!=0) {
					request.setAttribute("msg","您已激活");
					request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
				}else{
					adm.setState(1);
					adm.setCode(null);
					admService.updateAdm(adm);
					request.setAttribute("mesg", "激活成功，欢迎开始使用！");
					request.getRequestDispatcher("/WEB-INF/return.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("mesg", "激活码不正确或您已激活");
				request.getRequestDispatcher("/WEB-INF/return.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	

}
