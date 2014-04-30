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
public class EmployeeRepositoryJDBC implements EmployeeRepository{

    @Override
    public List<EmployeeI> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<EmployeeI> findByName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
