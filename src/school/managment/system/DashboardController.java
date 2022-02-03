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
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane studCommednt;

    @FXML
    private Button studComment_btn;

    @FXML
    private AnchorPane studProfile;

    @FXML
    private Button studProfile_btn;

    @FXML
    private AnchorPane studRecord;

    @FXML
    private Button studRecord_btn;
    
        public void exit1(){
        System.exit(0);
    }
    
        public void frame (ActionEvent event) {

        if (event.getSource() == studProfile_btn) {

        studProfile.setVisible(true);
        studRecord.setVisible(false);
        studCommednt.setVisible(false);
        } else if (event.getSource() == studRecord_btn) {

        studProfile.setVisible(false);
        studRecord.setVisible(true);
        studCommednt.setVisible(false);
        } else if (event.getSource() == studComment_btn) {

        studProfile.setVisible(false);
        studRecord.setVisible(false);
        studCommednt.setVisible(true);
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
