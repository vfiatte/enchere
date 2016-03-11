/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ListeCategorieService {

    @Autowired
    CategorieService categorieService;

    public void listeCategorie() {
        categorieService.save(new Categorie(1L, "Automobile"));
        categorieService.save(new Categorie(2L, "Immobilier"));
        categorieService.save(new Categorie(3L, "Vetement"));
        categorieService.save(new Categorie(4L, "Animaux"));
        categorieService.save(new Categorie(5L, "Informatique"));
    }
}
