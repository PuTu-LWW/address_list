package com.zwy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zwy.domain.Phone;
import com.zwy.domain.Users;
import com.zwy.util.JDBCUtil;

/**
 * 通讯录的增删改查操作
 */
public class PhoneDao {
	
	/**
	 * 查询该账号下的所有通讯录
	 * @param account 账号
	 * @return 通讯录集合
	 */
	public List<Phone> getPhoneList(String account){
		List<Phone> list = new ArrayList<Phone>();
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from phone where account='"+account+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Phone phone = new Phone();
				phone.setAccount(account);
				phone.setName(rs.getString("name"));
				phone.setTel(rs.getLong("tel"));
				phone.setCity(rs.getString("city"));
				phone.setWorkplace(rs.getString("workplace"));
				phone.setRemarks(rs.getString("remarks"));
				list.add(phone);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据账号 和 电话号码查询指定的通讯信息
	 * @param account 账号
	 * @param tel 电话号码
	 * @return 通讯信息
	 */
	public Phone getPhone(String account,String tel) {
		Phone phone = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from phone where account='"+account+"' and tel='"+tel+"'";
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				phone = new Phone();
				phone.setAccount(account);
				phone.setName(rs.getString("name"));
				phone.setTel(rs.getLong("tel"));
				phone.setCity(rs.getString("city"));
				phone.setWorkplace(rs.getString("workplace"));
				phone.setRemarks(rs.getString("remarks"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return phone;
	}
	
	/**
	 * 删除该账号下 名称为X的通讯信息
	 * @param account 账号
	 * @param tel 电话号码
	 * @return 删除成功与否
	 */
	public boolean deletePhone(String account,String tel){
		boolean flag = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement statement = conn.createStatement();
			String sql = "delete from phone where account='"+account+"' and tel="+tel;
			int count = statement.executeUpdate(sql);
//			conn.commit();
			if(count>0) {
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 添加通讯录信息
	 * @param phone 通讯录信息
	 * @return 添加成功与否
	 */
	public boolean addPhone(Phone phone) {
		boolean flag = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "insert into phone values(?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, phone.getAccount());
			pstm.setObject(2, phone.getTel());
			pstm.setString(3, phone.getName());
			pstm.setString(4, phone.getWorkplace());
			pstm.setString(5, phone.getCity());
			pstm.setString(6, phone.getRemarks());
			int count = pstm.executeUpdate();
//			conn.commit();
			if(count>0) {
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 修改通讯录信息
	 * @param phone 通讯录信息
	 * @return 修改成功与否
	 */
	public boolean updatePhone(Phone phone) {
		boolean flag = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "update  phone set name=?,workplace=?,city=?,remarks=? where account=? and tel=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, phone.getName());
			pstm.setString(2, phone.getWorkplace());
			pstm.setString(3, phone.getCity());
			pstm.setString(4, phone.getRemarks());
			pstm.setString(5, phone.getAccount());
			pstm.setLong(6, phone.getTel());
			int count = pstm.executeUpdate();
//			conn.commit();
			if(count>0) {
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	public static void main(String[] args) {
		PhoneDao dao = new PhoneDao();
//		System.out.println(dao.getPhoneList("189074133"));
//		System.out.println(dao.deletePhone("zpy2", "123456789"));
//		Phone phone = new Phone();
//		phone.setAccount("zpy2");
//		phone.setName("老黑");
//		phone.setCity("城市");
//		phone.setWorkplace("工作地点");
//		phone.setTel(123456789);
//		phone.setRemarks("备注~");
		
//		System.out.println(dao.addPhone(phone));
		System.out.println(dao.getPhone("zpy2", "123456"));
	}
}
