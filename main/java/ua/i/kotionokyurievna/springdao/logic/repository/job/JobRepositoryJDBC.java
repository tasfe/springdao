/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.repository.job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.i.kotionokyurievna.springdao.logic.domain.job.Job;
import ua.i.kotionokyurievna.springdao.logic.domain.job.JobI;
import ua.i.kotionokyurievna.springdao.logic.repository.jdbc.DAOJDBCUtil;

/**
 *
 * @author Kateryna_Reznik
 */
@Repository( "employeeRepository")
public class JobRepositoryJDBC implements JobRepository{
    
    @Autowired
    private DataSource ds;
    
    public JobRepositoryJDBC(){
        
    }
    
    public JobRepositoryJDBC ( DataSource ds){
        this.ds = ds;
    }
    
    public boolean create(JobI job) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Jobs "
                    + "(job_title, min_salary, max_salary) "+
                    "VALUES (?, ?, ?)");
            preparedStatement.setString(1, job.getJobTitle());
            preparedStatement.setDouble(2, job.getMinSalary());
            preparedStatement.setDouble(3, job.getMaxSalary());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }
        return false;
    }

    public List<JobI> findByTitle(String jobTitle) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<JobI> jobs = new ArrayList<JobI>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement
                    ("SELECT j.job_id, j.job_title, j.min_salary, " +
                    "j.max_salary "+
                    "FROM jobs j " +
                    "WHERE j.job_title = ?");
            preparedStatement.setString(1, jobTitle);
            resultSet = preparedStatement.executeQuery();
                      
            while (resultSet.next()) {
                jobs.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOJDBCUtil.close(resultSet);
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }
        
        return jobs;
    }

    public List<JobI> findBySalary(double salary) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<JobI> jobs = new ArrayList<JobI>();

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement
                    ("SELECT j.job_id, j.job_title, j.min_salary, " +
                    "j.max_salary "+
                    "FROM jobs j " +
                    "WHERE j.min_salary >= ? AND j.max_salary <= ?");
            preparedStatement.setDouble(1, salary);
            preparedStatement.setDouble(2, salary);
            resultSet = preparedStatement.executeQuery();
                      
            while (resultSet.next()) {
                jobs.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOJDBCUtil.close(resultSet);
            DAOJDBCUtil.close(preparedStatement);
            DAOJDBCUtil.close(connection);
        }
        
        return jobs;
    }
    
    private JobI map(ResultSet resultSet) throws SQLException {
        JobI job = new Job();
        job.setJobTitle(resultSet.getString(1));
        job.setMinMaxSalary(resultSet.getDouble(2), resultSet.getDouble(2));
        return job;
    }
    
}
