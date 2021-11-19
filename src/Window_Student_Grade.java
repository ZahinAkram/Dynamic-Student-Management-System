import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.*;
import java.util.*;
 
public class Window_Student_Grade implements ActionListener{
	
	private JFrame frame;
	
	private JLabel resultsL;
	private JLabel idL;
	private JLabel idL2;
	private JLabel courseL[];
	private JLabel grade[];
	
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem logout;
	
	
	public int count;

	String ID;
	Student_grade student[];
	Student_grade student_single[];
	
	public Window_Student_Grade(String ID) {
		
		this.ID=ID;
		
		frame = new JFrame();
		frame.setTitle(ID + "Results");
		frame.setLayout(null);
		frame.setBounds(100, 100, 657, 568);
		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setTitle(ID + " Grade");
		
		
		resultsL = new JLabel("Results");
		resultsL.setBounds(305, 49, 103, 14);
		resultsL.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		idL = new JLabel("ID");
		idL.setBounds(59, 105, 71, 51);
		
		idL2 = new JLabel(ID);
		idL2.setBounds(368, 105, 126, 51);
		
		
		frame.add(resultsL);
		frame.add(idL);
		frame.add(idL2);
		
		menu = new JMenuBar();
		file = new JMenu("File");
		logout = new JMenuItem("Logout");
		logout.addActionListener(this);
		
		
		file.add(logout);
		menu.add(file);
		frame.setJMenuBar(menu);
	
		int y_courseL= 217;
		int y_select_course=230;
		
				
		try {
			File f=new File("student-grade.txt");
			Scanner sc= new Scanner(f);
			int r=0;
			
			while(sc.hasNext()){
				String course_f=sc.next();
				String section_f=sc.next();
				String id_f=sc.next();
				String grade_f=sc.next();
				count++;
				if(ID.equals(id_f)){
					r++;
				}
			}
			sc.close();
			
			
			student=new Student_grade[count];
			student_single=new Student_grade[r];
			
			courseL=new JLabel[r];
			grade=new JLabel[r];
			
			File f2=new File("student-grade.txt");
			Scanner sc2=new Scanner(f2);
			int t=0;
			count=r;
			
			while(sc2.hasNext()){
				String course_f=sc2.next();
				String section_f=sc2.next();
				String id_f=sc2.next();
				String grade_f=sc2.next();
				if(ID.equals(id_f)){
					student_single[t]=new Student_grade(id_f, course_f, section_f, grade_f);
					t++;
				}
			}
			sc2.close();
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(frame,"Results have not been published yet.");
		}
		
	
		for(int i=0;i<count;i++){
			courseL[i]=new JLabel(student_single[i].getCourse());
			courseL[i].setBounds(49, y_courseL, 119, 40);
			frame.add(courseL[i]);
			y_courseL=y_courseL+40;
			
			grade[i]= new JLabel(student_single[i].getGrade());
			grade[i].setBounds(358, y_select_course, 46, 14);
			frame.add(grade[i]);
			y_select_course=y_select_course+40;	
		}
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logout){
			frame.setVisible(false);
			new Window_Main();
		}
	}
		
	}


