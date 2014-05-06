/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.domain.location;

/**
 *
 * @author Kateryna_Reznik
 */
public interface LocationI {
    public String getStreetAddress();
    public void setStreetAddress( String streetAddress );
    public String getPostalCode();
    public void setPostalCode( String postalCode );
    public String getCity();
    public void setCity( String city );
    public String getStateProvince();
    public void setStateProvince( String stateProvince );
    public String getCountry();
    public void setCountry( String country );
}
