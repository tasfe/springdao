/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.repository.location;

import java.util.List;
import ua.i.kotionokyurievna.springdao.logic.domain.location.LocationI;

/**
 *
 * @author Kateryna_Reznik
 */

public interface LocationRepository {
    public boolean create( LocationI location);
    public List<LocationI> findAll();
    public List<LocationI> findByCountry( String country );
    public List<LocationI> findByCity( String city );
    public List<LocationI> findByPostalCode( String postalCode );
    public List<LocationI> findByStateProvince( String stateProvince );
}
