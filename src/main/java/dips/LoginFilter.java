package dips;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession(false);
        Boolean isLoggedIn = false;
        if (session != null) {
            isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        }
        System.out.println("isLogged " + isLoggedIn);
        if (isLoggedIn != null && !isLoggedIn) {
            System.out.println("login failed");
          HttpServletResponse httpServletResponse=  (HttpServletResponse)response;
          httpServletResponse.sendRedirect("/Login.html");
            return;
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
