/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.domain.job;

/**
 *
 * @author Kateryna_Reznik
 */
public interface JobI {
    public String getJobTitle();
    public void setJobTitle( String name );
    public Double getMinSalary();
    public boolean setMinMaxSalary( Double minSalary, Double maxSalary );
    public Double getMaxSalary();
}
