package com.zwy.frame;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.zwy.dao.PhoneDao;
import com.zwy.domain.Phone;
import com.zwy.util.JDBCUtil;

public class PhoneFrame extends Frame{
	private PhoneDao phoneDao = new PhoneDao();
	public static Object[][] data = new Object[30][5];
	JTable table;
	String[] lieming = { " 姓   名 ", " 电   话 ", " 工 作 地 点 ", " 城  市 ", " 分组 " };
	JFrame f = new JFrame(" 通讯录 ");
	private String gobalAccount = "";
	
	public PhoneFrame() {
		
	}
	
	public PhoneFrame(String account) {
		f.setBounds(400, 150, 600, 450);
		f.setDefaultCloseOperation(2);
		f.setLayout(null);
		table = new JTable(data, lieming);
		table.setEnabled(false); // 表格不可编辑
		JButton button4_0 = new JButton(" 刷新 ");
		JButton button4_1 = new JButton(" 返回主页 ");
		JButton button4_2 = new JButton(" 添加 ");
		JButton button4_3 = new JButton(" 删除 ");
		JButton button4_4 = new JButton(" 修改 ");
		
		BHandler h = new BHandler();
		button4_0.addActionListener(h);
		button4_1.addActionListener(h);
		button4_2.addActionListener(h);
		button4_3.addActionListener(h);
		button4_4.addActionListener(h);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setBounds(0, 0, 600, 40);
		p1.add(button4_2);
		p1.add(button4_4);		
		p1.add(button4_3);
		p1.add(button4_0);
		p1.add(button4_1);
		p2.setBounds(0, 44, 600, 410);
		p2.add(new JScrollPane(table));
		f.add(p1);
		f.add(p2);

		int h1 = 0, l = 0;
		
		gobalAccount = account;
		List<Phone> list = phoneDao.getPhoneList(account);
		for (Phone phone : list) {
			data[h1][l++] = phone.getName();
			data[h1][l++] = phone.getTel();
			data[h1][l++] = phone.getWorkplace();
			data[h1][l++] = phone.getCity();
			data[h1][l++] = phone.getRemarks();
			h1++;
			l = 0;
		}

		table = new JTable(data, lieming);
		f.setVisible(true);
	}
	
	public class BHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == " 刷新 ") {
				// 清空数据
				for (int j=0;j<30;j++) {
					for (int i=0;i<5;i++) {
						data[j][i] = null;
					}
				}
				int h = 0, l = 0;
				List<Phone> list = phoneDao.getPhoneList(gobalAccount);
				for (Phone phone : list) {
					data[h][l++] = phone.getName();
					data[h][l++] = phone.getTel();
					data[h][l++] = phone.getWorkplace();
					data[h][l++] = phone.getCity();
					data[h][l++] = phone.getRemarks();
					h++;
					l = 0;
				}
				table = new JTable(data, lieming);
				// 重新绘制
				f.repaint();
				f.setVisible(true);
				
			}else if(event.getActionCommand() == " 添加 ") {
				AddPhoneFrame addPhoneFrame = new AddPhoneFrame(gobalAccount);
			}else if(event.getActionCommand() == " 修改 ") {
				UpdatePhoneFrame updatePhoneFrame = new UpdatePhoneFrame(gobalAccount);
			}else if(event.getActionCommand() == " 删除 ") {
				DeletePhoneFrame deletePhoneFrame = new DeletePhoneFrame(gobalAccount);
			} else {
				JDBCUtil.closeConnection();
				f.dispose();
			}
		}
	}
}
