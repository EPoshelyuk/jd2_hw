package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SetCookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        try {
            Cookie[] myCookies = req.getCookies();

            String cookieName = "testCookie";

            if (myCookies.length > 0) {

                for (int i = 0; i < myCookies.length; i++) {
                    Cookie cookie = myCookies[i];
                    if (cookie.getName().equals(cookieName)) {
                        out.println("<html><head><title>Coookie</title></head>");
                        out.println(" <body><h1>You've been here for the last time in 24 hours</h1>");
                        out.println("<h3>Name of cookie: " + cookie.getName() + ", value of cookie:" + cookie.getValue() + "</h3></body></html>");


                    }
                }
            }
        } catch (NullPointerException e) {
            out.println(" <body><h1>This is your first time here!</h1></body></html>");
        } finally {
            Cookie myCookie = new Cookie("testCookie", "123");
            myCookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(myCookie);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
