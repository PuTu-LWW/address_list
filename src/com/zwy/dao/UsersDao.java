package com.zwy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zwy.domain.Users;
import com.zwy.util.JDBCUtil;

/**
 * 用户的增删改查操作
 */
public class UsersDao {
	
	/**
	 * 登录校验
	 * @param account 账号
	 * @param password 密码
	 * @return 用户信息
	 */
	public Users checkUsers(String account,String password) {
		Users users = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from users where account='"+account+"' and password='"+password+"'";
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				users = new Users();
				users.setAccount(account);
				users.setPassword(password);
				users.setAddress(rs.getString("ADDRESS"));
				users.setName(rs.getString("NAME"));
				users.setNationality(rs.getString("NATIONALITY"));
				users.setSex(rs.getString("SEX"));
				users.setProfession(rs.getString("PROFESSION"));
				users.setTel(rs.getLong("TEL"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	/**
	 * 用户注册
	 * @param account 账号
	 * @param password 密码
	 * @return 注册成功与否
	 */
	public boolean registerUser(String account,String password) {
		boolean flag = false;
		// 先校验账号是否存在
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from users where account='"+account+"'";
			ResultSet rs = statement.executeQuery(sql);
			// 不存在则给予注册
			if(!rs.next()) {
				String registerSql = "insert into users(account,password) values('"+account+"','"+password+"')";
				int count = statement.executeUpdate(registerSql);
//				conn.commit();
				if(count==1) {
					flag = true;
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 修改登录密码
	 * @param account 账号
	 * @param password 密码
	 * @return 修改成功与否
	 */
	public boolean updatePassword(String account,String password) {
		boolean flag = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement statement = conn.createStatement();
			String sql = "update users set password='"+password+"' where account='"+account+"'";
			int count = statement.executeUpdate(sql);
//			conn.commit();
			if(count==1) {
				flag = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 修改用户个人信息
	 * @param user 用户个人信息
	 * @return 成功与否
	 */
	public boolean updateMessage(Users user) {
		boolean flag = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "update users set name=?,sex=?,address=?,nationality=?,profession=?,tel=? where account=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setString(2, user.getSex());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getNationality());
			statement.setString(5, user.getProfession());
			statement.setLong(  6, user.getTel());
			statement.setString(7, user.getAccount());
			int count = statement.executeUpdate();
			// 提交事务
//			conn.commit();
			if(count==1) {
				flag = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static void main(String[] args) {
		UsersDao dao = new UsersDao();
//		Users users = dao.checkUsers("zpy1", "porty");
//		System.out.println(users);
		
//		boolean registerUser = dao.registerUser("zpy1", "porty");
//		System.out.println(registerUser);
		
		Users users = new Users();
		users.setAccount("zpy1");
		users.setName("老辉");
		users.setSex("女");
		boolean updateMessage = dao.updateMessage(users);
		System.out.println(updateMessage);
	}
}
