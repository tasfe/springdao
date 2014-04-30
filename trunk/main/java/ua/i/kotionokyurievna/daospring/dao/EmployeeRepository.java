/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.daospring.dao;

import java.util.List;
import ua.i.kotionokyurievna.daospring.logic.EmployeeI;

/**
 *
 * @author Kateryna_Reznik
 */
public interface EmployeeRepository {
    public List<EmployeeI> findAll();
    public List<EmployeeI> findByName();
}
