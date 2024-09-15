import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class cfg extends HttpServlet{
   public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
       resp.setContentType("text/html");
       PrintWriter pw=resp.getWriter();
       ServletConfig cf=getServletConfig();
       ServletContext ct=getServletContext();
       pw.println(cf.getInitParameter("name"));
       pw.println(ct.getInitParameter("city"));
   }
}