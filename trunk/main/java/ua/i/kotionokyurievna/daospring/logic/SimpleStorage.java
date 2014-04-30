/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.daospring.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kateryna_Reznik
 */
public class SimpleStorage {
    private List< EmployeeI > employees;
    private List< DepartmentI > departments;
    private List< JobI > jobs;
    private List< LocationI > locations;
    
    public SimpleStorage(){
        employees = new ArrayList<EmployeeI> ();
        departments = new ArrayList<DepartmentI>();
        jobs = new ArrayList<JobI>();
        locations = new ArrayList<LocationI>();
    }
    
    public boolean addEmployee( EmployeeI employee ){
        if ( !employees.contains(employee )){
            employees.add(employee);
            return true;
        }
        return false;
    }
    
    public boolean addDepartment ( DepartmentI department ){
        if ( !departments.contains(department)){
            departments.add(department);
            return true;
        }
        return false;
    }
    
    public boolean addJob ( JobI job ){
        if ( !jobs.contains(job)){
            jobs.add(job);
            return true;
        }
        return false;
    }
    
    public boolean addLocation( LocationI location ){
        if ( !locations.contains(location) ){
            locations.add(location);
            return true;
        }
        return false;
    }
    
}
