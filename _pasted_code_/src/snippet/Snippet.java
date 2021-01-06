package snippet;

public class Snippet {
	HttpSession session = request.getSession();
			if (session.isNew() || session.getAttribute("user") == null) {
				String loginpath = getServletContext().getContextPath() + "/index.html";
				response.sendRedirect(loginpath);
				return;
			}
}

