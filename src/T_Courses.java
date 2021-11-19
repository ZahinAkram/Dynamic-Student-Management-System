
public class T_Courses {
	private String initial;
	private String course;
	private String section;
	
	public T_Courses(String initial, String course, String section){
		this.initial=initial;
		this.course=course;
		this.section=section;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
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
	

}
