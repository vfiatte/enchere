/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Articles;
import enchere.entity.Enchere;
import enchere.service.ArticlesService;
import enchere.service.FaireUneEnchereService;
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
@WebServlet(name = "FaireEnchereServlet", urlPatterns = {"/FaireEnchereServlet"})
public class FaireEnchereServlet extends AutowireServlet {

    @Autowired
    FaireUneEnchereService faireEnchere;

    @Autowired
    ArticlesService articlesService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long articleId = Long.parseLong(req.getParameter("idArticle"));
        Articles a = articlesService.findOne(articleId);

        if (req.getSession().getAttribute("user").equals(a.getUtilisateur().getLogin())) {
            req.setAttribute("votreArticle", "Vous ne pouvez pas enrichir sur votre propre article");
            req.getRequestDispatcher("DetailArticleServlet").include(req, resp);
        } else {
            Enchere e = new Enchere();
            faireEnchere.encherir(a);
            req.getRequestDispatcher("DetailArticleServlet").include(req, resp);
        }

    }

}
