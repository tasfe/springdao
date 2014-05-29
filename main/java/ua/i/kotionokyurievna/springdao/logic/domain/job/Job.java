/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.i.kotionokyurievna.springdao.logic.domain.job;

/**
 *
 * @author Kateryna_Reznik
 */
public class Job implements JobI{
    private int jobId;
    private String jobTitle;
    private Double minSalary;
    private Double maxSalary;
    
    public Job(){
        minSalary = new Double(0.0);
        maxSalary = new Double(0.0);
    }
    
     
    public Job( String jobTitle, Double minSalary, Double maxSalary){
        this.jobTitle = jobTitle;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public void setJobTitle(String name) {
        this.jobTitle = name;
    }

    @Override
    public Double getMinSalary() {
        return minSalary;
    }

    @Override
    public boolean setMinMaxSalary(Double minSalary, Double maxSalary) {
        if ( minSalary.doubleValue() <= maxSalary.doubleValue() && 
                minSalary.doubleValue() >= 0 &&
                maxSalary.doubleValue() >= 0){
                this.minSalary = minSalary;
                this.maxSalary = maxSalary;
                return true;
        } 
        return false;
    }

    @Override
    public Double getMaxSalary() {
        return maxSalary;
    }
    
    @Override
    public boolean equals ( Object obj ){
        if ( obj != null && getClass() == obj.getClass() ){
            Job other = (Job) obj;
            return other.jobTitle.equals(jobTitle);
        } 
        return false;
    }

    @Override
    public String toString(){
        return "Job " + jobTitle + ", min salary = " + minSalary +
                ", max salary " + maxSalary;
    }  
}
