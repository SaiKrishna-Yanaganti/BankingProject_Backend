package com.lti.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {

	
	    public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
		@Id
		private int adminId;
		private String adminPassword;
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getAdminPassword() {
			return adminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		@Override
		public String toString() {
			return "Admin [adminName=" + adminId + ", adminPassword=" + adminPassword + "]";
		}
		public Admin(int adminId, String adminPassword) {
			super();
			this.adminId = adminId;
			this.adminPassword = adminPassword;
		}
		@Override
		public int hashCode() {
			return Objects.hash(adminId, adminPassword);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Admin other = (Admin) obj;
			return adminId == other.adminId && Objects.equals(adminPassword, other.adminPassword);
		}
		
		
		
	}


