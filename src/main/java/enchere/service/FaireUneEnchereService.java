/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Articles;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class FaireUneEnchereService {
    @Autowired
    EnchereService enchereService;
    
    @Autowired
    ArticlesService articleService;
    
    @Autowired 
    UtilisateurService utilisateurService;
    
    public void encherir(Articles a, Utilisateur u){
        Enchere e = new Enchere();
        e.setArticles(a);
        a.getListeEnchere().add(e);
        e.setUtilisateur(u);
        e.setDateEnchere(new Date());
        u.getListeEnchere().add(e);
        enchereService.save(e);
        articleService.save(a);
        utilisateurService.save(u);
        long plus = 5L;
        a.setPrixActuel(a.getPrixActuel() + plus);
        articleService.save(a);
    }
}
