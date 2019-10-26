package managedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Instructor;
import entities.Training;
import services.InstructorService;

@ManagedBean
@SessionScoped
public class InstructorBean {

	private String name;
	private String password;
	private String email;
	private int phone;
	private List<Training> trainings;
	private List<Instructor> instructors;
	private int InstructorIdToBeUpdated;

	@EJB
	InstructorService instructorService;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public int getInstructorIdToBeUpdated() {
		return InstructorIdToBeUpdated;
	}

	public void setInstructorIdToBeUpdated(int InstructorIdToBeUpdated) {
		this.InstructorIdToBeUpdated = InstructorIdToBeUpdated;
	}

	
	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public void addInstructor() {
		instructorService.ajouterInstructor(new Instructor(name, email, password, phone));
		getInstructors();
	}
	
	public List<Instructor> getInstructors() {
		instructors = instructorService.getAllInstructors();
		return instructors;
	}
	
	public void supprimer(int id) {
		instructorService.deleteInstructorById(id);
	}

	public void modifier(Instructor instructor) {
		
		this.setName(instructor.getName());
		this.setEmail(instructor.getEmail());
		this.setPassword(instructor.getPassword()); 
		this.setPhone(instructor.getPhone());
		this.setInstructorIdToBeUpdated(instructor.getId());

	}

	public void mettreAjourInstructor(Instructor instructor) {
		instructor = new Instructor(InstructorIdToBeUpdated, name, email, password, phone);
		instructorService.deleteInstructorById(instructor.getId());
		instructorService.updateInstructor(instructor);
	}

}
