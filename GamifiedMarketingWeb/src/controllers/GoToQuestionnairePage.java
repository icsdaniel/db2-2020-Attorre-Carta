package controllers;

import java.io.IOException;

import entities.*;
import services.*;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import services.QuestionnaireService;

@WebServlet("/GoToQuestionnairePage")
public class GoToQuestionnairePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TemplateEngine templateEngine;
	@EJB(name="services/QuestionnaireService")
	private QuestionnaireService qstService;
	
    public GoToQuestionnairePage() {
        super();
    }
    
    public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		this.templateEngine = new TemplateEngine();
		this.templateEngine.setTemplateResolver(templateResolver);
		templateResolver.setSuffix(".html");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Questionnaire qs=null;
		try {
			qs = qstService.findQuestionnaireOfTheDay();
		}catch(Exception e){
			
		}
		System.out.println(qs);
		//if the user has already submitted the questionnaire display a message and redirect to home
		
		//otherwise retrieve qod and its questions and let the user answer
		
	}

}
