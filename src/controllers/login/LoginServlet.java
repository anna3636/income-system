package controllers.login;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Work;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LoginServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    request.setAttribute("_check", request.getSession().getId());
    request.setAttribute("miss", false);

    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
    rd.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Boolean checkResult = false;
    String name = request.getParameter("name");
    String pass = request.getParameter("password");
    Work w = null;
    if (name != null && !name.equals("") && pass != null && !pass.equals("")) {
      EntityManager em = DBUtil.createEntityManager();
      String password = EncryptUtil.getPasswordEncrypt(pass,
          (String) this.getServletContext().getAttribute("pepper"));
      // ユーザー名とパスワードが正しいかチェック
      try {
        w = em.createNamedQuery("checkLoginNameAndPassword", Work.class).setParameter("name", name)
            .setParameter("sign", password).getSingleResult();

      } catch (NoResultException ex) {
      }
      em.close();

      if (w != null) {
        checkResult = true;
      }
    }
    if (!checkResult) {
      // 認証が失敗ならログイン画面に戻る
      request.setAttribute("_check", request.getSession().getId());
      request.setAttribute("miss", true);

      RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
      rd.forward(request, response);
    } else {
      // 認証出来たら、トップページへリダイレクト
      request.getSession().setAttribute("loginWork", w);
      response.sendRedirect(request.getContextPath() + "/");
    }

  }

}
