import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Window_Teacher_Grade implements ActionListener{
	
	private JFrame frame;
	
	private JScrollPane scrollpanel;
	private JPanel panel;
	
	private JLabel headingL;
	private JLabel initialL;
	private JLabel initialL2;
	private JLabel courseL;
	private JLabel courseL2;
	private JLabel sectionL;
	private JLabel sectionL2;
	private JLabel studentL;
	private JLabel studentL2;
	private JLabel studentidL[];
	
	private JComboBox grade[];
	private JButton Submit;
	
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem logout;
	private JMenuItem home;
	
	String faculty;
	String course;
	String section;
	
	Student_info student[];
	Student_info student_class[];
	
	public int num;
	
	public Window_Teacher_Grade(String faculty,String course, String section){
		
		this.faculty=faculty;
		this.course=course;
		this.section=section;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 890, 610);
		
		
		
		panel = new JPanel();
		
		headingL = new JLabel("Grading Window");
		headingL.setFont(new Font("Times New Roman", Font.BOLD, 22));
		headingL.setBounds(357, 57, 207, 45);
		
		initialL = new JLabel("Initial:");
		initialL.setFont(new Font("Times New Roman", Font.BOLD, 18));
		initialL.setBounds(63, 156, 100, 45);
		
		initialL2 = new JLabel(faculty);
		initialL2.setBounds(157, 157, 100, 45);
		
		courseL = new JLabel("Course:");
		courseL.setFont(new Font("Times New Roman", Font.BOLD, 18));
		courseL.setBounds(330, 156, 100, 45);
		
		courseL2 = new JLabel(course);
		courseL2.setBounds(440, 158, 100, 45);
		
		sectionL = new JLabel("Section:");
		sectionL.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sectionL.setBounds(595, 158, 100, 41);
		
		sectionL2 = new JLabel(section);
		sectionL2.setBounds(704, 158, 100, 45);
		
		studentL = new JLabel("Student ID");
		studentL.setHorizontalAlignment(SwingConstants.CENTER);
		studentL.setBounds(182, 226, 100, 45);
		
		studentL2 = new JLabel("Choose Grade");
		studentL2.setHorizontalAlignment(SwingConstants.CENTER);
		studentL2.setBounds(494, 226, 118, 45);
		
		menu = new JMenuBar();
		file = new JMenu("File");
		logout = new JMenuItem("Logout");
		logout.addActionListener(this);
		

		file.add(logout);
		menu.add(file);
		frame.setJMenuBar(menu);
		
		panel.add(headingL);
		panel.add(initialL);
		panel.add(initialL2);
		panel.add(courseL);
		panel.add(courseL2);
		panel.add(sectionL);
		panel.add(sectionL2);
		panel.add(studentL);
		panel.add(studentL2);

		try {
			File f=new File("student-course.txt");
			Scanner sc = new Scanner(f);
			int x=0;
			while(sc.hasNext()){
				String id_f=sc.next();
				String course_f=sc.next();
				String section_f=sc.next();
				x++;
				if(course.equalsIgnoreCase(course_f) && section.equalsIgnoreCase(section_f)){
					num++;
				}
				
			}
			sc.close();
			
			
			int y=0;
			student_class=new Student_info[num];
			int q=0;
			
			File f2=new File("student-course.txt");
			Scanner sc2=new Scanner(f2);
			
			while(y<x){
				String id_f=sc2.next();
				String course_f=sc2.next();
				String section_f=sc2.next();
				if(course.equalsIgnoreCase(course_f) && section.equalsIgnoreCase(section_f)){
					student_class[q]=new Student_info(id_f, course_f, section_f);
					q++;
				}
				y++;
			}
			sc2.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		studentidL=new JLabel[num];
		grade=new JComboBox[num];
		String possible_grade[]={"A","A-","B+","B","B-","C+","C","C-","D","F"};
		int y_student=307;
		int y_grade=303;
		
		for(int i=0;i<num;i++){
			studentidL[i]=new JLabel(student_class[i].getId());
			studentidL[i].setHorizontalAlignment(SwingConstants.CENTER);
			studentidL[i].setBounds(129, y_student, 220, 45);
			y_student=y_student+97;
			panel.add(studentidL[i]);
			
			grade[i]=new JComboBox(possible_grade);
			grade[i].setBounds(522, y_grade, 78, 49);
			y_grade=y_grade+97;
			panel.add(grade[i]);
			grade[i].addActionListener(this);
		}
		
		Submit=new JButton("Submit");
		Submit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Submit.setBounds(347, y_grade-10, 118, 46);
		Submit.addActionListener(this);
		
		panel.add(Submit);
		panel.setPreferredSize(new Dimension(890,y_grade+150));
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
	
		scrollpanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpanel.setBounds(0, 0, 874, 572);
        panel = new JPanel(null);
        scrollpanel.getVerticalScrollBar().setUnitIncrement(16); //Increases Sensitivity of Scrolling using mouse Scroller*/
        panel.add(scrollpanel);
        
       
        
		frame.add(scrollpanel);
		frame.setTitle("Teacher Grading System");
		frame.getRootPane().setDefaultButton(Submit);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Submit){
			
			try {
				FileWriter fw = new FileWriter("student-grade.txt",true);
				for(int i=0;i<num;i++){
				    fw.write(course+"\r\n");
					fw.write(section+"\r\n");
					fw.write(studentidL[i].getText()+"\r\n");
					fw.write(grade[i].getSelectedItem()+"\r\n");
					
				}
				fw.close();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(frame, "Grades added to the file");
			frame.setVisible(false);
			new Window_Main();

		}
		if(e.getSource() == logout){
			frame.setVisible(false);
			new Window_Main();
		}
		
	}

}
