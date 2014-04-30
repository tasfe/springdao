/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.daospring.logic;

/**
 *
 * @author Kateryna_Reznik
 */
public class Employee implements EmployeeI{
    private String firstName;
    private String lastName;
    private JobI job;
    private double salary;
    private DepartmentI department;
    
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

    @Override
    public JobI getJob() {
        return job;
    }

    @Override
    public void setJob(JobI job) {
         this.job = job;
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
    public DepartmentI getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(DepartmentI department) {
        this.department = department;
    }
    
    @Override 
    public String toString(){
        return "Employee " + getFirstName() + " " + getLastName() + ", " +
                getJob() +  ", " + getDepartment().toString() + ", " + 
                getSalary();
    }
    
    @Override
    public boolean equals( Object obj ){
        if ( obj != null && getClass() == obj.getClass() ){
            Employee other = (Employee) obj;
            return other.firstName.equals(firstName) && 
                    other.lastName.equals(lastName) && 
                    other.job.equals(job) && other.department.equals(department);
        }
        return false;
    }
    
}
