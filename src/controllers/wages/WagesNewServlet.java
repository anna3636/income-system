package controllers.wages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Wage;

/**
 * Servlet implementation class WagesNewServlet
 */
@WebServlet("/wages/new")
public class WagesNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WagesNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("_check", request.getSession().getId());
        request.setAttribute("wage", new Wage());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/wages/new.jsp");
        rd.forward(request, response);
    }

}
