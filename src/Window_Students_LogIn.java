import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Window_Students_LogIn implements ActionListener {
	
	private JFrame frame;
	
	private JLabel welcomeL;
	private JLabel headingL;
	private JLabel idL;
	private JLabel passwordL;
	private JLabel image;
	private JLabel hint;
	
	private JTextField id;
	private JPasswordField password;
	
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem exit;
	private JMenuItem home;
	
	private JButton login_button;
	private JButton forgot_password_button;

	
	public Window_Students_LogIn(){
		
		frame = new JFrame();
		frame.setTitle("Students Login Screen");
		frame.setLayout(null);
		frame.setBounds(100, 100, 745, 538);
		frame.getContentPane().setBackground(Color.WHITE);

		welcomeL = new JLabel("Welcome");
		welcomeL.setBounds(323, 46, 114, 49);
		welcomeL.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeL.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		headingL = new JLabel("Please Enter ID and Password:");
		headingL.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		headingL.setBounds(68, 132, 289, 14);
		
		idL = new JLabel("Enter ID:");
		idL.setBounds(92, 190, 61, 14);
		
		passwordL = new JLabel("Enter Password:");
		passwordL.setBounds(92, 251, 102, 14);
		
		hint = new JLabel("<html>Please Contact<br>Registers Office</html>");
		hint.setBounds(489,284,186,46);
		hint.setForeground(Color.RED);
		
		image = new JLabel("");
		File im = new File("image.jpg");
		String image_path = im.getAbsolutePath();
		image.setIcon(new ImageIcon(image_path));
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(482, 100, 216, 184);
		
		
		id = new JTextField();
		id.setBounds(249, 187, 223, 20);
		
		password = new JPasswordField();
		password.setBounds(249, 248, 223, 20);
		
		login_button = new JButton("Login");
		login_button.addActionListener(this);
		login_button.setBounds(290, 343, 167, 35);
		
		forgot_password_button = new JButton("Forgot Password");
		forgot_password_button.addActionListener(this);
		forgot_password_button.setBounds(335, 277, 137, 20);
		
		
		menu = new JMenuBar();
		file = new JMenu("File");
		home = new JMenuItem("Home");
		home.addActionListener(this);
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		
		file.add(home);
		file.add(exit);
		menu.add(file);
		frame.setJMenuBar(menu);
		
		
		frame.add(welcomeL);
		frame.add(headingL);
		frame.add(idL);
		frame.add(passwordL);
		frame.add(id);
		frame.add(password);
		frame.add(image);
		frame.add(hint);
		frame.add(login_button);
		frame.add(forgot_password_button);
		
		
		frame.setVisible(true);
		hint.setVisible(false);
		frame.getRootPane().setDefaultButton(login_button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login_button){
			String Id = id.getText();
			char[] Take_Password = password.getPassword();
			String Password= new String(Take_Password);
			try {
				File f = new File("student-password.txt");
				Scanner input = new Scanner(f);
				Log_in[] check_pass = new Log_in[25];
				
				for(int i=0; i < 25 ;i++){
					String id = input.next();
					String password = input.next();
					check_pass[i] = new Log_in(id,password);
				}
				input.close();
				int flag1=0,flag2=0;
				for(int i=0; i < 25 ;i++){
					if(Id.equals(check_pass[i].getId())){
						flag1 = 1;
						if(Password.equals(check_pass[i].getPassword())){
							JOptionPane.showMessageDialog(frame,"You have successfully logged in!");
							flag2 = 1;
							break;
						}
						
					}
				}
				if(flag1==0){
					JOptionPane.showMessageDialog(frame,"Wrong ID!!\r\n Please Enter ID again.");
				}
				else if(flag2==0){
					JOptionPane.showMessageDialog(frame, "Wrong Password!!\r\n Please Enter Password again");
				}
				if(flag1!=0 && flag2!=0){
					frame.setVisible(false);
					new Window_Student_Grade(Id);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		else if(e.getSource()==forgot_password_button){
			hint.setVisible(true);
		}
		else if(e.getSource() == exit){
			System.exit(0);
		}
		else if(e.getSource() == home){
			frame.setVisible(false);
			new Window_Main();
		}
	}

}
