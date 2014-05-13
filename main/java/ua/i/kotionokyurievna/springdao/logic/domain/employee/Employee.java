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
public class Employee implements EmployeeI{

    private String firstName;
    private String lastName;
    private String jobId;
    private double salary;
    private int departmentId;
    
    public Employee(){
        
    }
    
    public Employee( String firstName, String lastName, String jobId, 
            double salary, int departmentId){
        setFirstName(firstName);
        setLastName(lastName);
        setJob(jobId);
        setSalary(salary);
        setDepartment(departmentId);
    }
    
    @Override
    public String getFirstName() {
        return firstName.substring(0);
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName.substring(0);
    }

    @Override
    public String getLastName() {
        return lastName.substring(0);
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0);
    }

    public String getJob() {
        return jobId.substring(0);
    }

    public void setJob(String jobId) {
        this.jobId = jobId.substring(0);;
    }

    public int getDepartment() {
        return departmentId;
    }

    public void setDepartment(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

      
    @Override 
    public String toString(){
        return "Employee " + getFirstName() + " " + getLastName() + ", " +
                getJob() +  ", " + 
                getDepartment() + ", " + 
                getSalary();
    }
    
    @Override
    public boolean equals( Object obj ){
        if ( obj != null && getClass() == obj.getClass() ){
            Employee other = (Employee) obj;
            return other.firstName.equals(firstName) && 
                    other.lastName.equals(lastName) && 
                    other.jobId.equals(jobId) && 
                    other.departmentId == departmentId;
        }
        return false;
    }
    
}
