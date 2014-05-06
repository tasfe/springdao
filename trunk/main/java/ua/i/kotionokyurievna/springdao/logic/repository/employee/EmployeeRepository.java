/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.repository.employee;

import java.util.List;
import ua.i.kotionokyurievna.springdao.logic.domain.employee.EmployeeI;

/**
 *
 * @author Kateryna_Reznik
 */
public interface EmployeeRepository {
    public List<EmployeeI> findAll();
    public List<EmployeeI> findByName( String firstName, String lastName );
}
