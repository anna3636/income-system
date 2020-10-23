package controllers.works;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Work;
import models.validators.WorkValidator;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class WorksCreateServlet
 */
@WebServlet("/works/create")
public class WorksCreateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public WorksCreateServlet() {
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
      Work w = new Work();
      w.setName(request.getParameter("name"));
      w.setPassword(EncryptUtil.getPasswordEncrypt(request.getParameter("password"),
          (String) this.getServletContext().getAttribute("pepper")));
      w.setAdmin_flag(Integer.parseInt(request.getParameter("admin_flag")));
      w.setDelete_flag(0);

      List<String> errors = WorkValidator.validate(w, true, true);
      if (errors.size() > 0) {
        em.close();

        request.setAttribute("_check", request.getSession().getId());
        request.setAttribute("work", w);
        request.setAttribute("errors", errors);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/works/new.jsp");
        rd.forward(request, response);
      } else {
        em.getTransaction().begin();
        em.persist(w);
        em.getTransaction().commit();
        em.close();
        request.getSession().setAttribute("flush", "登録が完了しました。");


        response.sendRedirect(request.getContextPath() + "/works/index");

      }
    }
  }
}
