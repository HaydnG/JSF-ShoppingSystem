package filter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ManagedBean.UserBean;
import java.io.IOException;
import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author haydn
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    


    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    @Inject
    UserBean userbean;
    
    public LoginFilter() {
    }    
  
    
    @Override
    public void doFilter(ServletRequest req,  ServletResponse res,FilterChain chain)throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/faces/login.xhtml";
        String registerURI = request.getContextPath() + "/faces/registration.xhtml";
        
        String indexURI = request.getContextPath() + "/faces/index.xhtml";
        
        String[] urls = request.getRequestURI().split("/");
        if(urls.length <3){
            response.sendRedirect(loginURI);
        }
        
        System.out.println("Encoding: " + request.getCharacterEncoding());
        System.out.println("Content-type: " + request.getContentType());
        
        try{
            if(urls[2].toLowerCase().equals("api".toLowerCase()) || request.getMethod().equalsIgnoreCase("POST")){

                try {
                        chain.doFilter(request, response);
                    } catch (Throwable t) {

                        t.printStackTrace();
                    }

            }else{
                //Checks if an admin page is being accessed
                 boolean adminreqeust = false;
                if(urls.length >=4){
                    adminreqeust = "admin".equals( urls[3]);
                    System.out.println(adminreqeust);
                }

                boolean loggedin = userbean.LoggedIn();

                boolean Admin = userbean.IsAdmin();

                boolean loginRequest = request.getRequestURI().equals(loginURI);
                boolean registerRequest = request.getRequestURI().equals(registerURI);
                boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + "/faces" + ResourceHandler.RESOURCE_IDENTIFIER); //Allow resource requests through

                if(loggedin || loginRequest || registerRequest || resourceRequest){

                    if((!adminreqeust) || (adminreqeust && Admin)){ //If page is an admin page, only allow if user admin


                        if (!resourceRequest) { // Prevent browser from caching restricted resources.
                            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                            response.setDateHeader("Expires", 0); // Proxies.
                        }


                        try {
                            chain.doFilter(request, response);
                        } catch (Throwable t) {

                            t.printStackTrace();
                        }
                    }else{
                        response.sendRedirect(indexURI);
                    }


                }else{
                    response.sendRedirect(loginURI);
                }
            }
        } catch (NullPointerException Ex){
              Ex.printStackTrace();
        }
        catch (IndexOutOfBoundsException Ex){
               Ex.printStackTrace(); 
        }
    }


    public void destroy() {  
         this.filterConfig = null;
    }


    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }


}
