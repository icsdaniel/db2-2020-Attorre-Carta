package it.polimi.db2.gm.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions", schema = "db_gamified_marketing")
@NamedQueries({
	@NamedQuery(name = "Question.findQuestionsOfQuestionnaire", query = "SELECT qs FROM Question qs JOIN qs.questionnaire qst WHERE qst.idquestionnaires = :qid")
})
public class Question {
	
	@Id
	private int idquestions;
	
	@ManyToOne
	@JoinColumn(name = "questionnaire")
	private Questionnaire questionnaire;
	
	private String text;

	public int getIdquestions() {
		return idquestions;
	}

	public void setIdquestions(int idquestions) {
		this.idquestions = idquestions;
	}

	public int getQuestionnaire() {
		return questionnaire.getIdquestionnaires();
	}

	public void setQuestionnaire(int questionnaire) {
		this.questionnaire.setIdquestionnaires(questionnaire);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
