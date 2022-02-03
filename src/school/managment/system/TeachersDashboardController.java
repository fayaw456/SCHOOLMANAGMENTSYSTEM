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
public class TeachersDashboardController implements Initializable {

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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
