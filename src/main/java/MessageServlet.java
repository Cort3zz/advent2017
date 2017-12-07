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

        dailyPassword.put(1, "56CHOT0RT7");
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
        dailyMessage.add("<h2>Második üzenet</h2> <p> </p>");
        dailyMessage.add("<h2>Harmadik üzenet</h2> <p>Nekem minden ébredés, amit egymás mellett élünk meg, karácsony!! <3 :)</p>");
        dailyMessage.add("<h2>Negyedik üzenet</h2> <p>Az embernek magának kell a párját megteremtenie és nem úgy, hogy a párját erőszakolja önmagához, hanem hogy önmagát alakítja önfeláldozással a párjához. Ez a kölcsönös önfeláldozás: a szerelem.</p>");
        dailyMessage.add("<h2>)Ötödik üzenet</h2> <p>Szeretem a for loopot</p>");
        dailyMessage.add("<h2>Hatodik üzenet</h2> <p>Nekem azok a sikeres meglepetések jutnak eszembe amitől sírva fakadtál. Akkor tudtam, hogy elértem amit akartam. Boldoggá tettelek! :-)</p>");
        dailyMessage.add("<h2>Hetedik üzenet</h2> <p>Hát eljött ez a nap is. Megtartod az első beszédedet a parlamentben. És lehet nem az utolsót! Végtelenül büszke vagyok Rád! A suliban már mindenkinek büszkélkedtem Veled! Szeretlek!</p>");
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
            JDBC.addLog(""+day,"already_opened");
            JDBC.addLog("" + JDBC.getDate() + "   Somebody tryed to get gift from: " + day + " : SUCCES","dailyCodeLog");

            redirectToGift(request, response, day);

        }else {
            JDBC.addLog("" + JDBC.getDate() + "   Somebody tryed to get gift from: " + day + " : FAILED    The wrong password was: " + userPassword,"dailyCodeLog");
            request.getRequestDispatcher("messageLoginWithError.html").include(request, response);
        }
    }

    public static void redirectToGift(HttpServletRequest request, HttpServletResponse response, int day) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if(day==2){
            request.getRequestDispatcher("/gifts/giftWithPictureDay2.jsp").forward(request, response);
        } else if (day == 5) {
            request.getRequestDispatcher("/gifts/giftWithPictureDay5.jsp").forward(request, response);
        }
        request.setAttribute("dailyMessage", dailyMessage.get(day-1));
        request.getRequestDispatcher("/gifts/gift.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         day = Integer.parseInt(request.getParameter("day"));
        List<String> days = JDBC.getAllOpenedDay();
        if (days.contains(String.valueOf(day))) {
            redirectToGift(request, response, day);
        }
        request.getRequestDispatcher("messageLogin.html").include(request, response);
    }
}
