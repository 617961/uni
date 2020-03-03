package rs.ac.metropolitan.cs230;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String name = (String) req.getSession(true).getAttribute("name");
        String index = (String) req.getSession(true).getAttribute("index");
        String faculty = (String) req.getSession(true).getAttribute("faculty");

        resp.setContentType("text/html;charset=utf8;");
        out.println(String.format("Well done, %s! You have successfully mastered the art of servlets! [%s, %s]", name, index, faculty));
    }
}
