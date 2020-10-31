package controllers.wages;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Wage;
import models.Work;
import utils.DBUtil;

/**
 * Servlet implementation class WagesEditServlet
 */
@WebServlet("/wages/edit")
public class WagesEditServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public WagesEditServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    EntityManager em = DBUtil.createEntityManager();
    Wage a = em.find(Wage.class, Integer.parseInt(request.getParameter("id")));

    em.close();

    Work loginWork = (Work) request.getSession().getAttribute("loginWork");
    if (a != null && loginWork.getId() == a.getWork().getId()) {
      request.setAttribute("wage", a);
      request.setAttribute("_check", request.getSession().getId());
      request.getSession().setAttribute("wageId", a.getId());
    }

    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/wages/edit.jsp");
    rd.forward(request, response);
  }

}
