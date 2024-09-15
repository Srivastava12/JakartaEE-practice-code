import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class FormTag extends HttpServlet{
  public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
       resp.setContentType("text/html");
       PrintWriter pw=resp.getWriter();
       pw.println("<h1>Responding Servlet called by Html form<h1>");
  }
} 