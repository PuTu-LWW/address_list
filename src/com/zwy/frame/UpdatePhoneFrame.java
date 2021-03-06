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

public class UpdatePhoneFrame extends JFrame{
	JFrame f = new JFrame(" 修改通讯信息 ");
	private PhoneDao phoneDao = new PhoneDao();
	private String gobalAccount = "";
	TextField telText = new TextField(20);
	TextField nameText = new TextField(20);
	TextField workText = new TextField(20);
	TextField cityText = new TextField(20);
	TextField remarksText = new TextField(20);
	
	
	public UpdatePhoneFrame(String account) {
		gobalAccount = account;
		JLabel label1_0, label1_1, label1_2, label1_3, label1_4, label1_5;
		JPanel p1, p2, p3, p4, p1_0, p1_1, p1_2, p1_3, p1_4, p1_5, p1_6, p1_7;

		f.setBounds(400, 150, 600, 450);
		// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(null);
		
		JButton button1_0 = new JButton(" 修改 ");
		JButton button1_1 = new JButton(" 取消 ");
		JButton button1_2 = new JButton(" 查询 ");
		BHandler h = new BHandler();
		button1_0.addActionListener(h);
		button1_1.addActionListener(h);
		button1_2.addActionListener(h);

		label1_0 = new JLabel(" 修改通讯信息 ", SwingConstants.CENTER);
		label1_0.setFont(new Font("Serif", Font.BOLD, 25));
		
		label1_2 = new JLabel(" 电   话： ", SwingConstants.CENTER);
		label1_2.setFont(new Font("Serif", Font.BOLD, 15));
		
		label1_1 = new JLabel(" 姓   名： ", SwingConstants.CENTER);
		label1_1.setFont(new Font("Serif", Font.BOLD, 15));
		
		label1_3 = new JLabel(" 工作地点： ", SwingConstants.CENTER);
		label1_3.setFont(new Font("Serif", Font.BOLD, 15));
		
		label1_4 = new JLabel(" 城   市： ", SwingConstants.CENTER);
		label1_4.setFont(new Font("Serif", Font.BOLD, 15));
		
		label1_5 = new JLabel(" 分组： ", SwingConstants.CENTER);
		label1_5.setFont(new Font("Serif", Font.BOLD, 15));

		p1_0 = new JPanel();
		p1_0.setBounds(0, 0, 600, 80);
		p1_0.add(label1_0);

		p1_2 = new JPanel();
		p1_2.setBounds(36, 80, 550, 50);
		p1_2.add(label1_2);
		p1_2.add(telText);
		p1_2.add(button1_2);
		
		p1_1 = new JPanel();
		p1_1.setBounds(0, 130, 550, 50);
		p1_1.add(label1_1);
		p1_1.add(nameText);

		
		p1_3 = new JPanel();
		p1_3.setBounds(-10, 180, 550, 50);
		p1_3.add(label1_3);
		p1_3.add(workText);
		
		p1_4 = new JPanel();
		p1_4.setBounds(0, 230, 550, 50);
		p1_4.add(label1_4);
		p1_4.add(cityText);
		
		p1_5 = new JPanel();
		p1_5.setBounds(0, 280, 550, 50);
		p1_5.add(label1_5);
		p1_5.add(remarksText);
		
		
		p1_6 = new JPanel();
		p1_6.setBounds(0, 380, 600, 50);
		p1_6.add(button1_0);
		p1_6.add(button1_1);
		
		f.add(p1_0);
		f.add(p1_1);
		f.add(p1_2);
		f.add(p1_3);
		f.add(p1_4);
		f.add(p1_5);
		f.add(p1_6);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		UpdatePhoneFrame updatePhoneFrame = new UpdatePhoneFrame("zpy2");
	}
	
	private class BHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (event.getActionCommand() == " 修改 ") {
				if(nameText.getText()==null||nameText.getText().equals("")){
					JOptionPane.showMessageDialog(UpdatePhoneFrame.this, " 请输入姓名！ ");
				}else if(telText.getText()==null||telText.getText().equals("")) {
					JOptionPane.showMessageDialog(UpdatePhoneFrame.this, " 请输入电话号码！ ");
				}else {
					Phone phone = new Phone();
					phone.setAccount(gobalAccount);
					String tel = telText.getText();
					if(tel.length()>0) {
						phone.setTel(Long.valueOf(tel));
					}else {
						phone.setTel(0L);
					}
					phone.setName(nameText.getText());
					phone.setWorkplace(workText.getText());
					phone.setCity(cityText.getText());
					phone.setRemarks(remarksText.getText());
					boolean flag = phoneDao.updatePhone(phone);
					
					if (flag) {
						JOptionPane.showMessageDialog(UpdatePhoneFrame.this, " 修改成功！ ");
					}else {
						JOptionPane.showMessageDialog(UpdatePhoneFrame.this, " 修改失败,请重试！ ");
					}
				}
				
			}else if(event.getActionCommand() == " 查询 ") {
				if(telText.getText()==null||telText.getText().length()==0) {
					JOptionPane.showMessageDialog(UpdatePhoneFrame.this, " 请输入电话号码后再点击查询！ ");
				}else {
					Phone phone = phoneDao.getPhone(gobalAccount, telText.getText());
					if(phone==null) {
						JOptionPane.showMessageDialog(UpdatePhoneFrame.this, " 通讯录中没有此电话号码！ ");
					}else {
						nameText.setText(phone.getName());
						workText.setText(phone.getWorkplace());
						cityText.setText(phone.getCity());
						remarksText.setText(phone.getRemarks());
						telText.setEditable(false);
						repaint();
					}
				}
				
			} else {
				f.dispose();
			}

		}
	}

}
