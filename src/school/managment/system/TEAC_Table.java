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
public class TEAC_Table {
    
    String  teach_name,teach_id,teac_Email,teac_Pass,Teac_Job,teac_Salary,teac_Profile;
    public TEAC_Table(String teach_name, String teach_id, String teac_Email, String teac_Pass, String Teac_Job, String teac_Salary, String teac_Profile){
        this.teach_name=teach_name;
        this.teach_id=teach_id;
        this.teac_Email=teac_Email;
        this.teac_Pass=teac_Pass;
        this.Teac_Job=Teac_Job;
        this.teac_Salary=teac_Salary;
        this.teac_Profile=teac_Profile;
    }

    TEAC_Table(String string, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getTeach_name(){
        return teach_name;
    }
    public void setTeach_name(String teach_name){
        this.teach_name=teach_name;
    }
    public String getTeach_id(){
        return teach_id;
    }
    public void setTeach_id(String teach_id){
        this.teach_id=teach_id;
    }
    public String getTeac_Email(){
        return teac_Email;
    }
    public void setTeac_Email(String teac_Email){
        this.teac_Email=teac_Email;
    }
    public String getTeac_Pass(){
        return teac_Pass;
    }
    public void setTeac_Pass(String teac_Pass){
        this.teac_Pass=teac_Pass;
    }
    public String getTeac_Job(){
        return Teac_Job;
    }    
    public void setTeac_Job(String Teac_Job){
        this.Teac_Job=Teac_Job;
    }    
    public String getTeac_Salary(){
        return teac_Salary;
      }    
    public void setTeac_Salary(String teac_Salary){
        this.teac_Salary=teac_Salary;
    }  
    public String getTeac_Profile(){
        return teac_Profile;
      }    
    public void setTeac_Profile(String teac_Profile){
        this.teac_Profile=teac_Profile;
    }  
    
}
