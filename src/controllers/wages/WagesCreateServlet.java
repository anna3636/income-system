package controllers.wages;

import java.io.IOException;
import java.sql.Date;
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
import models.validators.WageValidator;
import utils.DBUtil;

/**
 * Servlet implementation class WagesCreateServlet
 */
@WebServlet("/wages/create")
public class WagesCreateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public WagesCreateServlet() {
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
      Wage a = new Wage();
      a.setWork((Work) request.getSession().getAttribute("login_work"));

      Date work_date = new Date(System.currentTimeMillis());
      String rd_str = request.getParameter("work_date");

      if (rd_str != null && !rd_str.equals("")) {
        work_date = Date.valueOf(request.getParameter("work_date"));
      }
      Integer income = null;
      String checkIncome = request.getParameter("income");
      if (checkIncome != null && !checkIncome.equals("")) {
        income = Integer.valueOf(request.getParameter("income"));
      }

      a.setWork_date(work_date);
      a.setWork_name(request.getParameter("work_name"));
      a.setIncome(income);
      // a.setIncome(Integer.parseInt(request.getParameter("income")));
      a.setContent(request.getParameter("content"));

      List<String> errors = WageValidator.validate(a);
      if (errors.size() > 0) {
        em.close();
        request.setAttribute("_check", request.getSession().getId());
        request.setAttribute("wage", a);
        request.setAttribute("errors", errors);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/wages/new.jsp");
        rd.forward(request, response);
      } else {


        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        request.getSession().setAttribute("flush", "登録が完了しました。");

        response.sendRedirect(request.getContextPath() + "/wages/index");
      }
    }
  }

}

