/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Categorie;
import enchere.service.CategorieService;
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
@WebServlet(name = "ListeCategorieServlet", urlPatterns = {"/ListeCategorieServlet"})
public class ListeCategorieServlet extends AutowireServlet {

    @Autowired
    CategorieService categorieService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Iterable<Categorie> c = categorieService.findAll();
        req.setAttribute("mesCategories", c);
        req.getRequestDispatcher("AjoutArticle.jsp").include(req, resp);
    }

   

}
