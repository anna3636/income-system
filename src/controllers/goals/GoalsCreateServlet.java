package controllers.goals;

import java.io.IOException;
import java.sql.Timestamp;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Goal;
import models.Work;
import utils.DBUtil;

/**
 * Servlet implementation class GoalsCreateServlet
 */
@WebServlet("/goals/create")
public class GoalsCreateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public GoalsCreateServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String _check = (String) request.getParameter("_check");
    if (_check != null && _check.equals(request.getSession().getId())) {
      EntityManager em = DBUtil.createEntityManager();
      Goal g = new Goal();
      g.setWork((Work) request.getSession().getAttribute("login_work"));
      g.setPurpose(request.getParameter("purpose"));

      g.setTargetAmount(Integer.parseInt(request.getParameter("targetAmount")));

      Timestamp currentTime = new Timestamp(System.currentTimeMillis());
      g.setCreated_at(currentTime);
      g.setUpdated_at(currentTime);

      em.getTransaction().begin();
      em.persist(g);
      em.getTransaction().commit();
      em.close();

      response.sendRedirect(request.getContextPath() + "/goals/index");
    }

  }
}
