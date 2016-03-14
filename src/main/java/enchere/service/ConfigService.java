/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Articles;
import enchere.enumeration.StatutEnumeration;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConfigService {

    @Autowired
    ArticlesService articlesService;

    public void finEnchere() {
        GregorianCalendar dateVente = new GregorianCalendar();
        GregorianCalendar ojd = new GregorianCalendar();

        List<Articles> listeArticle = (List<Articles>) articlesService.findAll();

        for (Articles a : listeArticle) {
            dateVente.setTime(a.getFinDeVente());
            if (ojd.before(dateVente)) {
                return;
            } else {
                a.setStatut(StatutEnumeration.APAYER);
                articlesService.save(a);
            }
        }

    }
}
