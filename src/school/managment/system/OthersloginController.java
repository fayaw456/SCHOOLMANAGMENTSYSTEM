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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author W10X64_AUG-2020
 */
public class OthersloginController implements Initializable {
    
   static String IDNo; 
    @FXML
    private Hyperlink othersback_btn;
    
    @FXML
    private Label o;
    
    @FXML
    private Button otherLogin_btn;

    @FXML
    private TextField otherName;

    @FXML
    private PasswordField othersPasssword;
    
    private Connection conn;
    private Statement st;
    private PreparedStatement prs;
    private ResultSet result;
    
    public static String getID(){
        return OthersloginController.IDNo;
    }
    
    public void exit(){
        System.exit(0);
} 
    public void dropShadowEffect() {

        DropShadow orginal = new DropShadow(20, Color.valueOf("ae44a5"));
        orginal.setRadius(30);
        o.setEffect(orginal);
        o.setStyle("-fx-text-fill:#0931f7");
     }
        public void changeForm(ActionEvent event) throws IOException {
     
        FXMLLoader fxmlLoader = new FXMLLoader(IntroController.class.getResource("intro.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();    
        
    }
         public void login(ActionEvent event) throws Exception {
        
        DBConnectionC db = new DBConnectionC();
        conn=db.connMethod();
       
       String sql="SELECT * FROM `others_table` WHERE NAME = ? and PASSWORD = ?";

       try{
            prs=conn.prepareStatement(sql);
            prs.setString(1, otherName.getText());
            prs.setString(2, othersPasssword.getText());

            result = prs.executeQuery();
         if(result.next()){
         IDNo = result.getString(2);
        FXMLLoader fxmlLoader = new FXMLLoader(OthersDashboardController.class.getResource("OthersDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
        }else{
          Alert alert=new Alert(Alert.AlertType.ERROR);
          alert.setTitle("ERROR MESSAGE");
          alert.setHeaderText(null);
          alert.setContentText("WRONG ACCOUNT!!");
          alert.showAndWait();
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }
 }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dropShadowEffect();
    }    
    
}
