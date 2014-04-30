/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.daospring.logic;

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
