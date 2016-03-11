/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Articles;
import enchere.service.ArticlesService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "DetailArticleServlet", urlPatterns = {"/DetailArticleServlet"})
public class DetailArticleServlet extends AutowireServlet {
    
    @Autowired
    ArticlesService articlesService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("titre", "Detail de l'article");
        Long l = Long.parseLong(req.getParameter("idArticle"));
        Articles a = articlesService.findOne(l);
        req.setAttribute("monArticle", a);
        req.getRequestDispatcher("DetailEnchere.jsp").include(req, resp);
        
    }

    

}
