package com.zwy.frame;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.zwy.dao.PhoneDao;
import com.zwy.domain.Phone;

public class DeletePhoneFrame extends JFrame{
	JFrame f = new JFrame(" 删除通讯信息 ");
	private PhoneDao phoneDao = new PhoneDao();
	private String gobalAccount = "";
	TextField telText = new TextField(20);
	
	
	public DeletePhoneFrame(String account) {
		gobalAccount = account;
		JLabel label1_0,label1_2;
		JPanel p1_0,p1_2, p1_6;

		f.setBounds(400, 150, 600, 450);
		// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(null);

		JButton button1_0 = new JButton(" 删除 ");
		JButton button1_1 = new JButton(" 取消 ");
		BHandler h = new BHandler();
		button1_0.addActionListener(h);
		button1_1.addActionListener(h);

		label1_0 = new JLabel(" 删除通讯信息 ", SwingConstants.CENTER);
		
		label1_2 = new JLabel(" 电   话： ", SwingConstants.CENTER);
		label1_2.setFont(new Font("Serif", Font.BOLD, 15));

		p1_0 = new JPanel();
		p1_0.setBounds(0, 0, 600, 80);
		p1_0.add(label1_0);


		p1_2 = new JPanel();
		p1_2.setBounds(0, 130, 550, 50);
		p1_2.add(label1_2);
		p1_2.add(telText);
		
		
		
		
		
		p1_6 = new JPanel();
		p1_6.setBounds(0, 380, 600, 50);
		p1_6.add(button1_0);
		p1_6.add(button1_1);
		
		f.add(p1_0);
		f.add(p1_2);
		f.add(p1_6);
		f.setVisible(true);
		
	}
	
	private class BHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (event.getActionCommand() == " 删除 ") {
				if(telText.getText()==null||telText.getText().equals("")) {
					JOptionPane.showMessageDialog(DeletePhoneFrame.this, " 请输入电话号码！ ");
				}else {
					String tel = telText.getText();
					boolean flag = phoneDao.deletePhone(gobalAccount, tel);
					
					if (flag) {
						JOptionPane.showMessageDialog(DeletePhoneFrame.this, " 删除成功！ ");
					}else {
						JOptionPane.showMessageDialog(DeletePhoneFrame.this, " 删除失败,请确认该电话号码是否存在于通讯录！ ");
					}
				}
				
			} else {
				f.dispose();
			}

		}
	}

}
