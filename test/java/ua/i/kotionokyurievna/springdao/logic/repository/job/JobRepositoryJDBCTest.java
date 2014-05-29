/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.repository.job;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.i.kotionokyurievna.springdao.logic.domain.job.Job;
import ua.i.kotionokyurievna.springdao.logic.domain.job.JobI;
import ua.i.kotionokyurievna.springdao.logic.repository.DAOTestsTemplate;

/**
 *
 * @author Kateryna_Reznik
 */
public class JobRepositoryJDBCTest extends DAOTestsTemplate{
    
    @Autowired
    private JobRepository jobRepository;
        
    @Before
    public void clearDB(){
        jdbcTemplate.execute("TRUNCATE TABLE Jobs");
    }  
    
    /**
     * Test of create method, of class JobRepositoryJDBC.
     */
    @Test
    public void testCreateNoExceptions() {
        JobI job = new Job("programmer",new Double (100.0), new Double(800.0));                
        boolean fl = jobRepository.create(job);
        Assert.assertEquals(true, fl);
    }

    /**
     * Test of findByTitle method, of class JobRepositoryJDBC.
     */
    @Test
    public void testFindByTitleNoOneJobInDBExpectedEmptyList() {
        int expectedResult = 0;
        List<JobI> actualResult = jobRepository.findByTitle("programmer");
        Assert.assertEquals(expectedResult, actualResult.size());
    }

    @Test
    public void testByTitleNoSuchJobTitleInDBExpectedEmptyList(){
        JobI job1 = new Job("programmer", new Double (100.0), new Double (800.0)); 
        JobI job2 = new Job("clean_lady", new Double (90.0), new Double (500.0));
        JobI job3 = new Job("CEO", new Double (600.0), new Double (8000.0));
        jobRepository.create(job1);
        jobRepository.create(job2);
        jobRepository.create(job3);
        
        int expectedResult = 0;
        List<JobI> actualResult = jobRepository.findByTitle("cook");
        Assert.assertEquals(expectedResult, actualResult.size());
    }
    
    @Test
    public void testByTitleSuchJobTitleInDBExpectedRespectivelyListSize(){
        JobI job1 = new Job("programmer", new Double (100.0), new Double (800.0)); 
        JobI job2 = new Job("programmer", new Double (90.0), new Double (500.0));
        JobI job3 = new Job("CEO", new Double (600.0), new Double (8000.0));
        jobRepository.create(job1);
        jobRepository.create(job2);
        jobRepository.create(job3);
        
        int expectedResult = 2;
        List<JobI> actualResult = jobRepository.findByTitle("programmer");
        Assert.assertEquals(expectedResult, actualResult.size());
    }
    /**
     * Test of findBySalary method, of class JobRepositoryJDBC.
     */
    @Test
    public void testFindBySalaryLessThanAllSalariesEmptyListExpected() {
        JobI job1 = new Job("programmer", new Double (100.0), new Double (800.0)); 
        JobI job2 = new Job("clean_lady", new Double (90.0), new Double (500.0));
        JobI job3 = new Job("CEO", new Double (600.0), new Double (8000.0));
        jobRepository.create(job1);
        jobRepository.create(job2);
        jobRepository.create(job3);
        
        int expectedResult = 0;
        List<JobI> actualResult = jobRepository.findBySalary(new Double(89.9));
        Assert.assertEquals(expectedResult, actualResult.size());
    }
    
    @Test
    public void testFindBySalarySmallestBoundaryRespectivelySizeListExpected() {
        JobI job1 = new Job("programmer", new Double (100.0), new Double (800.0)); 
        JobI job2 = new Job("clean_lady", new Double (90.0), new Double (500.0));
        JobI job3 = new Job("CEO", new Double (600.0), new Double (8000.0));
        jobRepository.create(job1);
        jobRepository.create(job2);
        jobRepository.create(job3);
        
        int expectedResult = 1;
        List<JobI> actualResult = jobRepository.findBySalary(new Double(90.0));
        Assert.assertEquals(expectedResult, actualResult.size());
    }
    
    @Test
    public void testFindBySalaryHighestBoundTestRespectivelyListSizeExpected() {
        JobI job1 = new Job("programmer", new Double (100.0), new Double (800.0)); 
        JobI job2 = new Job("clean_lady", new Double (90.0), new Double (500.0));
        JobI job3 = new Job("CEO", new Double (600.0), new Double (8000.0));
        jobRepository.create(job1);
        jobRepository.create(job2);
        jobRepository.create(job3);
        
        int expectedResult = 1;
        List<JobI> actualResult = jobRepository.findBySalary(1000.0);
        Assert.assertEquals(expectedResult, actualResult.size());
    }
    
    @Test
    public void testFindBySalaryMoreThanAllSalariesEmptyListExpected() {
        JobI job1 = new Job("programmer", new Double (100.0), new Double (800.0)); 
        JobI job2 = new Job("clean_lady", new Double (90.0), new Double (500.0));
        JobI job3 = new Job("CEO", new Double (600.0), new Double (8000.0));
        jobRepository.create(job1);
        jobRepository.create(job2);
        jobRepository.create(job3);
        
        int expectedResult = 0;
        List<JobI> actualResult = jobRepository.findBySalary(8000.1);
        Assert.assertEquals(expectedResult, actualResult.size());
    }
    
    
}
