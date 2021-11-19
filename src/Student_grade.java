
public class Student_grade {
	private String id;
	private String course;
	private String section;
	private String grade;
	
	public Student_grade(String id,String course,String section,String grade){
		this.id=id;
		this.course=course;
		this.section=section;
		this.grade=grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}
