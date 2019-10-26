package managedBeans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Category;
import entities.Instructor;
import entities.Training;
import services.TrainingService;


@ManagedBean
@SessionScoped
public class TrainingBean implements Serializable {

	private String name;
	private Date startDate;
	private Date endDate;
	private Category category;
	private Instructor instructor;
	private List<Training> trainings;
	private int selectedInstructorId;
	private int trainingIdToBeUpdated;
	private List<Instructor> instructors;

	@EJB
	TrainingService trainingService;
	
	@PostConstruct
	public void init() {
		startDate = new Date();
		endDate = new Date();
		instructors = trainingService.getAllInstructors();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor Instructor) {
		this.instructor = Instructor;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}
	
	public List<Instructor> getInstructors() {
		instructors = trainingService.getAllInstructors();
		return instructors;
	}
	
	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}
	
	public void addTraining() {
		trainingService.ajouterTraining(new Training(name, category, startDate, endDate));
	}

	public List<Training> getTrainings() {
		trainings = trainingService.getAllTrainings();
		return trainings;
	}

	public void supprimer(int id) {
		trainingService.deleteTrainingById(id);
		System.out.println(1111);
	}

	public int getSelectedInstructorId() {
		return selectedInstructorId;
	}

	public void setSelectedInstructorId(int selectedInstructorId) {
		this.selectedInstructorId = selectedInstructorId;
	}

	public int getTrainingIdToBeUpdated() {
		return trainingIdToBeUpdated;
	}

	public void setTrainingIdToBeUpdated(int trainingIdToBeUpdated) {
		this.trainingIdToBeUpdated = trainingIdToBeUpdated;
	}

	public void modifier(Training training) {
		this.setName(training.getName());
		this.setCategory(training.getCategory());
		this.setStartDate(training.getStartDate());
		this.setEndDate(training.getStartDate());
		this.setInstructor(training.getInstructor());
		this.setTrainingIdToBeUpdated(training.getId());
	}

	public void mettreAjourTraining(Training training) {
		training = new Training(trainingIdToBeUpdated, name, category, startDate, endDate, instructor);
		Instructor selectedInstructor = new Instructor();
		selectedInstructor.setId(selectedInstructorId);
		training.setInstructor(selectedInstructor);
		trainingService.deleteTrainingById(training.getId());
		trainingService.updateTraining(training);
	}
	
	public void ajouterTraining() throws ParseException{
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("startDate :"+ simpleFormat.format(startDate));
		System.out.println("endDate :"+ simpleFormat.format(endDate));
		System.out.println("selectedTrainingId :"+ selectedInstructorId);
		
		Training training = new Training(name, category, startDate, endDate); 	
		Instructor selectedInstructor = new Instructor();
		selectedInstructor.setId(selectedInstructorId);
		training.setInstructor(selectedInstructor);
		trainingService.ajouterTraining(training);
	}

}
