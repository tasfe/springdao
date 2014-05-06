/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.domain.department;

import ua.i.kotionokyurievna.springdao.logic.domain.location.LocationI;
import ua.i.kotionokyurievna.springdao.logic.domain.employee.EmployeeI;

/**
 *
 * @author Kateryna_Reznik
 */
public class Department implements DepartmentI{
    private String departmentName;
    private EmployeeI manager;
    private LocationI location;
    
    public Department(){
        
    }
    
    public Department ( String depName ){
        setDepartmentName(departmentName);
    }
    
    public Department( String depName, EmployeeI depManager, LocationI depLocation){
        setDepartmentName(departmentName);
        setManager(manager);
        setLocation(location);
    }

    @Override
    public String getDepartmentName() {
        return departmentName.substring(0);
    }

    @Override
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName.substring(0);
    }

    @Override
    public EmployeeI getManager() {
        return manager;
    }

    @Override
    public void setManager(EmployeeI manager) {
        this.manager = manager;
    }

    @Override
    public LocationI getLocation() {
        return location;
    }

    @Override
    public void setLocation(LocationI location) {
        this.location = location;
    }
    
    @Override
    public boolean equals( Object obj ){
        if ( obj != null && getClass() == obj.getClass() ){
            Department other = (Department) obj;
	    return other.departmentName.equals(departmentName) && 
                    other.location.equals(location) && 
                    other.manager.equals(manager);
	}
        return false;
    }
    
    @Override
    public String toString(){
        return "Department " +getDepartmentName() + ", " + 
                "manager " + getManager().toString() + ", " + 
                "location " + getLocation().toString();
    }
    
}
