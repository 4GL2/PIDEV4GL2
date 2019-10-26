package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Instructor;
import entities.Training;
import interfaces.TrainingServiceRemote;


@Stateless
@LocalBean
public class TrainingService implements TrainingServiceRemote {
	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Override
	public void ajouterTraining(Training training) {
		em.persist(training);
	}

	@Override
	public List<Training> getAllTrainings() {
		TypedQuery<Training> query = em.createQuery("Select t from Training t", Training.class);
		return query.getResultList();
	}

	@Override
	public void updateTraining(Training training) {
		em.merge(training);
	}

	@Override
	public void deleteTrainingById(int id) {
		Training training = em.find(Training.class, id);
	
		em.remove(training);
	}
	
	@Override
	public void ajouterInstructor(Instructor instructor) {
		em.persist(instructor);
		
	}

	@Override
	public List<Instructor> getAllInstructors() {
		TypedQuery<Instructor> query = em.createQuery("Select t from Instructor t",Instructor.class);
		return query.getResultList();
	}


}
