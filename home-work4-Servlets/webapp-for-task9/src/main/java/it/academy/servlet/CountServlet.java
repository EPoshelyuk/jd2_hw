package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class CountServlet extends HttpServlet {
    private static final long serialVersionUID = -6943962589365606582L;
    int count = 0;
    private static final String path = "D:\\myproject\\webapp-for-task9\\src\\main\\resources\\counter.txt";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            line = bufferedReader.readLine();
        }

        count = Integer.parseInt(line);
        count++;
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Count</title></head>");
        out.println(" <body><h1>" + "Count of visits: " + count + "</h1></body></html>");

        try (final FileWriter writer = new FileWriter(path, false)) {
            final String str = Integer.toString(count);
            writer.write(str);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
