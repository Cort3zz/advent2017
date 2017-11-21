import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
     int day;
    public static Map<Integer, String> days = new HashMap<>();
    public static List<String> dailyMessage = new ArrayList<>();
    static {
        days.put(1, "ASD");
        days.put(2, "SDF");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dailyPass = request.getParameter("dailypass");
        if (days.get(day).equals(dailyPass)) {
            System.out.println("trololo");
        }else {
            request.getRequestDispatcher("messageLoginWithError.html").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         day = Integer.parseInt(request.getParameter("day"));

        request.getRequestDispatcher("messageLogin.html").include(request, response);
    }
}
