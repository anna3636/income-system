package controllers.goals;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Goal;

/**
 * Servlet implementation class GoalsNewServlet
 */
@WebServlet("/goals/new")
public class GoalsNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoalsNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("_check", request.getSession().getId());

        request.setAttribute("goal", new Goal());

        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/goals/new.jsp");
        rd.forward(request, response);
    }

}
