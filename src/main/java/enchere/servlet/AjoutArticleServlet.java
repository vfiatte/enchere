/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Articles;
import enchere.entity.Categorie;
import enchere.entity.Utilisateur;
import enchere.enumeration.StatutEnumeration;
import enchere.service.ArticlesService;
import enchere.service.CategorieService;
import enchere.service.ListeCategorieService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
@WebServlet(name = "AjoutFilmServlet", urlPatterns = {"/AjoutArticleServlet"})
public class AjoutArticleServlet extends AutowireServlet {

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
        
        Articles a = new Articles();
        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        Long prixDepart = Long.parseLong(req.getParameter("prixDepart"));
        Long categorie = Long.parseLong(req.getParameter("categorie"));
        Integer temps = Integer.parseInt(req.getParameter("tempsValidite"));

        a.setNom(nom);
        a.setDescription(description);
        a.setPrixActuel(prixDepart);
        a.setStatut(StatutEnumeration.DISPONIBLE);

        Utilisateur login = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("user"));
        a.setUtilisateur(login);
        login.getListeArticle().add(a);

        req.getSession().setAttribute(nom, a);

        GregorianCalendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_MONTH, temps);
        a.setFinDeVente(c.getTime());

        Categorie cat = categorieService.findOne(categorie);
        a.setCategorie(cat);
        cat.getListeArticle().add(a);
        articlesService.save(a);
        categorieService.save(cat);
        utilisateurService.save(login);
        resp.sendRedirect("listearticlesservlet");
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
