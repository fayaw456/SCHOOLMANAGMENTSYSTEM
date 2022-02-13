/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.managment.system;

/**
 *
 * @author W10X64_AUG-2020
 */
public class OTHER_Table {
    String  other_Name,other_Id,other_pass,other_pro,other_job,other_salary;
    public OTHER_Table(String other_Name, String other_Id, String other_pass, String other_pro, String other_job, String other_salary){
        this.other_Name=other_Name;
        this.other_Id=other_Id;
        this.other_pass=other_pass;
        this.other_pro=other_pro;
        this.other_job=other_job;
        this.other_salary=other_salary;
    }
    public String getOther_Name(){
        return other_Name;
    }
    public void setOther_Name(String other_Name){
        this.other_Name=other_Name;
    }
    public String getOther_Id(){
        return other_Id;
    }
    public void setOther_Id(String other_Id){
        this.other_Id=other_Id;
    }
    public String getOther_pass(){
        return other_pass;
    }
    public void setOther_pass(String other_pass){
        this.other_pass=other_pass;
    }
    public String getOther_pro(){
        return other_pro;
    }
    public void setOther_pro(String other_pro){
        this.other_pro=other_pro;
    }   
    public String getOther_job(){
        return other_job;
    }
    public void setOther_job(String other_job){
        this.other_job=other_job;
    }
    public String getOther_salary(){
        return other_salary;
    }
    public void setOther_salary(String other_salary){
        this.other_salary=other_salary;
    }    
}
