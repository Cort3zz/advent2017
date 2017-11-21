import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        urlPatterns = "/advent",
        filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (request.getParameter("user").equals("admin") && request.getParameter("password").equals("123")) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("indexWithError.html").include(request, response);


        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
