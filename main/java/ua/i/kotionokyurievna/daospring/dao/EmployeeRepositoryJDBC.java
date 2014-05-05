/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.daospring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.i.kotionokyurievna.daospring.logic.EmployeeI;
import ua.i.kotionokyurievna.daospring.logic.Employee;
import ua.i.kotionokyurievna.daospring.logic.Department;
import ua.i.kotionokyurievna.daospring.logic.Job;

/**
 *
 * @author Kateryna_Reznik
 */
@Repository( "employeeRepository")
public class EmployeeRepositoryJDBC implements EmployeeRepository{
    @Autowired
    private DataSource ds;
    
    public EmployeeRepositoryJDBC(){
        
    }
    
    public EmployeeRepositoryJDBC( DataSource ds ){
        this.ds = ds;
    }
    
    
    
    @Override
    public List<EmployeeI> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<EmployeeI> employees = new ArrayList<EmployeeI>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement
                    ("SELECT employees.first_name, employees.last_name, jobs.job_title, employees.salary, departments.department_name "+
                    "FROM jobs, employees, departments " +
                    "WHERE employees.department_id = departments.department_id AND employees.job_id = jobs.job_id");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOJDBCUtil.close(resultSet);
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }

        return employees;
    }
    
    private EmployeeI map(ResultSet resultSet) throws SQLException {
        EmployeeI employee = new Employee();
        employee.setFirstName(resultSet.getString(1));
        employee.setLastName(resultSet.getString(2));
        employee.setJob(new Job(resultSet.getString(3)));
        employee.setSalary(resultSet.getDouble(4));
        employee.setDepartment(new Department(resultSet.getString(5)));
        return employee;
    }

    @Override
    public List<EmployeeI> findByName( String firstName, String lastName ) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<EmployeeI> employees = new ArrayList<EmployeeI>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement
                    ("SELECT e.first_name, e.last_name, e.job_id, e.salary, e.department_id "+
                    "FROM employees e " +
                    "WHERE e.first_name = ? AND e.last_name = ?");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            resultSet = preparedStatement.executeQuery();
                      
            while (resultSet.next()) {
                employees.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOJDBCUtil.close(resultSet);
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }
        
        return employees;
    }
    
}
