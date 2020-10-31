package controllers.wages;

import java.io.IOException;
import java.util.List;
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
 * Servlet implementation class WagesIndexServlet
 */
@WebServlet("/wages/index")
public class WagesIndexServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public WagesIndexServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    EntityManager em = DBUtil.createEntityManager();
    Work loginWork = (Work) request.getSession().getAttribute("loginWork");

    List<Wage> wages = em.createNamedQuery("getMyAllWages", Wage.class)
        .setParameter("work", loginWork).getResultList();
    long incomeCount = 0;
    try {

      incomeCount = (long) em.createNamedQuery("sumMyAllIncome", Long.class)
          .setParameter("work", loginWork).getSingleResult();
    } catch (NullPointerException e) {
      e.printStackTrace();
    }

    em.close();
    request.setAttribute("wages", wages);
    request.setAttribute("incomeCount", incomeCount);

    if (request.getSession().getAttribute("flush") != null) {
      request.setAttribute("flush", request.getSession().getAttribute("flush"));
      request.getSession().removeAttribute("flush");
    }

    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/wages/index.jsp");
    rd.forward(request, response);

  }

}
