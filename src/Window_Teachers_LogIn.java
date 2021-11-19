import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Window_Teachers_LogIn implements ActionListener {
	
	private JFrame frame;
	
	private JLabel welcomeL;
	private JLabel headingL;
	private JLabel initialL;
	private JLabel passwordL;
	private JLabel image;
	private JLabel hint;
	
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem exit;
	private JMenuItem home;
	
	private JTextField initial;
	private JPasswordField password;
	
	private JButton log_inB;
	private JButton forgot_passwordB;
	
	public Window_Teachers_LogIn() throws Exception{
		frame = new JFrame();
		frame.setLayout(null);
		frame.setBounds(100, 100, 745, 527);
		frame.setTitle("Teachers Log In");
		frame.getContentPane().setBackground(Color.WHITE);
		
		
		welcomeL= new JLabel("Welcome");
		welcomeL.setFont(new Font("Times New Roman", Font.BOLD, 22));
		welcomeL.setBounds(304, 11, 159, 70);
		
		headingL=new JLabel("Please Enter Initial and Password:");
		headingL.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		headingL.setBounds(42, 84, 320, 64);
		
		initialL= new JLabel("Enter Initial: ");
		initialL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		initialL.setBounds(62, 183, 117, 39);
		
		passwordL= new JLabel("Enter Passwords: ");
		passwordL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordL.setBounds(62, 256, 136, 32);
		
		hint = new JLabel("<html>Please Contact<br>Registers Office</html>");
		hint.setBounds(494,312,186,46);
		hint.setForeground(Color.RED);
		
		image = new JLabel("");
		File im = new File("image.jpg");
		String image_path = im.getAbsolutePath();
		image.setIcon(new ImageIcon(image_path));
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(494, 117, 216, 184);
		
		
		initial= new JTextField();
		initial.setBounds(263, 194, 221, 20);
		
		password= new JPasswordField();
		password.setBounds(263, 268, 221, 20);
		
		log_inB= new JButton("Log In");
		log_inB.addActionListener(this);
		log_inB.setBounds(315, 390, 148, 39);
		
		forgot_passwordB = new JButton("Forgot Password");
		forgot_passwordB.addActionListener(this);
		forgot_passwordB.setBounds(347, 291, 137, 20);
		
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
		frame.add(initialL);
		frame.add(passwordL);
		frame.add(initial);
		frame.add(password);
		frame.add(log_inB);
		frame.add(image);
		frame.add(hint);
		frame.add(forgot_passwordB);
		
		
		
		frame.setVisible(true);
		hint.setVisible(false);
		frame.getRootPane().setDefaultButton(log_inB);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==log_inB){
			String ini = initial.getText();
			char[] take_pass = password.getPassword();
			String pass= new String(take_pass);
			try {
				File f = new File("teacher-password.txt");
				Scanner sc= new Scanner(f);
				LogIn[] check = new LogIn[4];
				for(int i=0;i<4;i++){
					String initial= sc.next();
					String password= sc.next();
					check[i]=new LogIn(initial,password);
				}
				sc.close();
				int a=0,b=0;
				for(int y=0;y<4;y++){
					if(ini.equals(check[y].getIni())){
						a=1;
						if(pass.equals(check[y].getPassword())){
							JOptionPane.showMessageDialog(frame,"You have succesfully logged in!");
							b=1;
							break;
							
						}
						
					}
				}
				if(a==0){
					JOptionPane.showMessageDialog(frame,"Please Enter Initial again");
				}
				else if(b==0){
					JOptionPane.showMessageDialog(frame,"Please Enter Password again");
				}
				if(a!=0&&b!=0){
					frame.setVisible(false);
					new Window_Teachers_Course(ini);
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==forgot_passwordB){
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
