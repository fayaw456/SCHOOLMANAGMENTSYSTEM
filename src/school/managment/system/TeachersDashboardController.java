/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.managment.system;

import school.managment.system.WelcomController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author W10X64_AUG-2020
 */
public class TeachersDashboardController implements Initializable {

    @FXML
    private TextField email;
    
    @FXML
    private AnchorPane Activity;

    @FXML
    private Button actvity_btn;

    @FXML
    private AnchorPane teachCommednt;

    @FXML
    private Button teacherComment_btn;

    @FXML
    private AnchorPane teacherProfile;

    @FXML
    private Button teacherProfile_btn;
    
    @FXML
    private TextField stud_id;

    @FXML
    private TextField stud_id1;
    
    @FXML
    private TextField teac_id;

    @FXML
    private TextField teac_name;

    @FXML
    private TextField teac_pass;
    
    @FXML
    private TextField teac_class;
    
    private Connection conn;
    private Statement st;
    private PreparedStatement prs;
    private ResultSet result;
    
        public void exit1(){
        System.exit(0);
    }
    
        public void frame (ActionEvent event) {

        if (event.getSource() == teacherProfile_btn) {

        teacherProfile.setVisible(true);
        Activity.setVisible(false);
        teachCommednt.setVisible(false);
        } else if (event.getSource() == actvity_btn) {

        teacherProfile.setVisible(false);
        Activity.setVisible(true);
        teachCommednt.setVisible(false);
        } else if (event.getSource() == teacherComment_btn) {

        teacherProfile.setVisible(false);
        Activity.setVisible(false);
        teachCommednt.setVisible(true);
        } 
        }
    
       public void LOGOUT(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(WelcomController.class.getResource("Welcom.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }  
       WelcomController wb = new WelcomController();
       String idid = WelcomController.getId();
       
       public void show(ActionEvent event) throws Exception {
       
        DBConnectionC db = new DBConnectionC();
       conn = db.connMethod();
   String sql = "SELECT TEACHER_NAME, PASSWORD, TEACHER_ID, TEACHER_CLASS FROM `teacher_table` WHERE TEACHER_ID ='"+idid+"'";
        
        try {
            result = conn.createStatement().executeQuery(sql);
            while (result.next()) {
                teac_name.setText(result.getString(1));
                teac_pass.setText(result.getString(2));
                teac_id.setText(result.getString(3));
                teac_class.setText(result.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
           
       public void edit(ActionEvent event) throws ClassNotFoundException{
            
            DBConnectionC db = new DBConnectionC();
            conn = db.connMethod();
            String sql = "UPDATE `teacher_table` SET `PASSWORD`= ? WHERE `TEACHER_ID`= '"+idid+"'";
            //String sql = "INSERT INTO `student_table`(`STUDENT_NAME`, `PASSWORD`) VALUES (?,?)";
                //String lbl = teac_name.getText();
                String lbl1 = teac_pass.getText();
                //String lbl2 = teac_id.getText();
                    try { 
                        prs = conn.prepareStatement(sql);
                        //prs.setString(1, lbl);
                        prs.setString(1, lbl1);
                        //prs.setString(3, lbl2);
                        int i = prs.executeUpdate();
                        if (i == 1) {

                     JOptionPane.showMessageDialog(null, "Data Edited succsecfully");
                        }

                    } catch (SQLException ex) {
                        
                     JOptionPane.showMessageDialog(null, "Try again!!");
        }}
       
       public void InsertResult () throws ClassNotFoundException, SQLException{
             String a= stud_id.getText();
             String b= stud_id1.getText();
            DBConnectionC db = new DBConnectionC();

           
              try {            
                  conn = db.connMethod();
                  String sql= "Select t.TEACHER_NAME, c.Subject1 From teacher_table AS t, grade_table AS c WHERE t.TEACHER_CLASS=c.Grade";
            result = conn.createStatement().executeQuery(sql);
             while (result.next()){
               String q1="select JOB from `teacher_table`where EMAIL='"+email.getText()+"' ";
                 result = conn.createStatement().executeQuery(q1);
                 while(result.next()){ 
                 if (result.getString("JOB").equals("Amharic")) {
                     String sql1 = "UPDATE `resultt_table` SET `Amharic`='" + b + "' WHERE Stud_ID = '" + a + "'";
                     prs = conn.prepareStatement(sql1);
                     prs.executeUpdate();

                 } else if (result.getString("JOB").equals("English")) {
                     String sql1 = "UPDATE `resultt_table` SET `English`='" + b + "' WHERE Stud_ID = '" + a + "'";
                     prs = conn.prepareStatement(sql1);
                     prs.executeUpdate();

                 } else if (result.getString("JOB").equals("Maths")) {
                     String sql1 = "UPDATE `resultt_table` SET `Maths`='" + b + "' WHERE Stud_ID = '" + a + "'";
                     prs = conn.prepareStatement(sql1);
                     prs.executeUpdate();

                 } else if (result.getString("JOB").equals("Science")) {
                     String sql1 = "UPDATE `resultt_table` SET `Science`='" + b + "' WHERE Stud_ID = '" + a + "'";
                     prs = conn.prepareStatement(sql1);
                     prs.executeUpdate();
                     JOptionPane.showMessageDialog(null, "Result Inserted succsecfully");
                 }}} 
             
              } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Occured");
        }

       }
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
