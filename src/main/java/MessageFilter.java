import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "MessageFilter",
urlPatterns = "/s")
public class MessageFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req.getParameter("dailypass").equals("asd")) {
            req.getRequestDispatcher("messageLoginWithError.html").forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
