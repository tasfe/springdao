/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.daospring.logic;

/**
 *
 * @author Kateryna_Reznik
 */
public class Job implements JobI{
    private String jobTitle;
    private double minSalary;
    private double maxSalary;
    
    public Job(){}
    
    public Job( String jobTitle, double minSalary, double maxSalary){
        setJobTitle(jobTitle);
        setMinMaxSalary(minSalary, maxSalary);
        
    }

    @Override
    public String getJobTitle() {
        return jobTitle.substring(0);
    }

    @Override
    public void setJobTitle(String name) {
        this.jobTitle = name.substring(0);
    }

    @Override
    public double getMinSalary() {
        return minSalary;
    }

    @Override
    public boolean setMinMaxSalary(double minSalary, double maxSalary) {
        if ( ( minSalary <= maxSalary ) && ( minSalary >= 0 ) && ( maxSalary <= 0 ) ){
            this.minSalary = minSalary;
            this.maxSalary = maxSalary;
        }
        return false;
    }

    @Override
    public double getMaxSalary() {
        return maxSalary;
    }
    
    @Override
    public boolean equals ( Object obj ){
        if ( obj != null && getClass() == obj.getClass() ){
            Job other = (Job) obj;
            return other.jobTitle.equals(jobTitle) &&
                    other.maxSalary == maxSalary &&
                    other.minSalary == minSalary;
        } 
        return false;
    }

    @Override
    public String toString(){
        return "Job " + jobTitle + ", min salary = " + minSalary +
                ", max salary " + maxSalary;
    }  
}
