package com.zwy.domain;


public class Users {
	private String account;//账号
	private String password;//密码
	private String name;//姓名
	private String sex;//性别
	private String nationality;//民族
	private String profession;//职业
	private long tel;//电话
	private String address;//地址
	public Users(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Users [account=" + account + ", password=" + password + ", name=" + name + ", sex=" + sex
				+ ", nationality=" + nationality + ", profession=" + profession + ", tel=" + tel + ", address="
				+ address + "]";
	}
	
}
