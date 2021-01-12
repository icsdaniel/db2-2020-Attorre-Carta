package controllers;

import entities.Questionnaire;
import entities.Response;

import entities.User;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import services.QuestionnaireService;
import services.ResponseService;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Servlet implementation class CreateResponses
 */
@WebServlet("/CreateResponses")
public class CreateResponses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TemplateEngine templateEngine;
	@EJB(name="services/ResponseService")
    private ResponseService rspService;  
	@EJB(name="services/QuestionnaireService")
    private QuestionnaireService qstService;
	
    public CreateResponses() {
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// If the user is not logged in (not present in session) redirect to the login
		HttpSession session = request.getSession();
		if (session.isNew() || session.getAttribute("user") == null) {
			String loginpath = getServletContext().getContextPath() + "/index.html";
			response.sendRedirect(loginpath);
			return;
		}
		//checking data received correctness
		Questionnaire qod =qstService.findQuestionnaireOfTheDay();
		int questionsNumber = qod.getAmountOfQuestions();
		Map<String,String[]> responses = null;
		Integer age=null;
		String sex=null;
		String expertise=null;
		
		
		try {
			responses = request.getParameterMap();
			for (Map.Entry<String, String[]> entry : responses.entrySet()) {
				System.out.println("key: "+entry.getKey()+" value0: "+entry.getValue()[0]);
				if(entry.getValue().length>1) {
				System.out.println("key: "+entry.getKey()+" value1: "+entry.getValue()[1]);
				}
			}
			if(request.getParameter("age").length()>1) {
				age=Integer.parseInt(request.getParameter("age"));
			}
			if(request.getParameter("age").length()>1) {
				sex=request.getParameter("sex");
			}
			if(request.getParameter("age").length()>1) {
				expertise=request.getParameter("expertise");
			}
			
			
			System.out.println("age: "+age+" sex: "+sex+" expertise:"+expertise);
			
			//check responses number
			if((questionsNumber+3)!=responses.size()) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Incorrect param number");
				return;
			}
			//check that key is int and value is string,array size is 1
			int questionsCounter=0;
			
			for (Map.Entry<String, String[]> entry : responses.entrySet()) {
				if(questionsCounter<questionsNumber) {
					System.out.println("checking that key"+entry.getKey()+"is integer,"+questionsCounter+"<"+questionsNumber);
					Integer.parseInt(entry.getKey());
				}
				else {
					System.out.println("checking that key"+entry.getKey()+"is string,"+questionsCounter+"<"+questionsNumber);
					String a = entry.getKey();
				}
			    if(entry.getValue().length!=1) {
			    	response.sendError(HttpServletResponse.SC_BAD_REQUEST, "More than an answer per question");
					return;
			    }
			    String a = entry.getValue()[0];
			    questionsCounter++;
			}
			} catch (NumberFormatException | NullPointerException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Incorrect or missing param values");
			return;
		}
		
		User user = (User) session.getAttribute("user");
		rspService.createResponses(qod.getIdquestionnaires(),questionsNumber,responses, user.getId());
    }
}
