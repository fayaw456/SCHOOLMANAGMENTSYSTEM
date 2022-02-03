/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.managment.system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author W10X64_AUG-2020
 */
public class RegistrarDashboardController implements Initializable {

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


    
        public void exit1(){
        System.exit(0);
    }
    
        public void frame (ActionEvent event) {

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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
