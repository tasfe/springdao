package ua.i.kotionokyurievna.springdao;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.i.kotionokyurievna.springdao.logic.repository.employee.EmployeeRepository;
import ua.i.kotionokyurievna.springdao.logic.repository.employee.EmployeeRepositoryJDBC;
import ua.i.kotionokyurievna.springdao.logic.domain.employee.EmployeeI;

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
        EmployeeRepository repository = appCtx.getBean("employeeRepository", EmployeeRepository.class);
        /*List<EmployeeI> employees = repository.findAll();
        for (EmployeeI employee : employees) {
            System.out.println(employee);
        }*/
        
  
        
        List<EmployeeI> employeeByName = repository.findByName("John", "Chen");
        System.out.println("\n Find JOHN CHEN");
        if (employeeByName.isEmpty()) {
             System.out.println("There is no JOHN CHEN");
        }
        else{
            for (EmployeeI employee : employeeByName) {
                System.out.println(employee);
            }
        }
    }
}
