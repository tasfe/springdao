/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.repository.location;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.i.kotionokyurievna.springdao.logic.domain.location.*;
import ua.i.kotionokyurievna.springdao.logic.repository.DAOTestsTemplate;

/**
 *
 * @author Kateryna_Reznik
 */
public class LocationRepositoryJDBCTest extends DAOTestsTemplate{
    
    @Autowired
    private LocationRepository locationRepository;
    
    @Before
    public void clearDB(){
        jdbcTemplate.execute("TRUNCATE TABLE Locations");
    }    
    
    @Test
    public void testCreateLocationNoExceptions() {
        LocationI location = new Location("128 Peremohy ave", "03065", "Kyiv", "", "UA");                
        boolean fl = locationRepository.create(location);
        Assert.assertEquals(true, fl);
    }
    
    @Test
    public void testFindAllNoLocationInDbExpectedListSize0(){
        List<LocationI> actualResult = locationRepository.findAll();
        Assert.assertEquals(0, actualResult.size());
    }
    
    @Test
    public void testFindAllSeveralLocationsInDbExpectedListSizeRespectively(){
        LocationI location1 = new Location("128 Peremohy ave", "03065", "Kyiv", "", "UA"); 
        LocationI location2 = new Location("8 Borschahivska str", "03078", "Kyiv", "", "UA");
        LocationI location3 = new Location("18 Heroyiv Dnipra str", "02055", "Kyiv", "", "UA");
        locationRepository.create(location1);
        locationRepository.create(location2);
        locationRepository.create(location3);
        List<LocationI> actualResult = locationRepository.findAll();
        Assert.assertEquals(3, actualResult.size());
    }
    
    @Test
    public void testFindByCountryNoSuchCountryExpectedListSize0(){
        LocationI location1 = new Location("128 Peremohy ave", "03065", "Kyiv", "", "UA"); 
        LocationI location2 = new Location("8 Saint Jak", "11078", "Paris", "", "FR");
        LocationI location3 = new Location("18 Scharlotte str", "67085", "Berlin", "", "DE");
        locationRepository.create(location1);
        locationRepository.create(location2);
        locationRepository.create(location3);
        List<LocationI> actualResult = locationRepository.findByCountry("IT");
        Assert.assertEquals(0, actualResult.size());
    }
    
    @Test
    public void testFindByCountrySeveralItemCountryExpectedListSizeRespectively(){
        LocationI location1 = new Location("128 Peremohy ave", "03065", "Kyiv", "", "UA"); 
        LocationI location2 = new Location("8 Borschahivska str", "03078", "Kyiv", "", "UA");
        LocationI location3 = new Location("18 Scharlotte str", "67085", "Berlin", "", "DE");
        locationRepository.create(location1);
        locationRepository.create(location2);
        locationRepository.create(location3);
        List<LocationI> actualResult = locationRepository.findByCountry("UA");
        Assert.assertEquals(2, actualResult.size());
    }
}
