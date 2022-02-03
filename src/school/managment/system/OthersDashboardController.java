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
public class OthersDashboardController implements Initializable {
   
 @FXML
    private Button activity_btn;

    @FXML
    private AnchorPane othersActivity;

    @FXML
    private AnchorPane othersComment;

    @FXML
    private Button othersComment_btn;

    @FXML
    private AnchorPane othersProfile;

    @FXML
    private Button others_btn;

    
        public void exit1(){
        System.exit(0);
    }
    
        public void frame (ActionEvent event) {

        if (event.getSource() == others_btn) {

        othersProfile.setVisible(true);
        othersActivity.setVisible(false);
        othersComment.setVisible(false);
        } else if (event.getSource() == activity_btn) {

        othersProfile.setVisible(false);
        othersActivity.setVisible(true);
        othersComment.setVisible(false);
        } else if (event.getSource() == othersComment_btn) {

        othersProfile.setVisible(false);
        othersActivity.setVisible(false);
        othersComment.setVisible(true);
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
