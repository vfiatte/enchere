/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Articles;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ArticlesService extends CrudRepository<Articles, Long>{
    public List<Articles> findAllByCategorieId(Long id);
    public List<Articles> findAllByStatut(String s);
}
