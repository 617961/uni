package rs.ac.metropolitan.cs230;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String index = req.getParameter("index");
        String faculty = req.getParameter("faculty");

        req.getSession(true).setAttribute("name", name);
        req.getSession(true).setAttribute("index", index);
        req.getSession(true).setAttribute("faculty", faculty);

        resp.setContentType("text/html;charset=utf8;");
        out.println(String.format("Welcome %s [%s, %s]!", name, index, faculty));
        out.println("<a href=\"/CS230_DZ02_Aleksandra_Blagojevic_3801_war_exploded/secondServlet\">Second Servlet</a>");
    }
}
