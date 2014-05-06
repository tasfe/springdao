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
        jdbcTemplate.execute("TRUNCATE TABLE Employee");
    }    
    /**
     * Test of findAll method, of class EmployeeRepositoryJDBC.
     */
    
    @Test
    public void testCreateStudentNoExceptions() {
        EmployeeI employee = new Employee("John", "Pain", "IT", 430.00, 2);                
        employeeRepository.create(employee);
    }
    
    @Test
    public void testFindAll() {
        
    }

    /**
     * Test of findByName method, of class EmployeeRepositoryJDBC.
     */
    @Test
    public void testFindByName() {
        
        List<EmployeeI> actualResult = employeeRepository.findByName("ABC", "BC");
        Assert.assertEquals(0, actualResult.size());
        
    }
}
