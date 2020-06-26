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

public class RegisterFrame extends JFrame{
	UsersDao userDao = new UsersDao();
	
	TextField name = new TextField(20);
	JPasswordField mima = new JPasswordField(15);
	JPasswordField mimaAgain = new JPasswordField(15);
	JFrame f = new JFrame("注册账号 ");
	
	public static void main(String[] args) {
		RegisterFrame r = new RegisterFrame();
	}
	
	public RegisterFrame() {

		f.setBounds(450, 200, 400, 300);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(null);
		JLabel label2 = new JLabel("账   号： ");
		JLabel label3 = new JLabel("密   码： ");
		JLabel label4 = new JLabel("确认密码：");
		label2.setFont(new Font("Serif", Font.BOLD, 15));
		label3.setFont(new Font("Serif", Font.BOLD, 15));
		label4.setFont(new Font("Serif", Font.BOLD, 15));
		JButton button1 = new JButton(" 注册 ");
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
		p1.add(name);
		p2.setBounds(0, 90, 380, 30);
		p2.add(label3);
		p2.add(mima);
		p3.setBounds(-10, 120, 380, 30);
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
			if (event.getActionCommand() == " 注册 ") {
				if(name.getText().equals("")||mima.getText().equals("")||mimaAgain.getText().equals("")) {
					JOptionPane.showMessageDialog(RegisterFrame.this, " 账号或密码不能为空！ ");
				}else if(!mima.getText().equals(mimaAgain.getText())){
					JOptionPane.showMessageDialog(RegisterFrame.this, " 两次密码输入不一致！ ");
				}else {
					boolean flag = userDao.registerUser(name.getText(),mima.getText());
					if(flag) {
						JOptionPane.showMessageDialog(RegisterFrame.this, " 恭喜你,注册成功！请前往登录！ ");
					}else {
						JOptionPane.showMessageDialog(RegisterFrame.this, " 很抱歉,该账号已被注册！ ");
					}
				}
				
			}else if(event.getActionCommand() == " 重置 ") {
				name.getText();
				name.setText("");
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
