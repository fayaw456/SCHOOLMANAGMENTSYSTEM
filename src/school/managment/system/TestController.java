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
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author W10X64_AUG-2020
 */
public class TestController implements Initializable {
    
    private Connection conn;
    private Statement st;
    private PreparedStatement prs;
    private ResultSet result;
    
    @FXML
    private TableView<STUD_Table> Table_view;

    @FXML
    private TableView<TEAC_Table> Table_view1;

    @FXML
    private TableView<OTHER_Table> Table_view11;

    @FXML
    private Button employeeTable_btn;

    @FXML
    private AnchorPane othersData;

    @FXML
    private AnchorPane studentData;

    @FXML
    private Button studentTable_btn;

    @FXML
    private AnchorPane teachersData;

    @FXML
    private Button teachersTable_btn;
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private TableColumn<STUD_Table,String> stu_name;
    @FXML
    private TableColumn<STUD_Table,String> stu_id;
    @FXML
    private TableColumn<STUD_Table,String> stud_pass;
    @FXML
    private TableColumn<STUD_Table,String> stud_pro;
    
    ObservableList<STUD_Table> studlist= FXCollections.observableArrayList();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private TableColumn<TEAC_Table,String> teach_name;
    @FXML
    private TableColumn<TEAC_Table,String> teach_id;
    @FXML
    private TableColumn<TEAC_Table,String> teac_Email;
    @FXML
    private TableColumn<TEAC_Table,String> teac_Pass;
    @FXML
    private TableColumn<TEAC_Table,String> Teac_Job;
    @FXML
    private TableColumn<TEAC_Table,String> teac_Salary;
    @FXML
    private TableColumn<TEAC_Table,String> teac_Profile;
    
    ObservableList<TEAC_Table> teaclist= FXCollections.observableArrayList();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    @FXML
    private TableColumn<OTHER_Table,String> other_Name;
    @FXML
    private TableColumn<OTHER_Table,String> other_Id;
    @FXML
    private TableColumn<OTHER_Table,String> other_pass;
    @FXML
    private TableColumn<OTHER_Table,String> other_pro;
    @FXML
    private TableColumn<OTHER_Table,String> other_job;
    @FXML
    private TableColumn<OTHER_Table,String> other_salary; 
   
    ObservableList<OTHER_Table> otherlist= FXCollections.observableArrayList();
    
     /**
     * Initializes the controller class.
     */

    @FXML
    private void frame(ActionEvent event) {
        if (event.getSource() == studentTable_btn) {

            studentData.setVisible(true);
            teachersData.setVisible(false);
            othersData.setVisible(false);
        } else if (event.getSource() == teachersTable_btn) {

            studentData.setVisible(false);
            teachersData.setVisible(true);
            othersData.setVisible(false);
        } else if (event.getSource() == employeeTable_btn) {

            studentData.setVisible(false);
            teachersData.setVisible(false);
            othersData.setVisible(true);
        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
          FXMLLoader fxmlLoader = new FXMLLoader(RegistrarDashboardController.class.getResource("RegistrarDashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();   
    }

    @FXML
    private void exit1(ActionEvent event) {
         System.exit(0);
    }
     @Override
    public void initialize(URL url, ResourceBundle rb){
        
        DBConnectionC db = new DBConnectionC();
        try {
            conn=db.connMethod();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
///////////////////////////////////////////////////////////////////////////////////////////////////
        String sql = "SELECT * FROM `student_table`";
        try {
            st = conn.createStatement();
            result = st.executeQuery(sql);

            while (result.next()) {
                studlist.add(new STUD_Table(result.getString("STUDENT_NAME"), result.getString("STUDENT_ID"), result.getString("PASSWORD"), result.getString("PROFILE")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        stu_name.setCellValueFactory(new PropertyValueFactory<>("stu_name"));
        stu_id.setCellValueFactory(new PropertyValueFactory<>("stu_id"));
        stud_pass.setCellValueFactory(new PropertyValueFactory<>("stud_pass"));
        stud_pro.setCellValueFactory(new PropertyValueFactory<>("stud_pro"));
        Table_view.setItems(studlist);
/////////////////////////////////////////////////////////////////////////////////////////////////////
        String sql1 = "SELECT * FROM `teacher_table`";
        try {
            st = conn.createStatement();
            result = st.executeQuery(sql1);

            while (result.next()) {
                teaclist.add(new TEAC_Table(result.getString("TEACHER_NAME"), result.getString("TEACHER_ID"), result.getString("EMAIL"), result.getString("PASSWORD"), result.getString("JOB"), result.getString("SALARY"), result.getString("PROFILE")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        teach_name.setCellValueFactory(new PropertyValueFactory<>("teach_name"));
        teach_id.setCellValueFactory(new PropertyValueFactory<>("teach_id"));
        teac_Email.setCellValueFactory(new PropertyValueFactory<>("teac_Email"));
        teac_Pass.setCellValueFactory(new PropertyValueFactory<>("teac_Pass"));
        Teac_Job.setCellValueFactory(new PropertyValueFactory<>("Teac_Job"));
        teac_Salary.setCellValueFactory(new PropertyValueFactory<>("teac_Salary"));
        teac_Profile.setCellValueFactory(new PropertyValueFactory<>("teac_Profile"));
        Table_view1.setItems(teaclist);
//////////////////////////////////////////////////////////////////////////////////////////////////////
    String sql2 = "SELECT * FROM `others_table`";
        try {
            st = conn.createStatement();
            result = st.executeQuery(sql2);

            while (result.next()) {
                otherlist.add(new OTHER_Table(result.getString("NAME"), result.getString("ID"), result.getString("PASSWORD"), result.getString("PROFILE"), result.getString("JOB"), result.getString("SALARY")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        other_Name.setCellValueFactory(new PropertyValueFactory<>("other_Name"));
        other_Id.setCellValueFactory(new PropertyValueFactory<>("other_Id"));
        other_pass.setCellValueFactory(new PropertyValueFactory<>("other_pass"));
        other_pro.setCellValueFactory(new PropertyValueFactory<>("other_pro"));
        other_job.setCellValueFactory(new PropertyValueFactory<>("other_job"));
        other_salary.setCellValueFactory(new PropertyValueFactory<>("other_salary"));
        Table_view11.setItems(otherlist);
    }    
   
}
