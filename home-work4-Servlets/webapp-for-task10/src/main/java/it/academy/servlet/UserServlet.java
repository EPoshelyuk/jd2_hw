package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = -6032621771381296986L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String mail = req.getParameter("e-mail");

        if ((phone.isEmpty()) & (mail.isEmpty())) {
            out.println("<html><head><title>User Servlet</title></head>");
            out.println("<body><h2>Please, enter your phone number or e-mail!</h2>");
            out.println("</body></html>");
        } else {
            out.println("<html><head><title>User Servlet</title></head>");
            out.println("<body><p>Hello " + name + "</p>");
            out.println("<body><p>Your phone number: " + phone + "</p>");
            out.println("<body><p>Your e-mail: " + mail + "</p>");
            out.println("</body></html>");
        }
    }
}
