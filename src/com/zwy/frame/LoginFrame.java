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
import com.zwy.util.JDBCUtil;

public class LoginFrame extends JFrame {
		
		UsersDao userDao = new UsersDao();
		
		TextField name = new TextField(20);
		JPasswordField mima = new JPasswordField(15);
		JFrame f = new JFrame("登录 ");
		
		public LoginFrame() {
			
			f.setBounds(450, 200, 400, 300);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setResizable(false);
			f.setLayout(null);
			JLabel label2 = new JLabel("  账   号： ");
			JLabel label3 = new JLabel("  密   码： ");
			JLabel label4 = new JLabel("没有账号?点此注册");
			label2.setFont(new Font("Serif", Font.BOLD, 15));
			label3.setFont(new Font("Serif", Font.BOLD, 15));
			label4.setFont(new Font("Serif", Font.BOLD, 13));
			JButton button1 = new JButton(" 登录 ");
			JButton button2 = new JButton(" 取消 ");
			JButton button3 = new JButton(" 注册账号 ");
			
			BHandler h = new BHandler();
			button1.addActionListener(h);
			button2.addActionListener(h);
			button3.addActionListener(h);
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			JPanel p5 = new JPanel();
			p1.setBounds(0, 60, 380, 30);
			p1.add(label2);
			p1.add(name);
			p2.setBounds(0, 90, 380, 30);
			p2.add(label3);
			p2.add(mima);
			p3.setBounds(0, 150, 420, 40);
			p3.add(button1);
			p3.add(button2);
			p4.setBounds(0, 195, 630, 40);
			p4.add(label4);
			p5.setBounds(0, 230, 650, 40);
			p5.add(button3);

			f.add(p1);
			f.add(p2);
			f.add(p3);
			f.add(p4);
			f.add(p5);
			f.setVisible(true);
		}

		public static void main(String[] args) {
			LoginFrame a = new LoginFrame();
		}

		public class BHandler implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (event.getActionCommand() == " 登录 ") {
					if (name.getText().equals("") || mima.getText().equals("")) {
						JOptionPane.showMessageDialog(LoginFrame.this, " 账号或密码不能为空！ ");
					}else {
						Users users = userDao.checkUsers(name.getText(), mima.getText());
						if(users==null) {
							JOptionPane.showMessageDialog(LoginFrame.this, " 账号或密码不正确！ ");
						}else {
							System.out.println("前往主页面");
							PersonFrame main = new PersonFrame(users);
							main.setVisible(true);
							f.setVisible(false);
						}
					} 
				}else if(event.getActionCommand() == " 注册账号 ") {
					RegisterFrame register = new RegisterFrame();
				} else {
					JDBCUtil.closeConnection();
					f.dispose();
				}
			}
		}
}
