package com.webTest.Action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.webTest.Bean.Adm;
import com.webTest.Service.AdmService;
import com.webTest.tools.MailUtils;
import com.webTest.tools.Md5Test;


@Controller("/FindPasswordServlet")
public class FindPasswordServlet extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private AdmService admService;  
   
	public AdmService getAdmService() {
		return admService;
	}

	public void setAdmService(AdmService admService) {
		this.admService = admService;
	}

	public void FindPassword() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String email = request.getParameter("admEmail");
			String code = Md5Test.ccMD5(email)+ Md5Test.getUUID();
			Adm ad=admService.findEmail(email);
			if (null!=ad) {
				if (ad.getState()!= 0) {
					ad.setCode(code);
					admService.updateAdm(ad);
					MailUtils.sendcheckMail(ad.getAdmEmail(), ad.getCode(),"来自华诚兴业的邮件啊");
					request.setAttribute("mesg", "请前往邮箱验证！");
					request.getRequestDispatcher("/WEB-INF/return.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "请激活邮箱");
					request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "邮箱不存在");
				request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
