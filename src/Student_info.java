
public class Student_info {
	private String id;
	private String course;
	private String section;
	
	public Student_info(String id,String course,String section){
		this.id=id;
		this.course=course;
		this.section=section;
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
	

}
