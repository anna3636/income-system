package controllers.goals;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Goal;
import models.Work;
import utils.DBUtil;

/**
 * Servlet implementation class GoalsIndexServlet
 */
@WebServlet("/goals/index")
public class GoalsIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoalsIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        Work login_work = (Work) request.getSession().getAttribute("login_work");
        List<Goal> goals = em.createNamedQuery("getAllMyGoal", Goal.class)
                .setParameter("work", login_work)
                .getResultList();

        em.close();
        request.setAttribute("goals", goals);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/goals/index.jsp");
        rd.forward(request, response);

    }

}
