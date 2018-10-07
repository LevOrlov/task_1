package main.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static String LIST_USER = "/listUser.jsp";
    private static String INSERT_OR_EDIT = "/edit.jsp";
    private UserDao dao =new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward="";
        request.setAttribute("users", dao.getAllUsers());
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = dao.getUserById(userId);
            forward = INSERT_OR_EDIT;
            request.setAttribute("user", user);}

        else {
            forward = LIST_USER;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
      //  user.setFirstName(request.getParameter("firstName"));
       // user.setLastName(request.getParameter("lastName"));

    }
}
