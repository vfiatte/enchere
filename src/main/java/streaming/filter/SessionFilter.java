/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = {"/AjoutFilm.jsp"})
public class SessionFilter implements Filter {
    
    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        
//        String routeInterdite = 
        HttpServletResponse resp = (HttpServletResponse) sr1;
        HttpServletRequest req = ((HttpServletRequest) sr);
        if(req.getSession().getAttribute("user")==null){
            resp.sendRedirect("Login.jsp");
        }
        fc.doFilter(sr, sr1);
        System.out.println(req.getRequestURI().substring(req.getContextPath().length()));
    }

    @Override
    public void destroy() {
    }
    
}
