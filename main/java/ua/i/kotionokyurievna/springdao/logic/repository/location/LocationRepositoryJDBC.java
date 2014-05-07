/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.repository.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.i.kotionokyurievna.springdao.logic.domain.location.Location;
import ua.i.kotionokyurievna.springdao.logic.domain.location.LocationI;
import ua.i.kotionokyurievna.springdao.logic.repository.jdbc.DAOJDBCUtil;

/**
 *
 * @author Kateryna_Reznik
 */
@Repository( "locationtRepository")
public class LocationRepositoryJDBC implements LocationRepository{
    @Autowired
    private DataSource ds;
     
    public LocationRepositoryJDBC(){
        
    } 
    
    public LocationRepositoryJDBC ( DataSource ds ){
        this.ds = ds;
    }
    
    public boolean create(LocationI location) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Locations "
                    + "(street_address, postal_code, city, state_province, "
                    + "country_id) "+
                    "VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, location.getStreetAddress());
            preparedStatement.setString(2, location.getPostalCode());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.setString(5, location.getCountry());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }
        return false;
    }

    public List<LocationI> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LocationI> locations = new ArrayList<LocationI>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement
                    ("SELECT l.street_address, l.postal_code, l.city, " + 
                    "l.state_province, country_id  "+
                    "FROM locations l ");
            resultSet = preparedStatement.executeQuery();
                      
            while (resultSet.next()) {
                locations.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOJDBCUtil.close(resultSet);
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }
        
        return locations;
    }

    public List<LocationI> findByCountry(String country) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LocationI> locations = new ArrayList<LocationI>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement
                    ("SELECT l.street_address, l.postal_code, l.city, " + 
                    "l.state_province, country_id  "+
                    "FROM locations l "+
                    "WHERE l.country_id = ?");
            preparedStatement.setString(1, country);
            resultSet = preparedStatement.executeQuery();
                      
            while (resultSet.next()) {
                locations.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOJDBCUtil.close(resultSet);
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }
        
        return locations;
    }

    public List<LocationI> findByCity(String city) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LocationI> locations = new ArrayList<LocationI>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement
                    ("SELECT l.street_address, l.postal_code, l.city, " + 
                    "l.state_province, country_id  "+
                    "FROM locations l "+
                    "WHERE l.city = ?");
            preparedStatement.setString(1, city);
            resultSet = preparedStatement.executeQuery();
                      
            while (resultSet.next()) {
                locations.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOJDBCUtil.close(resultSet);
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }
        
        return locations;
    }

    public List<LocationI> findByPostalCode(String postalCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LocationI> locations = new ArrayList<LocationI>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement
                    ("SELECT l.street_address, l.postal_code, l.city, " + 
                    "l.state_province, country_id  "+
                    "FROM locations l "+
                    "WHERE l.postal_code = ?");
            preparedStatement.setString(1, postalCode);
            resultSet = preparedStatement.executeQuery();
                      
            while (resultSet.next()) {
                locations.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOJDBCUtil.close(resultSet);
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }
        
        return locations;
    }

    public List<LocationI> findByStateProvince(String stateProvince) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LocationI> locations = new ArrayList<LocationI>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement
                    ("SELECT l.street_address, l.postal_code, l.city, " + 
                    "l.state_province, country_id  "+
                    "FROM locations l "+
                    "WHERE l.state_province = ?");
            preparedStatement.setString(1, stateProvince);
            resultSet = preparedStatement.executeQuery();
                      
            while (resultSet.next()) {
                locations.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOJDBCUtil.close(resultSet);
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }
        
        return locations;
    }
    
    private LocationI map(ResultSet resultSet) throws SQLException {
        LocationI location = new Location();
        location.setStreetAddress(resultSet.getString(1));
        location.setPostalCode(resultSet.getString(2));
        location.setCity(resultSet.getString(3));
        location.setStateProvince(resultSet.getString(4));
        location.setCountry(resultSet.getString(5));
        return location;
    }
    
}
