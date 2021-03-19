package it.polimi.db2.gm.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "responses", schema = "db_gamified_marketing")
@NamedQueries({
	@NamedQuery(name = "Response", query = "SELECT q FROM Questionnaire q ")
	})
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idresponses")
	private Integer idresponses;
	@ManyToOne @JoinColumn(name="writer")
	private User writer;
	@ManyToOne @JoinColumn(name="question")
	private Question question;
	
	private String text;
	
	public Response() {
	}
	
	public Response(User writer,Question question,String text) {
		this.writer=writer;
		this.question=question;
		this.text=text;
		
	}
	public Integer getIdresponses() {
		return idresponses;
	}

	public void setIdresponses(Integer idresponses) {
		this.idresponses = idresponses;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
