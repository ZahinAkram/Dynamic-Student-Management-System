import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Window_CGPA implements ActionListener{

	private JFrame frame;
	
	private JLabel headingL;
	private JLabel instructionL;
	private JLabel creditL;
	private JLabel cgpaL;
	
	private JComboBox creditCB;
	private JComboBox cgpaCB;
	
	private JButton submitB;
	private JButton cgpaB;
	
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem exit;
	private JMenuItem home;
	
	//Setting global variables
	public int i=0;
	public double multi=0.0,sum=0.0,result=0.0;
	CGPA student[];
	
	public Window_CGPA(){
		frame=new JFrame();
		frame.setBounds(100, 100, 800, 545);
		frame.setTitle("CGPA Calculator");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);
		
		headingL = new JLabel("CGPA Calculator");
		headingL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		headingL.setHorizontalAlignment(SwingConstants.CENTER);
		headingL.setBounds(209, 30, 344, 79);
		
		instructionL = new JLabel("<html>Please choose Credit and Respective CGPA. <br> Click on \"Submit\" to continue adding and on \"Get CGPA\" to get Result.</html>");
		instructionL.setBounds(71, 120, 581, 62);
		
		creditL = new JLabel("Credit");
		creditL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		creditL.setHorizontalAlignment(SwingConstants.CENTER);
		creditL.setBounds(177, 203, 166, 53);
		
		cgpaL = new JLabel("CGPA");
		cgpaL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cgpaL.setHorizontalAlignment(SwingConstants.CENTER);
		cgpaL.setBounds(447, 203, 150, 53);
		
		String[] crd={"1","3"};
		creditCB = new JComboBox(crd);
		creditCB.setBounds(224, 267, 91, 41);
		
		String[] grade={"4","3.7","3.3","3.0","2.7","2.3","2.0","1.70","1.3","1.0","0.0"};
		cgpaCB = new JComboBox(grade);
		cgpaCB.setBounds(482, 267, 91, 41);
		
		submitB = new JButton("Submit");
		submitB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		submitB.setBounds(224, 389, 91, 46);
		submitB.addActionListener(this);
		
		cgpaB = new JButton("Get CGPA");
		cgpaB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cgpaB.setBounds(482, 389, 91, 46);
		cgpaB.addActionListener(this);
		
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
		
		frame.add(headingL);
		frame.add(instructionL);
		frame.add(creditL);
		frame.add(cgpaL);
		frame.add(creditCB);
		frame.add(cgpaCB);
		frame.add(submitB);
		frame.add(cgpaB);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}


	public void actionPerformed(ActionEvent e) {
		student=new CGPA[99];
		
		if(e.getSource()==submitB){
			String s=(String) creditCB.getSelectedItem();
			double credit=Double.parseDouble(s);
			s=(String) cgpaCB.getSelectedItem();
			double cgpa=Double.parseDouble(s);
			student[i]=new CGPA(credit,cgpa);
			multi=multi+(student[i].getCgpa()*student[i].getCredit());
			sum=sum+student[i].getCredit();	
			i++;
		}
		
		else if(e.getSource()==cgpaB){
			result=multi/sum;
			result = Math.round( result * 100.0 ) / 100.0;
			multi=sum=0;
			JOptionPane.showMessageDialog(frame,"Your total CGPA is:  "+result);
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
