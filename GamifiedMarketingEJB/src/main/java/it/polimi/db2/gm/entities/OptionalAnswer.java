package it.polimi.db2.gm.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: optional_answer
 *
 */
@Entity
@Table(name = "optional_answers", schema = "db_gamified_marketing")
public class OptionalAnswer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idoptional_answers;
	@ManyToOne
	@JoinColumn(name = "writer")
	private User writer;
	@ManyToOne
	@JoinColumn(name = "questionnaire")
	private Questionnaire questionnaire;
	
	private Integer age;
	
	private Character sex;
	
	private Character expertise;
	
	public OptionalAnswer() {
		super();
	}

	public int getIdoptionalanswers() {
		return idoptional_answers;
	}

	public void setIdoptionalanswers(int idoptionalanswers) {
		this.idoptional_answers = idoptionalanswers;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public Character getExpertise() {
		return expertise;
	}

	public void setExpertise(Character expertise) {
		this.expertise = expertise;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
	
}
