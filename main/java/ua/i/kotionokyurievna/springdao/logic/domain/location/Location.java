/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.domain.location;

/**
 *
 * @author Kateryna_Reznik
 */
public class Location implements LocationI {
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String country;
    
    public Location(){
        
    }
    
    public Location ( String streetAddress, String postalCode, String city, 
            String stateProvince, String country){
        setStreetAddress(streetAddress);
        setPostalCode(postalCode);
        setCity(city);
        setStateProvince(stateProvince);
        setCountry(country);
    }

    @Override
    public String getStreetAddress() {
        return streetAddress.substring(0);
    }

    @Override
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress.substring(0);
    }

    @Override
    public String getPostalCode() {
        return postalCode.substring(0);
    }

    @Override
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode.substring(0);
    }

    @Override
    public String getCity() {
        return city.substring(0);
    }

    @Override
    public void setCity(String city) {
        this.city = city.substring(0);
    }

    @Override
    public String getStateProvince() {
        return stateProvince.substring(0);
    }

    @Override
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince.substring(0);
    }

    @Override
    public String getCountry() {
        return country.substring(0);
    }

    @Override
    public void setCountry(String country) {
        this.country = country.substring(0);
    }
    
    @Override 
    public boolean equals( Object obj ){
        if ( obj != null && getClass() == obj.getClass() ){
            Location other = (Location) obj;
            return other.city.equals(city) && other.country.equals(country) &&
                    other.streetAddress.equals(streetAddress) && 
                    other.stateProvince.equals(stateProvince) &&
                    other.postalCode.equals(postalCode);
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "Location: " + getStreetAddress() + ", " + getPostalCode() + 
                ", " + getCity() + ", " + getCountry() + ", " + 
                getStateProvince();
                
    }
    
}
