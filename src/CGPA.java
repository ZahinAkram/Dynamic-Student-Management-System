
public class CGPA {
private double credit;
private double cgpa;
static int number;

public CGPA(double credit,double cgpa){
	this.credit=credit;
	this.cgpa=cgpa;
	
	number++;
}

public double getCredit() {
	return credit;
}

public void setCredit(double credit) {
	this.credit = credit;
}

public double getCgpa() {
	return cgpa;
}

public void setCgpa(double cgpa) {
	this.cgpa = cgpa;
}

}
