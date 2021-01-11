package services;

import entities.*;

import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ResponseService {
	@PersistenceContext(unitName = "GamifiedMarketingEJB")
	private EntityManager em;
	
	
	public ResponseService() {
	}

	/*public void createResponse(int writerId, int questionId, String text) {
		User writer = em.find(User.class, writerId);
		Question question  = em.find(Question.class, questionId);
		Response response = new Response();
		response.setQuestion(question);
		response.setWriter(writer);
		response.setText(text);
		em.persist(response);
	}
	
	public void createResponsesdef(Map<String,String[]> questionAndAnswer,int userId) {
		for (Map.Entry<String, String[]> entry : questionAndAnswer.entrySet()) {
			this.createResponse(userId, Integer.parseInt(entry.getKey()), entry.getValue()[0]);
		}
	}*/
	
	public void createResponses(Map<String,String[]> questionAndAnswer,int userId) {
		User writer = em.find(User.class, userId);
		for (Map.Entry<String, String[]> entry : questionAndAnswer.entrySet()) {
			Question question  = em.find(Question.class, Integer.parseInt(entry.getKey()));
			Response response = new Response();
			response.setQuestion(question);
			response.setWriter(writer);
			response.setText(entry.getValue()[0]);
			em.persist(response);
		}
	}
	
}
