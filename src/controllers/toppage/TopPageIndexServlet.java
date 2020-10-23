package controllers.toppage;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Work;
import utils.DBUtil;

/**
 * Servlet implementation class TopPageIndexServlet
 */
@WebServlet("/index.html")
public class TopPageIndexServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public TopPageIndexServlet() {
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

    /*
     * System.out.println("★ id=" + login_work.getId()); System.out.println("★ name=" +
     * login_work.getName());
     */

    long income_count = 0;
    try {

      income_count = (long) em.createNamedQuery("sumMyAllIncome", Long.class)
          .setParameter("work", login_work).getSingleResult();
    } catch (NullPointerException e) {
      e.printStackTrace();
    }

    Integer max_goal = em.createNamedQuery("getMaxGoal", Integer.class)
        .setParameter("work", login_work).getSingleResult();
    em.close();
    request.setAttribute("income_count", income_count);
    request.setAttribute("max_goal", max_goal);

    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topPage/index.jsp");
    rd.forward(request, response);
  }

}
