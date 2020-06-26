package com.zwy.frame;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.zwy.dao.UsersDao;
import com.zwy.domain.Users;
import com.zwy.util.TimeUtil;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PersonFrame extends JFrame {
	private UsersDao usersDao = new UsersDao();
	public static String loginname;
	private JPanel contentPane;
	private JTextField textAccount = new JTextField();
	private JTextField textPassword = new JTextField(15);
	private JTextField textName = new JTextField();
	private JTextField textProfession = new JTextField();
	private JTextField textTel = new JTextField();
	private JTextField textAddress = new JTextField();
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	ButtonGroup sexGroup =new ButtonGroup();
	
	public PersonFrame(){}
	
	
	public PersonFrame(Users users) {
		loginname= users.getName();
		if(loginname==null||loginname.equals("")) {
			setTitle("个人中心");
		}else {
			setTitle("个人中心"+"         hello: "+loginname);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		textAccount.setText(users.getAccount());
		textPassword.setText("*******");
		textName.setText(users.getName());
		textProfession.setText(users.getProfession());
		textAddress.setText(users.getAddress());
		Long tel = users.getTel();
		textTel.setText(tel.toString());
		
		//其他值暂未渲染
		
		JButton btnNewButton = new JButton("通讯录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhoneFrame phone = new PhoneFrame(textAccount.getText());
			}
		});
		btnNewButton.setBounds(34, 316, 97, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_4 = new JButton("修改个人信息");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Users users = new Users();
				users.setAccount(textAccount.getText());
				users.setName(textName.getText());
				
				users.setProfession(textProfession.getText());
				if(textTel.getText().length()==0) {
					users.setTel(0L);
				}else {
					users.setTel(Long.valueOf(textTel.getText()));
				}
				String sex = "";
				if(rdbtnNewRadioButton.isSelected()) {
					sex="男";
				}else if(rdbtnNewRadioButton_1.isSelected()) {
					sex="女";
				}
				users.setSex(sex);
				
				
				users.setAddress(textAddress.getText());
				boolean flag = usersDao.updateMessage(users);
				if(flag) {
					JOptionPane.showMessageDialog(PersonFrame.this, " 个人信息修改成功！ ");
				}else {
					JOptionPane.showMessageDialog(PersonFrame.this, " 个人信息修改成功！ ");
				}
			}
		});
		btnNewButton_4.setBounds(120, 266, 134, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("修改登录密码");
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdatePasswordFrame updatePasswordFrame = new UpdatePasswordFrame(textAccount.getText());
			}
		});
		btnNewButton_5.setBounds(451, 266, 134, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("账号:");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel.setBounds(34, 10, 80, 30);
		contentPane.add(lblNewLabel);
		
		textAccount.setFont(new Font("黑体", Font.PLAIN, 25));
		textAccount.setBounds(120, 10, 206, 30);
		contentPane.add(textAccount);
		textAccount.setColumns(10);
		textAccount.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("密码:");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(34, 45, 82, 30);
		contentPane.add(lblNewLabel_1);
		
		textPassword.setFont(new Font("黑体", Font.PLAIN, 25));
		textPassword.setBounds(120, 45, 206, 30);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		textPassword.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("姓名:");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(34, 80, 82, 34);
		contentPane.add(lblNewLabel_2);
		
		textName.setFont(new Font("黑体", Font.PLAIN, 25));
		textName.setBounds(120, 80, 206, 30);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("性别:");
		lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(34, 115, 82, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("职业:" );
		lblNewLabel_6.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(372, 45, 80, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("电话:");
		lblNewLabel_7.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(372, 80, 80, 30);
		contentPane.add(lblNewLabel_7);
		
		
		textProfession.setFont(new Font("黑体", Font.PLAIN, 25));
		textProfession.setColumns(10);
		textProfession.setBounds(451, 45, 206, 30);
		contentPane.add(textProfession);
		
		textTel.setFont(new Font("黑体", Font.PLAIN, 25));
		textTel.setColumns(10);
		textTel.setBounds(450, 80, 206, 30);
		contentPane.add(textTel);
		
		JLabel lblNewLabel_8 = new JLabel("地址:");
		lblNewLabel_8.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(34, 170, 80, 30);
		contentPane.add(lblNewLabel_8);
		
		textAddress.setFont(new Font("黑体", Font.PLAIN, 25));
		textAddress.setBounds(122, 170, 534, 60);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		if(users.getSex()!=null&&users.getSex().equals("男")){
			rdbtnNewRadioButton = new JRadioButton("男",true);
			rdbtnNewRadioButton.setFont(new Font("黑体", Font.PLAIN, 25));
			rdbtnNewRadioButton.setBounds(127, 115, 59, 30);
			contentPane.add(rdbtnNewRadioButton);
			
			rdbtnNewRadioButton_1 = new JRadioButton("女");
			rdbtnNewRadioButton_1.setFont(new Font("黑体", Font.PLAIN, 25));
			rdbtnNewRadioButton_1.setBounds(227, 116, 59, 30);
			contentPane.add(rdbtnNewRadioButton_1);
		}else if(users.getSex()!=null&&users.getSex().equals("女")) {
			rdbtnNewRadioButton = new JRadioButton("男");
			rdbtnNewRadioButton.setFont(new Font("黑体", Font.PLAIN, 25));
			rdbtnNewRadioButton.setBounds(127, 115, 59, 30);
			contentPane.add(rdbtnNewRadioButton);
			
			rdbtnNewRadioButton_1 = new JRadioButton("女",true);
			rdbtnNewRadioButton_1.setFont(new Font("黑体", Font.PLAIN, 25));
			rdbtnNewRadioButton_1.setBounds(227, 116, 59, 30);
			contentPane.add(rdbtnNewRadioButton_1);
		}else {
			rdbtnNewRadioButton = new JRadioButton("男");
			rdbtnNewRadioButton.setFont(new Font("黑体", Font.PLAIN, 25));
			rdbtnNewRadioButton.setBounds(127, 115, 59, 30);
			contentPane.add(rdbtnNewRadioButton);
			
			rdbtnNewRadioButton_1 = new JRadioButton("女");
			rdbtnNewRadioButton_1.setFont(new Font("黑体", Font.PLAIN, 25));
			rdbtnNewRadioButton_1.setBounds(227, 116, 59, 30);
			contentPane.add(rdbtnNewRadioButton_1);
		}
		
		
		sexGroup.add(rdbtnNewRadioButton);
		sexGroup.add(rdbtnNewRadioButton_1);
	}
}
