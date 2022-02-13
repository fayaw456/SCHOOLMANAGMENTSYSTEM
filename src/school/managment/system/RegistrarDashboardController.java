/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.managment.system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author W10X64_AUG-2020
 */
public class RegistrarDashboardController implements Initializable {

    static String IDNo;
    @FXML
    private Button view_btn;

    @FXML
    private Button employeeTable_btn;

    @FXML
    private AnchorPane employeetable;

    @FXML
    private Button studentTable_btn;

    @FXML
    private AnchorPane studentframe;

    @FXML
    private AnchorPane teacherframe;

    @FXML
    private Button teachersTable_btn;

    @FXML
    private TextField stud_id;

    @FXML
    private TextField stud_name;

    @FXML
    private TextField stud_pass;
    
    @FXML
    private TextField stud_class;
    
    @FXML
    private TextField teac_email;

    @FXML
    private TextField teac_id;

    @FXML
    private TextField teac_job;

    @FXML
    private TextField teac_name;

    @FXML
    private TextField teac_pass;
    
    @FXML
    private TextField teac_class;

    @FXML
    private TextField teac_salary;

    @FXML
    private TextField other_id;

    @FXML
    private TextField other_job;

    @FXML
    private TextField other_name;

    @FXML
    private TextField other_pass;

    @FXML
    private TextField other_salary;
    
    private double x = 0;
    private double y = 0;
    
    private Connection conn;
    private Statement st;
    private PreparedStatement prs;
    private ResultSet result;

    public void exit1() {
        System.exit(0);
    }

    public void frame(ActionEvent event) {

        if (event.getSource() == studentTable_btn) {

            studentframe.setVisible(true);
            teacherframe.setVisible(false);
            employeetable.setVisible(false);
        } else if (event.getSource() == teachersTable_btn) {

            studentframe.setVisible(false);
            teacherframe.setVisible(true);
            employeetable.setVisible(false);
        } else if (event.getSource() == employeeTable_btn) {

            studentframe.setVisible(false);
            teacherframe.setVisible(false);
            employeetable.setVisible(true);
        }
    }

    public void LOGOUT(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(RegistrarController.class.getResource("registrar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
      
    }

    public void view_next(ActionEvent event) throws IOException {    
        FXMLLoader fxmlLoader = new FXMLLoader(TestController.class.getResource("Test.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
/////////////////////////////////////////STUDENT-REGISTRATION///////////////////////////////////////////////

    public void Register(ActionEvent event) throws ClassNotFoundException {

        DBConnectionC db = new DBConnectionC();
        conn = db.connMethod();
        String sql = "INSERT INTO `student_table`(`STUDENT_NAME`, `STUDENT_ID`, `PASSWORD`, `STUDENT_CLASS`) VALUES (?,?,?,?)";
        String lbl = stud_name.getText();
        String lbl1 = stud_id.getText();
        String lbl2 = stud_pass.getText();
         String lbl3 = stud_class.getText();
        //String lbl4 = stud_id.getText();
        try {
            prs = conn.prepareStatement(sql);
            prs.setString(1, lbl);
            prs.setString(2, lbl1);
            prs.setString(3, lbl2);
             prs.setString(4, lbl3);
            int i = prs.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Data Inserted succsecfully");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
    }

    public void Update(ActionEvent event) throws ClassNotFoundException {

        DBConnectionC db = new DBConnectionC();
        conn = db.connMethod();

        String sql = "UPDATE `student_table` SET `STUDENT_NAME`= ?, `STUDENT_ID`= ?, `STUDENT_CLASS`= ? WHERE `STUDENT_ID`='" + stud_id.getText() + "'";
        String lbl = stud_name.getText();
        String lbl1 = stud_id.getText();
        String lbl3 = stud_class.getText();
//         String lbl2 = stud_pass.getText();
        try {
            prs = conn.prepareStatement(sql);
            prs.setString(1, lbl);
            prs.setString(2, lbl1);
            prs.setString(3, lbl3);
//            prs.setString(3, lbl2);    
            int i = prs.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Updated succsecfully");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
    }

         public void Delete(ActionEvent event) throws ClassNotFoundException {

        DBConnectionC db = new DBConnectionC();
          String lbl1 = stud_id.getText();
         String sql = "DELETE FROM `student_table` WHERE `STUDENT_ID`='"+lbl1+"'";
         //String lbl1 = stud_id.getText();
              try{
                conn=db.connMethod();
            prs = conn.prepareStatement(sql);
             //prs.setString(1, lbl1);
            prs.executeUpdate();

         JOptionPane.showMessageDialog(null, "Deleted succsecfully");
            } catch (Exception ex) {
                ex.printStackTrace();
         JOptionPane.showMessageDialog(null, "Try again!!");
        }
         }
/////////////////////////////////////////TEACHERS-REGISTRATION///////////////////////////////////////////////        

    public void Register_T(ActionEvent event) throws ClassNotFoundException {

        DBConnectionC db = new DBConnectionC();
        conn = db.connMethod();
        String sql = "INSERT INTO `teacher_table`(`TEACHER_NAME`, `TEACHER_ID`, `EMAIL`, `PASSWORD`, `JOB`, `SALARY`, `TEACHER_CLASS`) VALUES (?,?,?,?,?,?,?)";
        String lbl = teac_name.getText();
        String lbl1 = teac_id.getText();
        String lbl2 = teac_email.getText();
        String lbl3 = teac_pass.getText();
        String lbl4 = teac_job.getText();
        String lbl5 = teac_salary.getText();
        String lbl6 = teac_class.getText();
        try {
            prs = conn.prepareStatement(sql);
            prs.setString(1, lbl);
            prs.setString(2, lbl1);
            prs.setString(3, lbl2);
            prs.setString(4, lbl3);
            prs.setString(5, lbl4);
            prs.setString(6, lbl5);
            prs.setString(7, lbl6);
            int i = prs.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Data Inserted succsecfully");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
    }

    public void Update_T(ActionEvent event) throws ClassNotFoundException {

        DBConnectionC db = new DBConnectionC();
        conn = db.connMethod();

        String sql = "UPDATE `teacher_table` SET `TEACHER_NAME`= ?, `TEACHER_ID`= ?, `EMAIL`= ?, `JOB`= ?, `SALARY`= ?, `TEACHER_CLASS`= ? WHERE `TEACHER_ID`='" + teac_id.getText() + "'";
        String lbl = teac_name.getText();
        String lbl1 = teac_id.getText();
        String lbl2 = teac_email.getText();
        //String lbl3 = teac_pass.getText();
        String lbl4 = teac_job.getText();
        String lbl5 = teac_salary.getText();
        String lbl6 = teac_class.getText();
       try {
            prs = conn.prepareStatement(sql);
            prs.setString(1, lbl);
            prs.setString(2, lbl1);
            prs.setString(3, lbl2);
            //prs.setString(4, lbl3);
            prs.setString(4, lbl4);
            prs.setString(5, lbl5);
            prs.setString(6, lbl6);
            int i = prs.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Updated succsecfully");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
    }    
    
        public void Delete_T(ActionEvent event) throws ClassNotFoundException {

        DBConnectionC db = new DBConnectionC();
         String lbl1 = teac_id.getText();
         String sql = "DELETE FROM `teacher_table` WHERE `TEACHER_ID`='"+lbl1+"'";
         //String lbl1 = stud_id.getText();
              try{
                conn=db.connMethod();
            prs = conn.prepareStatement(sql);
             //prs.setString(1, lbl1);
            prs.executeUpdate();

         JOptionPane.showMessageDialog(null, "Deleted succsecfully");
            } catch (Exception ex) {
                ex.printStackTrace();
         JOptionPane.showMessageDialog(null, "Try again!!");
        }
         }
/////////////////////////////////////////OTHERS-REGISTRATION///////////////////////////////////////////////            
    
     public void Register_O(ActionEvent event) throws ClassNotFoundException {

        DBConnectionC db = new DBConnectionC();
        conn = db.connMethod();
        String sql = "INSERT INTO `others_table`(`NAME`, `ID`, `PASSWORD`, `JOB`, `SALARY`) VALUES (?,?,?,?,?)";
        String lbl = other_name.getText();
        String lbl1 = other_id.getText();
        String lbl2 = other_pass.getText();
        String lbl3 = other_job.getText();
        String lbl4 = other_salary.getText();
        try {
            prs = conn.prepareStatement(sql);
            prs.setString(1, lbl);
            prs.setString(2, lbl1);
            prs.setString(3, lbl2);
            prs.setString(4, lbl3);
            prs.setString(5, lbl4);
            int i = prs.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Data Inserted succsecfully");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
    }

    public void Update_O(ActionEvent event) throws ClassNotFoundException {

        DBConnectionC db = new DBConnectionC();
        conn = db.connMethod();
        String sql = "UPDATE `others_table` SET `NAME`= ?, `ID`= ?, `JOB`= ?, `SALARY`= ? WHERE `ID`='" + other_id.getText() + "'";
        
        String lbl = other_name.getText();
        String lbl1 = other_id.getText();
        //String lbl2 = other_pass.getText();
        String lbl3 = other_job.getText();
        String lbl4 = other_salary.getText();
        try {
            prs = conn.prepareStatement(sql);
            prs.setString(1, lbl);
            prs.setString(2, lbl1);
            //prs.setString(3, lbl2);
            prs.setString(3, lbl3);
            prs.setString(4, lbl4);
            int i = prs.executeUpdate();
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Updated succsecfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
    }    
     
    public void Delete_O(ActionEvent event) throws ClassNotFoundException {
            DBConnectionC db = new DBConnectionC();
         String lbl1 = other_id.getText();
         String sql = "DELETE FROM `others_table` WHERE `ID`='"+lbl1+"'";
         //String lbl1 = stud_id.getText();
              try{
                conn=db.connMethod();
            prs = conn.prepareStatement(sql);
             //prs.setString(1, lbl1);
            prs.executeUpdate();

         JOptionPane.showMessageDialog(null, "Deleted succsecfully");
            } catch (Exception ex) {
                ex.printStackTrace();
         JOptionPane.showMessageDialog(null, "Try again!!");
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
