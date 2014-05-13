/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.repository.job;

import java.util.List;
import ua.i.kotionokyurievna.springdao.logic.domain.job.JobI;

/**
 *
 * @author Kateryna_Reznik
 */
public interface JobRepository {
    public boolean create( JobI job );
    public List<JobI> findByTitle( String jobTitle );
    public List<JobI> findBySalary( double salary );
}
