import javax.servlet.*;
import java.io.*;
public class MyServlet extends GenericServlet{
   public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
       PrintWriter pw=resp.getWriter();
       pw.println("<h1>Hello User !</h1>");
   }
}