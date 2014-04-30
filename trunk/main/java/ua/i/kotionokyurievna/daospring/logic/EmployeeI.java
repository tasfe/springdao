/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.daospring.logic;

/**
 *
 * @author Kateryna_Reznik
 */
public interface EmployeeI {
    public String getFirstName();
    public void setFirstName(String firstName);
    public String getLastName();
    public void setLastName(String lastName);
    public JobI getJob();
    public void setJob( JobI job );
    public double getSalary();
    public void setSalary( double salary );
    public DepartmentI getDepartment();
    public void setDepartment(DepartmentI department);
}
