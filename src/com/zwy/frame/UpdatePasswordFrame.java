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
import javax.swing.JPasswordField;

import com.zwy.dao.UsersDao;
import com.zwy.domain.Users;

public class UpdatePasswordFrame extends JFrame{
	UsersDao userDao = new UsersDao();
	
	TextField originMima = new TextField(20);
	JPasswordField mima = new JPasswordField(15);
	JPasswordField mimaAgain = new JPasswordField(15);
	JFrame f = new JFrame("修改密码");
	private String gobalAccount = "";
	
	public static void main(String[] args) {
		UpdatePasswordFrame d = new UpdatePasswordFrame("zpy2");
	}
	
	public UpdatePasswordFrame(String account) {
		gobalAccount = account;
		f.setBounds(450, 200, 400, 300);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(null);
		JLabel label2 = new JLabel("原密码： ");
		JLabel label3 = new JLabel("新密码： ");
		JLabel label4 = new JLabel("确认密码：");
		label2.setFont(new Font("Serif", Font.BOLD, 15));
		label3.setFont(new Font("Serif", Font.BOLD, 15));
		label4.setFont(new Font("Serif", Font.BOLD, 15));
		JButton button1 = new JButton(" 修改 ");
		JButton button2 = new JButton(" 重置 ");
		
		BHandler h = new BHandler();
		button1.addActionListener(h);
		button2.addActionListener(h);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p1.setBounds(0, 60, 380, 30);
		p1.add(label2);
		p1.add(originMima);
		p2.setBounds(0, 90, 380, 30);
		p2.add(label3);
		p2.add(mima);
		p3.setBounds(-5, 120, 380, 30);
		p3.add(label4);
		p3.add(mimaAgain);
		p4.setBounds(0, 160, 420, 40);
		p4.add(button1);
		p4.add(button2);

		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.setVisible(true);
	}


	public class BHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == " 修改 ") {
				if(originMima.getText().equals("")||mima.getText().equals("")||mimaAgain.getText().equals("")) {
					JOptionPane.showMessageDialog(UpdatePasswordFrame.this, " 原密码或新密码不能为空！ ");
				}else if(!mima.getText().equals(mimaAgain.getText())){
					JOptionPane.showMessageDialog(UpdatePasswordFrame.this, " 两次密码输入不一致！ ");
				}else if(mima.getText().length()<3||mima.getText().length()>16) {
					JOptionPane.showMessageDialog(UpdatePasswordFrame.this, " 密码必须大于等于3位并小于等于15位！ ");
				}else if(originMima.getText().equals(mima.getText())){
					JOptionPane.showMessageDialog(UpdatePasswordFrame.this, " 原密码与新密码一致！ ");
				}else {
					// 先校验下原密码是否正确
					Users checkUsers = userDao.checkUsers(gobalAccount, originMima.getText());
					if(checkUsers==null) {
						JOptionPane.showMessageDialog(UpdatePasswordFrame.this, " 原密码不正确！ ");
						
					}else {
						boolean flag = userDao.updatePassword(gobalAccount, mima.getText());
						if(flag) {
							JOptionPane.showMessageDialog(UpdatePasswordFrame.this, " 密码修改成功！ ");
						}else {
							JOptionPane.showMessageDialog(UpdatePasswordFrame.this, " 密码修改失败！ ");
						}
					}
					
					
				}
				
			}else if(event.getActionCommand() == " 重置 ") {
				originMima.getText();
				originMima.setText("");
				mima.getText();
				mima.setText("");
				mimaAgain.getText();
				mimaAgain.setText("");
			} else {
				dispose();
			}
		}
	}
}
