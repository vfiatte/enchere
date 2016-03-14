/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Articles;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.enumeration.StatutEnumeration;
import enchere.service.ArticlesService;
import enchere.service.EnchereService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "MesArticlesServlet", urlPatterns = {"/MesArticlesServlet"})
public class MesArticlesServlet extends AutowireServlet {

    @Autowired
    ArticlesService articleService;

    @Autowired
    UtilisateurService utilisateurService;
    
    @Autowired
    EnchereService enchereService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("user"));//Je recupere le login de l'utilisateur de la session
        
        List<Articles> listeAUtilisateur = u.getListeArticle();
        req.setAttribute("vosArticlesPostes", listeAUtilisateur);
        
        
        List<Articles> listeEnchereEncours = articleService.findDistinctArticlesByStatutAndListeEnchereUtilisateur(StatutEnumeration.DISPONIBLE, u);
        req.setAttribute("mesEncheres", listeEnchereEncours);
        
        
        List<Articles> listeApayer = articleService.findAllByUtilisateurLoginAndStatut(u, StatutEnumeration.APAYER);
        req.setAttribute("ArticlesAPayer", listeApayer);
        
        List<Articles> listePaye = articleService.findAllByUtilisateurLoginAndStatut(u, StatutEnumeration.PAYE);
        req.setAttribute("ArticlesPayes", listePaye);
        
        req.getRequestDispatcher("MesArticles.jsp").include(req, resp);

        
    }

}
