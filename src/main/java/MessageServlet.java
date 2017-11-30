import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
     int day;
    public static Map<Integer, String> dailyPassword = new HashMap<>();
    public static List<String> dailyMessage = new ArrayList<>();
    static {

        dailyPassword.put(1, "8IXYC5E1BR");
        dailyPassword.put(2, "A4UPSP94XU");
        dailyPassword.put(3, "K707GW82F7");
        dailyPassword.put(4, "VAQN7KXWTS");
        dailyPassword.put(5, "JI2Q1M0KY7");
        dailyPassword.put(6, "PI2GGHTN1D");
        dailyPassword.put(7, "HKD8E9XNBP");
        dailyPassword.put(8, "IXU3S23KS8");
        dailyPassword.put(9, "EKXG0FWLA5");
        dailyPassword.put(10, "GNJBUDI03O");
        dailyPassword.put(11, "1J4S4UPAIQ");
        dailyPassword.put(12, "Q5P9IVYR8R");
        dailyPassword.put(13, "G6JESKE3OC");
        dailyPassword.put(14, "00ZDXVMNMH");
        dailyPassword.put(15, "DVIP0DRAQU");
        dailyPassword.put(16, "UK3H7VDEEL");
        dailyPassword.put(17, "5O6LY6UEIR");
        dailyPassword.put(18, "GUCDNNW7QH");
        dailyPassword.put(19, "TAQMY2HCFC");
        dailyPassword.put(20, "DG5MWY6KFC");
        dailyPassword.put(21, "8HC69AFDD0");
        dailyPassword.put(22, "5ON06HV24T");
        dailyPassword.put(23, "TW1LCJ09XZ");
        dailyPassword.put(24, "8IXYC5E1BR");

        dailyMessage.add("<h2>Első üzenet</h2> <p>Remélem Te is hasonló izgalmakkal vártad azt a pillanatot. " +
                "Eljött. Végre megláthatod a mesterművet. Láthatod, miért dolgoztam ennyit," +
                " mivel töltöttem több órát. Minden pillanatát élveztem. Élveztem, mert tudtam, hogy örömöt okozok Neked" +
                " ezzel. Nagyon szeretlek!!!</p>");
        dailyMessage.add("<h2>Második üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Harmadik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Negyedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>)Ötödik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Hatodik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Hetedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Nyolcadik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Kilencedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Tizedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Tizenegyedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Tizenkettedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Tizenharmadik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Tizennegyedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Tizenötödik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Tizenhatodik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Tizenhetedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Tizennyolcadik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Tizenkilencedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Huszadik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Huszonegyedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Huszonkettedik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Huszonharmadik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Huszonnegyedik üzenet</h2> <p>Szeretem a for loopot</p>");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPassword = request.getParameter("dailypass");

        if (dailyPassword.get(day).equals(userPassword)) {
            JDBC.addLog("" + LocalDateTime.now() + "   Somebody tryed to get gift from: " + day + " : SUCCES","dailyCodeLog");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            if(day==2){
                request.getRequestDispatcher("/gifts/giftWithPictureDay2.jsp").forward(request, response);
            }

            request.setAttribute("dailyMessage", dailyMessage.get(day-1));
            request.getRequestDispatcher("/gifts/gift.jsp").include(request, response);
        }else {
            JDBC.addLog("" + LocalDateTime.now() + "   Somebody tryed to get gift from: " + day + " : FAILED    The wrong password was: " + userPassword,"dailyCodeLog");
            request.getRequestDispatcher("messageLoginWithError.html").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         day = Integer.parseInt(request.getParameter("day"));
        request.getRequestDispatcher("messageLogin.html").include(request, response);
    }
}
