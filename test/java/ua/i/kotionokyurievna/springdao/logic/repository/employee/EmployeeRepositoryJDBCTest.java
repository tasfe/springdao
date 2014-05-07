/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.repository.employee;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.i.kotionokyurievna.springdao.logic.domain.employee.*;
import ua.i.kotionokyurievna.springdao.logic.repository.DAOTestsTemplate;

/**
 *
 * @author Kateryna_Reznik
 */
public class EmployeeRepositoryJDBCTest extends DAOTestsTemplate {
        
    @Autowired
    private EmployeeRepository employeeRepository;
        
    @Before
    public void clearDB(){
        jdbcTemplate.execute("TRUNCATE TABLE Employees");
    }    
    
    
    @Test
    public void testCreateStudentNoExceptions() {
        EmployeeI employee = new Employee("John", "Pain", "IT", 430.00, 2);                
        employeeRepository.create(employee);
    }
    /**
     * Test of findAll method, of class EmployeeRepositoryJDBC.
     */
    @Test
    public void testFindAllNoOneNameInDatabaseExpectedListSize0() {
         List<EmployeeI> actualResult = employeeRepository.findAll();
         Assert.assertEquals(0, actualResult.size());
    }
    
    @Test
    public void testFindAllSeveralEmployeesInDatabaseExpectedRespectedListSize() {
        EmployeeI employee1 = new Employee("John", "Pain", "IT", 430.00, 2);
        EmployeeI employee2 = new Employee("John", "Pain", "Robot", 470.00, 1);
        EmployeeI employee3 = new Employee("John", "Pain", "Supp", 370.00, 3);
        employeeRepository.create(employee1);
        employeeRepository.create(employee2);
        employeeRepository.create(employee3); 
        List<EmployeeI> actualResult = employeeRepository.findAll();
         Assert.assertEquals(3, actualResult.size());
    }
    

    /**
     * Test of findByName method, of class EmployeeRepositoryJDBC.
     */
    @Test
    public void testFindByNameWhen1SuchNameInDatabaseExpectedListSize1() {
        EmployeeI employee = new Employee("John", "Pain", "IT", 430.00, 2);                
        employeeRepository.create(employee);
        
        List<EmployeeI> actualResult = employeeRepository.findByName("John", "Pain");
        Assert.assertEquals(1, actualResult.size());        
    }
    
    @Test
    public void testFindByNameWhenSeveralTheseNamesInDatabaseExpectedListSizeMore1() {
        EmployeeI employee1 = new Employee("John", "Pain", "IT", 430.00, 2);
        EmployeeI employee2 = new Employee("John", "Pain", "Robot", 470.00, 1);
        EmployeeI employee3 = new Employee("John", "Pain", "Supp", 370.00, 3);
        employeeRepository.create(employee1);
        employeeRepository.create(employee2);
        employeeRepository.create(employee3);
        
        List<EmployeeI> actualResult = employeeRepository.findByName("John", "Pain");
        Assert.assertEquals(3, actualResult.size());        
    }
    
    @Test
    public void testFindByNameFirstNameIsInDatabaseButNotSecondExpectedListSize0() {
        EmployeeI employee1 = new Employee("John", "Retro", "IT", 430.00, 2);
        EmployeeI employee2 = new Employee("John", "Joy", "Robot", 470.00, 1);
        EmployeeI employee3 = new Employee("John", "Happy", "Supp", 370.00, 3);
        employeeRepository.create(employee1);
        employeeRepository.create(employee2);
        employeeRepository.create(employee3);
        
        List<EmployeeI> actualResult = employeeRepository.findByName("John", "Pain");
        Assert.assertEquals(0, actualResult.size());        
    }
    
    @Test
    public void testFindByNameNoSuchNameIsInDatabaseExpectedListSize0() {
        EmployeeI employee1 = new Employee("Sasha", "Pain", "IT", 430.00, 2);
        EmployeeI employee2 = new Employee("John", "Joy", "Robot", 470.00, 1);
        EmployeeI employee3 = new Employee("Kira", "Happy", "Supp", 370.00, 3);
        employeeRepository.create(employee1);
        employeeRepository.create(employee2);
        employeeRepository.create(employee3);
        
        List<EmployeeI> actualResult = employeeRepository.findByName("John", "Pain");
        Assert.assertEquals(0, actualResult.size());        
    }
}
