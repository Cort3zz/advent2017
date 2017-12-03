import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/app")
public class AppServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("appPass").equals("20140822")) {
            PrintWriter out = response.getWriter(  );
            response.setContentType("text/html");
            out.println("<html><body>");
            out.println("<a href=\"SerialGenerator1.1.apk\"><img src=\"downloadArrow.png\"></a>");
            out.println("</body></html>");
        }else{
            response.sendRedirect("index.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
