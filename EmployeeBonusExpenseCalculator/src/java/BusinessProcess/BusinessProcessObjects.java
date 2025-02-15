/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessProcess;

/**
 *
 * @author Munzhedzi Munyadziwa Petrus
 */
public class BusinessProcessObjects {
    
    private double salary;
    private String jobRole;

    
    
    //Bonus Percentages: 
    private final double MANAGER_BONUS = 20/100;
    private final double DEVELOPER_BONUS = 15/100;
    private final double INTERN_BONUS = 5/100;
    
    //Overall Deductions:
    private final double TAX_DEDUCTIONS = 18/100;
    private final double MEDICAL_DEDUCTIONS = 5/100;
    private final double RETIREMENT_DEDUCTIONS = 7/100;

    public BusinessProcessObjects(double salary, String jobRole) {
        this.salary = salary;
        this.jobRole = jobRole;
    }
    
    
    public double calculateTotalExpense(){
        double answer  = 0.0;
        
        if(jobRole.equalsIgnoreCase("Manager")){
            
            answer = (salary + (MANAGER_BONUS*salary)) - (TAX_DEDUCTIONS*salary) - (MEDICAL_DEDUCTIONS*salary) - (RETIREMENT_DEDUCTIONS*salary);
        }
        
        else if(jobRole.equalsIgnoreCase("Developer")){
            
            answer = (salary + (DEVELOPER_BONUS*salary)) - (TAX_DEDUCTIONS*salary) - (MEDICAL_DEDUCTIONS*salary) - (RETIREMENT_DEDUCTIONS*salary);
        }
        
        else if(jobRole.equalsIgnoreCase("Intern")){
            
            answer = (salary + (INTERN_BONUS*salary)) - (TAX_DEDUCTIONS*salary) - (MEDICAL_DEDUCTIONS*salary) - (RETIREMENT_DEDUCTIONS*salary);
        }
        
        
        return answer;
    }
}
