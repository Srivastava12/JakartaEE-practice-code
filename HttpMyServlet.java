import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
public class HttpMyServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
         PrintWriter pw=resp.getWriter();
         pw.println("<html><body bgcolor='grean'>");
         for(int i=1;i<=5;i++)
           pw.println("<h"+i+">Shubham<h"+i+">");
         pw.println("</body></html>");
    }
}