/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.domain.employee;

import ua.i.kotionokyurievna.springdao.logic.domain.job.JobI;

/**
 *
 * @author Kateryna_Reznik
 */
public interface EmployeeI {
    public String getFirstName();
    public void setFirstName(String firstName);
    public String getLastName();
    public void setLastName(String lastName);
    public String getJob();
    public void setJob( String jobId );
    public double getSalary();
    public void setSalary( double salary );
    public int getDepartment();
    public void setDepartment(int departmentId);
}
