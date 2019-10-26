package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Instructor;
import entities.Training;

@Remote
public interface TrainingServiceRemote {

	public void ajouterTraining(Training training);

	public List<Training> getAllTrainings();

	public void updateTraining(Training training);

	public void deleteTrainingById(int id);

	public void ajouterInstructor(Instructor Instructor);

	public List<Instructor> getAllInstructors();

}
