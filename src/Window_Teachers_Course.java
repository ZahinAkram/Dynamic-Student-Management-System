import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.*;
import java.util.*;
 
public class Window_Teachers_Course implements ActionListener {
	private JFrame frame;
	
	private JLabel welcomeL;
	private JLabel initialL;
	private JLabel initialL2;
	private JLabel headingL;
	private JLabel courseL;
	private JLabel selectL;
	private JLabel course_title[];
	
	private JButton select_course[];
	
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem logout;
	private JMenuItem home;
	
	public T_Courses glo_faculty[];
	
	String ini;
	
	
	
	public Window_Teachers_Course(String ini) throws FileNotFoundException{
		this.ini=ini;
		
		frame= new JFrame();
		frame.setTitle("Teachers");
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 774, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		welcomeL=new JLabel("Welcome");
		welcomeL.setBounds(339, 21, 108, 56);
		welcomeL.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		initialL=new JLabel("Initial: ");
		initialL.setBounds(35, 65, 55, 78);
		initialL.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		initialL2= new JLabel(ini);
		initialL2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		initialL2.setBounds(148, 90, 71, 29);
		
		headingL=new JLabel("Please Choose One of your Courses:");
		headingL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		headingL.setBounds(34, 130, 233, 56);
		
		courseL=new JLabel("Courses");
		courseL.setFont(new Font("Tahoma", Font.BOLD, 13));
		courseL.setBounds(41, 209, 108, 44);
		
		selectL=new JLabel("Select");
		selectL.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectL.setBounds(283, 209, 137, 44);
		
		menu = new JMenuBar();
		file = new JMenu("File");
		logout = new JMenuItem("Logout");
		logout.addActionListener(this);;
		
		
		file.add(logout);
		menu.add(file);
		frame.setJMenuBar(menu);
		
		frame.add(welcomeL);
		frame.add(headingL);
		frame.add(initialL);
		frame.add(initialL2);
		frame.add(courseL);
		frame.add(selectL);
		
		File f = new File("teacher-course.txt");
		Scanner sc=new Scanner(f);
		int x=0;
		T_Courses teachers[]= new T_Courses[7];
		
		while(sc.hasNext()){
			String initial =sc.next();
		    String course=sc.next();
			String section=sc.next();
			teachers[x]=new T_Courses(initial, course, section);
			x++;
		}
		
		sc.close();
		
		int num=0;
		
		for(int i=0;i<x;i++){
			if(ini.equals(teachers[i].getInitial())){
				num++;
			}
		}
			
			T_Courses faculty[]=new T_Courses[num];
			glo_faculty=new T_Courses[num];
			int y=0;
			
			for(int i=0;i<x;i++){
				if(ini.equals(teachers[i].getInitial())){
					faculty[y]=teachers[i];
					glo_faculty[y]=faculty[y];
					y++;
				}
			}
			
			
			
			course_title=new JLabel[num];
			select_course=new JButton[num];
			int y_course=263;
			int y_select=261;
			
			for(int i=0;i<num;i++){
				
				course_title[i]=new JLabel(faculty[i].getCourse()+"."+faculty[i].getSection());
				course_title[i].setFont(new Font("Tahoma", Font.PLAIN, 13));
				course_title[i].setBounds(41, y_course, 80, 38);
				frame.add(course_title[i]);
				y_course=y_course+63;
				
				select_course[i]=new JButton("Enter");
				frame.add(select_course[i]);
				select_course[i].addActionListener(this);
				select_course[i].setFont(new Font("Tahoma", Font.PLAIN, 13));
				select_course[i].setBounds(242, y_select, 137, 38);
				y_select=y_select+65;
			}
			frame.setVisible(true);
		}

	
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<select_course.length;i++){
			if(e.getSource()==select_course[i]){
				frame.setVisible(false);
				new Window_Teacher_Grade(glo_faculty[i].getInitial(), glo_faculty[i].getCourse(), glo_faculty[i].getSection());
				
			}
		}
		if(e.getSource() == logout){
			frame.setVisible(false);
			new Window_Main();
		}
		
	}

}
		
	
	


