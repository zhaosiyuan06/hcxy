package com.webTest.Bean;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="adm")
@Component
public class Adm {
		private  int aid;
		private String admName;
		private String admPassword;
		private String admMoble;
		private String admEmail;
		/**
		 * 用户状态
		 */
		public int state=0;
		
		/**
		 * 激活码
		 */
		public String code;
		@Id
		@GeneratedValue
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
		
		public Adm(int aid, String admName, String admPassword,
				String admMoble, String admEmail) {
			super();
			this.aid = aid;
			this.admName = admName;
			this.admPassword = admPassword;
			this.admMoble = admMoble;
			this.admEmail = admEmail;
		}
		public Adm() {
			super();
			// TODO Auto-generated constructor stub
		}
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
		@Override
		public String toString() {
			return "Adm [aid=" + aid + ", admName=" + admName
					+ ", admPassword=" + admPassword + ", admMoble=" + admMoble
					+ ", admEmail=" + admEmail + ", state=" + state + ", code="
					+ code + "]";
		}

}
