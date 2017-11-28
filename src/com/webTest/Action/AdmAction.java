package com.webTest.Action;


import java.io.File;
import java.io.IOException;


import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






import org.apache.struts2.ServletActionContext;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.webTest.Bean.Adm;


import com.webTest.Service.AdmService;
import com.webTest.tools.Md5Test;


@Controller("/admAction")
public class AdmAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private  int aid;
	private String admName;
	private String admPassword;
	private String admMoble;
	private String admEmail;
	public int state=0;
	public String code;
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	@Resource
	private AdmService admService; 
	@Resource
	private Md5Test md5Test;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getAdmPassword() {
		return admPassword;
	}
	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}
	public String getAdmMoble() {
		return admMoble;
	}
	public void setAdmMoble(String admMoble) {
		this.admMoble = admMoble;
	}
	public String getAdmEmail() {
		return admEmail;
	}
	public void setAdmEmail(String admEmail) {
		this.admEmail = admEmail;
	}
	public AdmService getAdmService() {
		return admService;
	}
	public void setAdmService(AdmService admService) {
		this.admService = admService;
	}

	public Md5Test getMd5Test() {
		return md5Test;
	}
	public void setMd5Test(Md5Test md5Test) {
		this.md5Test = md5Test;
	}
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

//用户登录
	public String Login2() throws ServletException, IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		String emailin=request.getParameter("admEmail");
		String passin = request.getParameter("admPassword");
		md5Test = new Md5Test();
		passin = md5Test.toMD5(passin);
		Adm ad=admService.get(emailin,passin);
		if(ad==null){
			request.setAttribute("msg", "您输入的信息有误");
			request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
		}else if(ad.getState()==0) {
			request.setAttribute("msg", "请激活后登陆");
			request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
		}else {
			session.setAttribute("admName",ad.getAdmName());
			request.setAttribute("admName", ad.getAdmName());
//			request.getRequestDispatcher("index.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		return null;
	
	}
	

//用户注册
	public String Register() throws Exception,ServletException,IOException {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			try {
				Adm adm=new Adm();
				adm.setAdmName(admName);
				adm.setAdmEmail(admEmail);
				adm.setAdmMoble(admMoble);
				adm.setState(0);
				String code=Md5Test.getUUID()+Md5Test.getUUID();
				adm.setCode(code);
				String passin = request.getParameter("admPassword");
				md5Test = new Md5Test();
				passin = md5Test.toMD5(passin);
				adm.setAdmPassword(passin);
				Adm adm2=admService.findEmail(request.getParameter("admEmail"));
				if (null !=adm2 ) {
					if (adm2.getState()!= 0) {
						request.setAttribute("msg", "邮箱已经被注册");
						request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
					}else {
						request.setAttribute("msg", "您已注册了，请前往邮箱激活");
						request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
					}
				}else {
					if (admService.Register(adm)) {
						request.setAttribute("mesg", "您已经注册成功请前往邮箱激活！");
						request.getRequestDispatcher("/WEB-INF/return.jsp").forward(request, response);
					}else{
						return "register";
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;	
	}
	//查询用户表
	public String getAdmList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Adm> list =admService.getAdmlist();
		request.setAttribute("list", list);
		return "right";
	}
	public String  deleteAdm() {
		admService.get(aid);
		admService.deletAdm(aid);
		getAdmList();
		return "right";
	}
	
	

}
