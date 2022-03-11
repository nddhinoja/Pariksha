package Config;

import org.dippy.models.Login;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LogFilter", urlPatterns = {"/*"})
public class LogFilter implements Filter {

    FilterConfig filterConfig;
    //private Logger logger = (Logger) LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        filterConfig.getServletContext().log("Initializing Log Filter.........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        filterConfig.getServletContext().log("host address..........:" + servletRequest.getLocalAddr());

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("role") != null);
        String loginURI = httpServletRequest.getContextPath() + "/loginprocess";
        String a = httpServletRequest.getRequestURI();
        boolean isLoginRequest = httpServletRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpServletRequest.getRequestURI().endsWith("login");

        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // the admin is already logged in and he's trying to login again
            // then forwards to the admin's homepage
            //httpServletResponse.sendRedirect("loginprocess");
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("login");
            dispatcher.forward(servletRequest, servletResponse);

        } else if (isLoggedIn || isLoginRequest) {
        // continues the filter chain
        // allows the request to reach the destination
            filterChain.doFilter(servletRequest, servletResponse);

        }
        else {
            // the admin is not logged in, so authentication is required
            // forwards to the Login page
            //httpServletResponse.sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/login");
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("login");
            dispatcher.forward(servletRequest, servletResponse);

        }
    }
}
/*if((session==null)){
            filterConfig.getServletContext().log("Inside unlogged in user..........");
            //httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.jsp");
            RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("index.jsp");
            dispatcher.forward(httpServletRequest,httpServletResponse);
        }
        else {
            filterChain.doFilter(servletRequest,servletResponse);
        }*//*

    }

    @Override
    public void destroy(){
        filterConfig.getServletContext().log("Destroying................");
    }
}
*/
