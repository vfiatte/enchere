/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Articles;
import enchere.entity.Categorie;
import enchere.enumeration.StatutEnumeration;
import enchere.service.ArticlesService;
import enchere.service.CategorieService;
import enchere.service.ConfigService;
import enchere.service.ListeCategorieService;
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
@WebServlet(name = "ListeArticlesServlet", urlPatterns = {"/listearticlesservlet"})
public class ListeArticlesServlet extends AutowireServlet {

    @Autowired
    ArticlesService articleService;

    @Autowired
    ListeCategorieService listeCategorieService;

    @Autowired
    CategorieService categorieService;
    
    @Autowired
    ConfigService configService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        configService.finEnchere();
        
        
        List<Categorie> listeCategorie = (List<Categorie>) categorieService.findAll();
        if (listeCategorie.size() == 0) {
            listeCategorieService.listeCategorie();
            listeCategorie = (List<Categorie>) categorieService.findAll();
        }
        req.setAttribute("categorie", listeCategorie);

        List<Articles> a = (List<Articles>) articleService.findAllByStatut(StatutEnumeration.DISPONIBLE);

        req.setAttribute("titre", "Liste des Articles disponibles");
        req.setAttribute("Articles", a);
        req.getRequestDispatcher("ListeArticles.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Categorie> listeCategorie = (List<Categorie>) categorieService.findAll();
        if (listeCategorie.size() == 0) {
            listeCategorieService.listeCategorie();
            listeCategorie = (List<Categorie>) categorieService.findAll();
        }

        req.setAttribute("categorie", listeCategorie);

        if (req.getParameter("categorie").equals("listerTous")) {
            List<Articles> a = (List<Articles>) articleService.findAll();
            req.setAttribute("titre", "Liste des Articles disponibles");
            req.setAttribute("Articles", a);
            req.getRequestDispatcher("ListeArticles.jsp").include(req, resp);
        } else {
            Long id = Long.parseLong(req.getParameter("categorie"));
            List<Articles> listeArticles = articleService.findAllByCategorieId(id);
            req.setAttribute("titre", "Liste des Articles disponibles");
            req.setAttribute("Articles", listeArticles);
            req.getRequestDispatcher("ListeArticles.jsp").include(req, resp);
        }

    }

}
