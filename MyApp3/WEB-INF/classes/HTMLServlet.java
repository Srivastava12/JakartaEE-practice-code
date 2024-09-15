import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class HTMLServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
      resp.setContentType("text/html");
      PrintWriter pw=resp.getWriter();
      pw.println("Responding Servlet called by HTML page.......");
   }
}