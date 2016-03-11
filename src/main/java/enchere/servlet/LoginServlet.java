/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Utilisateur;
import enchere.service.UtilisateurService;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends AutowireServlet {

    @Autowired
    UtilisateurService utilisateurService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        us.ajoutUtil();
        String login = req.getParameter("login");
        String mdp = req.getParameter("mdp");

        Utilisateur util = utilisateurService.findOneByLogin(login);

        System.out.println(util);

        if (util == null) {
            req.getRequestDispatcher("Inscription.jsp").include(req, resp);
        }
        else if(util.getMdp().equals(mdp)) {
            req.getSession().setAttribute("user", req.getParameter("login")); //On obtient le nom d'utilisateur
            req.getSession().setAttribute("userMdp", req.getParameter("mdp"));
            resp.sendRedirect("PageAccueilServlet");
        } else {
            req.setAttribute("mdpincorect", "La connexion a echoué");
            req.getRequestDispatcher("Login.jsp").include(req, resp);
        }

//        req.getRequestDispatcher("AcceuilServlet").include(req, resp);
    }

}
