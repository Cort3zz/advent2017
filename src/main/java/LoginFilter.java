import sun.rmi.runtime.Log;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter(
        urlPatterns = "/advent",
        filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        if (request.getParameter("user").equals("admin") && request.getParameter("password").equals("123")) {
            JDBC.addLog("" + LocalDateTime.now() + "   Somebody tryed to log in: SUCCES","logInLog");
            chain.doFilter(request, response);
        } else {
            JDBC.addLog("" + LocalDateTime.now() + "   Somebody tryed to log in: FAILED","logInLog");

            request.getRequestDispatcher("indexWithError.html").include(request, response);


        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
