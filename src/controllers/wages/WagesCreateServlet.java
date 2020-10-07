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
import models.Work;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _check=(String)request.getParameter("_check");
        if(_check !=null && _check.equals(request.getSession().getId())){
            EntityManager em=DBUtil.createEntityManager();
            Wage a=new Wage();
            a.setWork((Work)request.getSession().getAttribute("login_work"));

            Date work_date=new Date(System.currentTimeMillis());
            String rd_str=request.getParameter("work_date");

            if(rd_str !=null && !rd_str.equals("")){
                work_date=Date.valueOf(request.getParameter("work_date"));
            }

            a.setWork_date(work_date);
            a.setWork_name(request.getParameter("work_name"));
            a.setIncome(Integer.parseInt(request.getParameter("income")));
            a.setContent(request.getParameter("content"));

            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath()+"/wages/index");
        }
    }

}
