/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import enchere.entity.Effacemoi;

/**
 *
 * @author tom
 */
public interface EffacemoiCrudService extends CrudRepository<Effacemoi, Long>{
    
}
