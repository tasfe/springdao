package ua.i.kotionokyurievna.springdao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.i.kotionokyurievna.springdao.logic.repository.employee.EmployeeRepository;
import ua.i.kotionokyurievna.springdao.logic.domain.employee.EmployeeI;
import ua.i.kotionokyurievna.springdao.logic.domain.job.JobI;
import ua.i.kotionokyurievna.springdao.logic.repository.job.JobRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext appCtx = 
                new ClassPathXmlApplicationContext("persistenceContext.xml");
        
        System.out.println("All ");
        EmployeeRepository repository = appCtx.getBean
                ("employeeRepository", EmployeeRepository.class);
        JobRepository jobRepository = appCtx.getBean
                ("jobRepository", JobRepository.class);
        List<EmployeeI> employees = repository.findAll();
        for (EmployeeI employee : employees) {
            System.out.println(employee);
        }
        
        List<EmployeeI> employeeByName = repository.findByName("John", "Chen");
        System.out.println("\n Find JOHN CHEN");
        if (employeeByName.isEmpty()) {
             System.out.println("There is no JOHN CHEN");
        }
        else{
            for (EmployeeI employee : employeeByName) {
                JobI job = jobRepository.findById(employee.getJob());
                System.out.println(employee);
                System.out.println(job);
            }
        }
        
        
        
    }
}
