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
public interface DepartmentI {
    public String getDepartmentName();
    public void setDepartmentName( String departmentName);
    public EmployeeI getManager();
    public void setManager( EmployeeI manager );
    public LocationI getLocation();
    public void setLocation( LocationI location );
}
