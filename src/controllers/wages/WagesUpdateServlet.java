package controllers.wages;

import java.io.IOException;
import java.sql.Date;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Wage;
import utils.DBUtil;

/**
 * Servlet implementation class WagesUpdateServlet
 */
@WebServlet("/wages/update")
public class WagesUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public WagesUpdateServlet() {
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
      Wage a = em.find(Wage.class, (Integer) (request.getSession().getAttribute("wageId")));

      a.setWorkName(request.getParameter("workName"));
      a.setWorkDate(Date.valueOf(request.getParameter("workDate")));
      a.setIncome(Integer.parseInt(request.getParameter("income")));
      a.setContent(request.getParameter("content"));

      em.getTransaction().begin();
      em.getTransaction().commit();
      em.close();
      request.getSession().setAttribute("flush", "更新が完了しました。");
      request.getSession().removeAttribute("wageId");
      response.sendRedirect(request.getContextPath() + "/wages/index");
    }
  }

}
