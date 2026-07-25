package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SecondServlet")
public class SecondSession extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        HttpSession session = request.getSession();

        response.setContentType("text/html");

        response.getWriter().println("<h2>Welcome " + name + "</h2>");
        response.getWriter().println("<h3>Session Id : " + session.getId() + "</h3>");
    }
}