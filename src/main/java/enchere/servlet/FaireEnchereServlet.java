/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Articles;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.service.ArticlesService;
import enchere.service.EnchereService;
import enchere.service.FaireUneEnchereService;
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
@WebServlet(name = "FaireEnchereServlet", urlPatterns = {"/FaireEnchereServlet"})
public class FaireEnchereServlet extends AutowireServlet {

    @Autowired
    FaireUneEnchereService faireEnchere;

    @Autowired
    ArticlesService articlesService;

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    EnchereService enchereService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("user"));
        Long idArticle = Long.parseLong(req.getParameter("idArticle"));
        Articles a = articlesService.findOne(idArticle);
        List<Enchere> listeEnchereArticle = a.getListeEnchere();

        if (a.getUtilisateur().getLogin().equals(u.getLogin())) {
            req.setAttribute("votreArticle", "Vous ne pouvez pas encherir sur votre propre article");
            req.getRequestDispatcher("DetailArticleServlet").include(req, resp);
            return;
        }

        if (listeEnchereArticle.size() > 0) {
            Enchere e = listeEnchereArticle.get(listeEnchereArticle.size() - 1);
            if (e.getUtilisateur().getLogin().equals(u.getLogin())) {
                req.setAttribute("dernier", "Vous êtes le dernier à avoir encheri sur cet article");
                req.getRequestDispatcher("DetailArticleServlet").include(req, resp);
                return;
            }

        }
        faireEnchere.encherir(a, u);
        req.getRequestDispatcher("DetailArticleServlet").include(req, resp);

    }
}
