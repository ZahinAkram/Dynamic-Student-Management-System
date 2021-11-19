import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.*;

public class Window_Main implements ActionListener {
	
	private JFrame frame;
	
	private JLabel teachersL;
	private JLabel headingL;
	private JLabel imageL;
	
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem exit;
	
	private JButton teachersB;
	private JButton studentsB;
	private JButton cgpaB;

	
	public Window_Main(){
		
		frame = new JFrame();
		frame.setTitle("Teacher-Student Management System");
		frame.setBounds(100, 100, 659, 511);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);
		
		teachersL = new JLabel("Teacher Student Management System");
		teachersL.setHorizontalAlignment(SwingConstants.CENTER);
		teachersL.setFont(new Font("Times New Roman", Font.BOLD, 21));
		teachersL.setBounds(152, 11, 358, 69);
		
		headingL = new JLabel("Please   select  one  of  the  following  features: ");
		headingL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		headingL.setBounds(20, 80, 296, 41);
		
		teachersB = new JButton("Teachers");
		teachersB.setBounds(61, 152, 215, 53);
		teachersB.addActionListener(this);
		
		studentsB = new JButton("Student");
		studentsB.setBounds(61, 238, 215, 53);
		studentsB.addActionListener(this);
		
		cgpaB = new JButton("CGPA Calculator");
		cgpaB.setBounds(61, 329, 215, 53);
		cgpaB.addActionListener(this);
		
		
		File i = new File("image.jpg");
		String image_path = i.getAbsolutePath();
		imageL = new JLabel("");
		imageL.setIcon(new ImageIcon(image_path));
		imageL.setHorizontalAlignment(SwingConstants.CENTER);
		imageL.setBounds(385, 179, 232, 129);
		
		frame.add(teachersL);
		frame.add(headingL);
		frame.add(teachersB);
		frame.add(studentsB);
		frame.add(cgpaB);
		frame.add(imageL);
		
		
		menu = new JMenuBar();
		file = new JMenu("File");
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		
		file.add(exit);
		menu.add(file);
		frame.setJMenuBar(menu);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==teachersB){
			frame.setVisible(false);
				try {
					new Window_Teachers_LogIn();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		}
		
		else if(e.getSource()==studentsB){
			frame.setVisible(false);
			new Window_Students_LogIn();
		}
		
		else if(e.getSource() == exit){
			System.exit(0);
		}
		
		else if(e.getSource()==cgpaB){
			frame.setVisible(false);
			new Window_CGPA();
		}
	}

}
