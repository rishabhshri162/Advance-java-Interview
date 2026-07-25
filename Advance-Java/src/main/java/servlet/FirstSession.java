package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FirstServlet")
public class FirstSession extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        response.setContentType("text/html");

        String url = response.encodeURL("SecondServlet?name=" + name);

        response.getWriter().println("<h2>Welcome " + name + "</h2>");

        response.getWriter().println("<a href='" + url + "'>Go To Second Servlet</a>");
    }
}