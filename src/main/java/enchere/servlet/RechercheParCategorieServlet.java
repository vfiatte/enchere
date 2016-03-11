/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Categorie;
import enchere.service.ArticlesService;
import enchere.service.CategorieService;
import enchere.service.ListeCategorieService;
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
@WebServlet(name = "RechercheParCategorieServlet", urlPatterns = {"/RechercheParCategorieServlet"})
public class RechercheParCategorieServlet extends AutowireServlet {

    @Autowired
    ArticlesService articlesService;
    @Autowired
    CategorieService categorieService;
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    ListeCategorieService listeCategorieService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Categorie> listeCategorie = (List<Categorie>) categorieService.findAll();
        if (listeCategorie.size() == 0) {
            listeCategorieService.listeCategorie();
            listeCategorie = (List<Categorie>) categorieService.findAll();
        }

        req.setAttribute("categorie", listeCategorie);
        req.getRequestDispatcher("AjoutArticle.jsp").include(req, resp);

    }

}