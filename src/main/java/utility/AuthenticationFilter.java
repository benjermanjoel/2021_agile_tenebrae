package utility;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    private HttpServletRequest httpRequest;

    private static final String[] loginRequiredURLs = {
        "/main", "/screenDM", "/screenPC", "/addCharacter", "/deleteCharacter", "/modifyCharacter"
    };

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException{
        httpRequest = (HttpServletRequest) request;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        String loginURI = httpRequest.getContextPath() + "/index";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("index.jsp");

        if (isLoggedIn && (isLoginRequest || isLoginPage)){
            // the user is already logged in and they're trying to login again
            // this should forward them directly to the home page
            httpRequest.getRequestDispatcher("/").forward(request, response);
        } else if (!isLoggedIn && isLoginRequired()){
            // the user is not logged in, and the requested page requires
            // auth, then forward to login page
            String loginPage = "/index.jsp";
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request, response);
        } else {
            // for other requested pages that do not require auth
            // or the user is already logged in, continue to destination
            chain.doFilter(request, response);
        }
    }

    private boolean isLoginRequired(){
        String requestURL = httpRequest.getRequestURI().toString();

        for(String loginRequiredURL : loginRequiredURLs){
            if(requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }
        return false;
    }

    public AuthenticationFilter(){}
    public void destroy(){}
    public void init(FilterConfig fConfig) throws ServletException{}
}
