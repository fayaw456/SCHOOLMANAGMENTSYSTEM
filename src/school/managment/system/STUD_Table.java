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
public class STUD_Table {
 String  stu_name,stu_id,stud_pass,stud_pro;
    public STUD_Table(String stu_name, String stu_id, String stud_pass, String stud_pro){
        this.stu_name=stu_name;
        this.stu_id=stu_id;
        this.stud_pass=stud_pass;
        this.stud_pro=stud_pro;

    }
    public String getStu_name(){
        return stu_name;
    }
    public void setStu_name(String stu_name){
        this.stu_name=stu_name;
    }
    public String getStu_id(){
        return stu_id;
    }
    public void setStu_id(String stu_id){
        this.stu_id=stu_id;
    }
    public String getStud_pass(){
        return stud_pass;
    }
    public void setstud_pass(String stud_pass){
        this.stud_pass=stud_pass;
    }
    public String getStud_pro(){
        return stud_pro;
    }
    public void setStud_pro(String stud_pro){
        this.stud_pro=stud_pro;
    }  
}
