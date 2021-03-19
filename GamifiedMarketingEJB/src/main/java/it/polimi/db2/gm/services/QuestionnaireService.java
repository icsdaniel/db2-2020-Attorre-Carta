package it.polimi.db2.gm.services;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.*;
import it.polimi.db2.gm.entities.Questionnaire;

@Stateless
public class QuestionnaireService {
	
	@PersistenceContext(unitName = "GamifiedMarketingEJB")
	private EntityManager em;
	
	public QuestionnaireService() {}
	
	public List<Questionnaire> findAllQuestionnaire() {
		return em.createNamedQuery("Questionnaire.findAll", Questionnaire.class)
				.setHint("javax.persistence.cache.storeMode", "REFRESH").getResultList();
	}
	
	public void createQuestionnaire(int questionnaireId, int productOfTheDayId, Date date) {
		Questionnaire q = new Questionnaire();
		q.setIdquestionnaires(questionnaireId);
		q.setProduct_of_the_day(productOfTheDayId);
		q.setDate(date);
		em.persist(q);
	}

	public Questionnaire findQuestionnaireOfTheDay() {
		Date date = new Date();
		return em.createNamedQuery("Questionnaire.findQOD",Questionnaire.class).setParameter("qsdate",date).getSingleResult();
	}
	
	public void deleteQuestionnaire(int questionnaireId) {
		Questionnaire managedQ = em.find(Questionnaire.class, questionnaireId);
		em.remove(managedQ);
	}
	
}
