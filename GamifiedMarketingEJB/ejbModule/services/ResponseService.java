package services;

import entities.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ResponseService {
	@PersistenceContext(unitName = "GamifiedMarketingEJB")
	private EntityManager em;
	
	
	public ResponseService() {
	}

	public void createResponse(int writerId, int questionId, String text) {
		User writer = em.find(User.class, writerId);
		Question question  = em.find(Question.class, questionId);
		Response response = new Response();
		response.setQuestion(question);
		response.setWriter(writer);
		response.setText(text);
		em.persist(response);
	}
}
