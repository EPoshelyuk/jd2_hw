package it.academy.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class CountServlet extends HttpServlet {
    private static final long serialVersionUID = -2022814933714802305L;
    int count = 0;
    private static final String path = "D:\\myproject\\webapp-for-task12\\src\\main\\resources\\counter.txt";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            line = bufferedReader.readLine();
        }

        count = Integer.parseInt(line);
        count++;

        resp.setContentType("image/jpeg");

        BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Arial", Font.ITALIC, 75));
        graphics.setColor(Color.yellow);
        graphics.drawString(String.valueOf(count), 100, 140);

        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpeg", out);
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
