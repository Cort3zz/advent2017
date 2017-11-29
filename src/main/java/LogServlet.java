import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


    @WebServlet("/loghahaha")
    public class LogServlet extends HttpServlet {
        public static List<String> log = new ArrayList<>();


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            PrintWriter out = response.getWriter(  );
            response.setContentType("text/html");
            out.println("<html><body>");
            for (int i = 0; i < LogServlet.log.size(); i++) {
                out.println(LogServlet.log.get(i));
                out.println("<br>");
            }
            out.println("</body></html>");

        }
    }

