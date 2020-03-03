
package rs.ac.metropolitan.cs230;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StockServerServlet")
public class StockServerServlet extends HttpServlet{

    StockQuoteGenerator stockGenerator = new StockQuoteGenerator();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        
        String parameterSimbol = request.getParameter("simbol");
        
        String stockResult = stockGenerator.calculateRandomPrice(parameterSimbol);
        out.println("Rezultat poziva klase StockQuoteGenerator je:");
        out.println(stockResult);
        out.println();
        out.println("Danasnji datum je: " + DateUtil.getCurrentDate());
    }
    
    
}
