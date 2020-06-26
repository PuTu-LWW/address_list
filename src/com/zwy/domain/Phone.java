package com.zwy.domain;


public class Phone {
		private String account;
		private long tel;
		private String name;
		private String workplace;
		private String city;
		private String remarks;
		public Phone() {
			// TODO Auto-generated constructor stub
		}
		public Phone(String account, long tel) {
			super();
			this.account = account;
			this.tel = tel;
		}
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public long getTel() {
			return tel;
		}
		public void setTel(long tel) {
			this.tel = tel;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getWorkplace() {
			return workplace;
		}
		public void setWorkplace(String workplace) {
			this.workplace = workplace;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		@Override
		public String toString() {
			return "phone [account=" + account + ", tel=" + tel + ", name=" + name + ", workplace=" + workplace + ", city="
					+ city + ", remarks=" + remarks + "]";
		}
		

}
