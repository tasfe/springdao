/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.daospring.logic;

/**
 *
 * @author Kateryna_Reznik
 */
public interface JobI {
    public String getJobTitle();
    public void setJobTitle( String name );
    public double getMinSalary();
    public boolean setMinMaxSalary( double minSalary, double maxSalary );
    public double getMaxSalary();
}
