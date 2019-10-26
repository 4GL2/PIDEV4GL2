package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Training implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Enumerated(EnumType.STRING)
	private Category category;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@ManyToOne
	private Instructor instructor;

	public Training() {
		super();
	}

	public Training(int id, String name, Category category, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Training(String name, Category category, Date startDate, Date endDate) {
		this.name = name;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
	public Training(int id, String name, Category category, Date startDate, Date endDate, Instructor Instructor) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.instructor = Instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor Instructor) {
		this.instructor = Instructor;
	}

}
