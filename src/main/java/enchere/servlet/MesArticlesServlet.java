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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.coyote.http11.Constants.a;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "MesArticlesServlet", urlPatterns = {"/MesArticlesServlet"})
public class MesArticlesServlet extends AutowireServlet {

    @Autowired
    ArticlesService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        List<Categorie> listeCategorie = (List<Categorie>) categorieService.findAll();
        //        if (listeCategorie.size() == 0) {
        //            listeCategorieService.listeCategorie();
        //            listeCategorie = (List<Categorie>) categorieService.findAll();
        //        }
        //        req.setAttribute("categorie", listeCategorie);
        
        if (req.getSession().getAttribute("user").equals(a.ge)){
            if(List<Articles> articlePaye =  articleService.findAllByStatut("PAYE")){
                
            }
        }
        
        
                
        
        if (req.getSession().getAttribute(string)) {
        }
        a = (List<Articles>) articleService.findAll();
        req.setAttribute("titre", "Liste des Articles disponibles");
        req.setAttribute("Articles", a);
        req.getRequestDispatcher("ListeArticles.jsp").include(req, resp);
    }

}
