package com.webTest.tools;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtils {

	private static final String sendMailUserName = "15071525203@163.com";// 发送邮件的用户名(地址)
	private static final String sendMailPassword = "f743090652";// 密码
//	private static final String sendMailSmtpHostName = "wxl123456"; // SMTP主机地址
	

	/**
	 * 发送激活邮件
	 * 
	 * @param to
	 *            ：给谁发邮件
	 * @param code：激活码
	 * @param subject：邮件主题
	 * @throws Exception
	 */
	public static void sendMail(String to, String code, String subject) throws Exception {
		// 1.创建连接对象,连接到邮件服务器
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties arg0 = new Properties();
		// arg0.setProperty(key, value);//主机名 服务器地址
		// 初始化props
		// 通过邮箱地址解析出smtp服务器，对大多数邮箱都管用
		final String smtpHostName = "smtp." + sendMailUserName.split("@")[1];
		
		arg0.setProperty("mail.smtp.host", smtpHostName);
		arg0.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		arg0.setProperty("mail.smtp.socketFactory.fallback", "false");
		arg0.setProperty("mail.smtp.port", "465");
		arg0.setProperty("mail.smtp.socketFactory.port", "465");
		arg0.setProperty("mail.smtp.auth",  "true");
		
		Session session = Session.getInstance(arg0, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				// userName, password 发送邮箱的账号和密码
				return new PasswordAuthentication(sendMailUserName, sendMailPassword);
			}

		});

		// 2.创建邮件对象
		Message message = new MimeMessage(session);
		// 2.1设置发件人
//		message.setFrom(new InternetAddress(sendMailUserName));
		 //设置自定义发件人昵称    
        String nick="";    
        try {    
            nick=javax.mail.internet.MimeUtility.encodeText("华诚兴业");    
        } catch (UnsupportedEncodingException e) {    
            e.printStackTrace();    
        }     
        message.setFrom(new InternetAddress(nick+" <"+sendMailUserName+">"));    
		// 2.2设置收件人
		message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
		// 2.3设置主题
		message.setSubject(subject);
		// 2.4设置邮件的正文
		message.setContent(
				"<h3>来自华诚兴业的激活邮件，激活请点击以下链接，</h3><h3><a href='http://hcxyrjkf.cn/OfficialWebsite/ActiveServlet?code="
						+ code + "'>http://hcxyrjkf.cn/OfficialWebsite/ActiveServlet?code=" + code
						+ "</a></h3>",
				"text/html;charset=UTF-8");
		// 3.发送邮件
		
		Transport.send(message);

	}
	public static void sendcheckMail(String to, String code, String subject) throws Exception {
		// 1.创建连接对象,连接到邮件服务器
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties arg0 = new Properties();
		// arg0.setProperty(key, value);//主机名 服务器地址
		// 初始化props
		// 通过邮箱地址解析出smtp服务器，对大多数邮箱都管用
		final String smtpHostName = "smtp." + sendMailUserName.split("@")[1];
		
		arg0.setProperty("mail.smtp.host", smtpHostName);
		arg0.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		arg0.setProperty("mail.smtp.socketFactory.fallback", "false");
		arg0.setProperty("mail.smtp.port", "465");
		arg0.setProperty("mail.smtp.socketFactory.port", "465");
		arg0.setProperty("mail.smtp.auth",  "true");
		Session session = Session.getInstance(arg0, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				// userName, password 发送邮箱的账号和密码
				return new PasswordAuthentication(sendMailUserName, sendMailPassword);
			}

		});

		// 2.创建邮件对象
		Message message = new MimeMessage(session);
		// 2.1设置发件人
//		message.setFrom(new InternetAddress(sendMailUserName));
		 //设置自定义发件人昵称    
        String nick="";    
        try {    
            nick=javax.mail.internet.MimeUtility.encodeText("华诚兴业");    
        } catch (UnsupportedEncodingException e) {    
            e.printStackTrace();    
        }     
        message.setFrom(new InternetAddress(nick+" <"+sendMailUserName+">"));   
		// 2.2设置收件人
		message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
		// 2.3设置主题
		message.setSubject(subject);
		// 2.4设置邮件的正文
		message.setContent(
				"<h3>来自华诚兴业的邮件，请点击以下链接修改密码，</h3><h3><a href='http://hcxyrjkf.cn/OfficialWebsite/CheckServlet?code="
						+ code + "'>http://hcxyrjkf.cn/OfficialWebsite/CheckServlet?code=" + code
						+ "</a></h3>",
				"text/html;charset=UTF-8");
		// 3.发送邮件
		Transport.send(message);

	}
}
