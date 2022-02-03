/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.managment.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author W10X64_AUG-2020
 */
public class IntroController implements Initializable {
   
       @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Hyperlink Othersbtn;

    @FXML
    private Hyperlink Registrarbtn;

    @FXML
    private Hyperlink Teacherbtn;

    @FXML
    private Hyperlink studentbtn;
   
    public void exit1(){
        System.exit(0);
}
    
    @FXML
    public void changeForm(ActionEvent event) throws IOException {
     
        FXMLLoader fxmlLoader = new FXMLLoader(IntroController.class.getResource("studentlogin.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();    
        
    }
    public void changeForm1(ActionEvent event) throws IOException {
     
        FXMLLoader fxmlLoader = new FXMLLoader(IntroController.class.getResource("welcom.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();    
        
    }
       public void changeForm2(ActionEvent event) throws IOException {
     
        FXMLLoader fxmlLoader = new FXMLLoader(IntroController.class.getResource("otherslogin.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();    
        
    }
       public void changeForm3(ActionEvent event) throws IOException {
     
        FXMLLoader fxmlLoader = new FXMLLoader(IntroController.class.getResource("registrar.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();    
        
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         System.out.println("IntroController");
    }    
    
}
