package lab.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Courses")
public class Course {
	@Id
	@Column(name="Id")
	String id;
	
	@Column(name="Name")
	String name;
	
	@Column(name="Schoolfee")
	Double schoolfee;
	
	@Temporal(TemporalType.DATE)
	@Column(name="StartDate")
	Date startDate;
	
	@Column(name="LearnerCount")
	Integer learnCount;
	
	@Column(name="Status")
	Boolean status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSchoolfee() {
		return schoolfee;
	}

	public void setSchoolfee(Double schoolfee) {
		this.schoolfee = schoolfee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getLearnCount() {
		return learnCount;
	}

	public void setLearnCount(Integer learnCount) {
		this.learnCount = learnCount;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
