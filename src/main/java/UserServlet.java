package main.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static String LIST_USER = "/listUser.jsp";
    private UserDao dao =new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RequestDispatcher rd = req.getRequestDispatcher("/login.html");
        String forward="";
        //String action = request.getParameter("action");
        forward = LIST_USER;

        request.setAttribute("users", dao.getAllUsers());

        RequestDispatcher view = request.getRequestDispatcher(forward);
       view.forward(request, response);
//
      //  RequestDispatcher rd = req.getRequestDispatcher("/LoginSuccess.jsp");
        //rd.forward(req, resp);
      //  resp.sendRedirect("/LoginSuccess.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //RequestDispatcher rd = req.getRequestDispatcher("/login.html");
        String forward="";
        //String action = request.getParameter("action");
        forward = LIST_USER;
        request.setAttribute("users", dao.getAllUsers());

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, resp);
        //  RequestDispatcher rd = req.getRequestDispatcher("/LoginSuccess.jsp");
        //rd.forward(req, resp);
        //  resp.sendRedirect("/LoginSuccess.jsp");
    }
}
