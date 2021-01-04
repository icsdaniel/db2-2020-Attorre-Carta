package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "questionnaires", schema = "db_gamified_marketing")
@NamedQueries({
//	@NamedQuery(name = "Questionnaire.findByDate", query = "SELECT q FROM Questionnaire q WHERE q.date= :d "),
	@NamedQuery(name = "Questionnaire.findAll", query = "SELECT q FROM Questionnaire q "),
	@NamedQuery(name = "Questionnaire.findQOD", query = "SELECT q FROM Questionnaire q WHERE q.date= :qsdate")
})
public class Questionnaire {
	
	@Id
	private int idquestionnaires;
	
	private int product_of_the_day;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public int getProduct_of_the_day() {
		return product_of_the_day;
	}

	public void setProduct_of_the_day(int product_of_the_day) {
		this.product_of_the_day = product_of_the_day;
	}

	public void setIdquestionnaires(int idquestionnaires) {
		this.idquestionnaires = idquestionnaires;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdquestionnaires() {
		return idquestionnaires;
	}

	public Date getDate() {
		return date;
	}
}
