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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author W10X64_AUG-2020
 */
public class StudentloginController implements Initializable {
    private double x = 0;
    private double y = 0;
    @FXML
    private Label m;

    @FXML
    private TextField studId;

    @FXML
    private Button studLogin_btn;

    @FXML
    private TextField studName;

    @FXML
    private PasswordField studPassword;

    private Connection conn;
    private Statement st;
    private PreparedStatement prs;
    private ResultSet result;

    public void exit() {
        System.exit(0);
    }

    public void dropShadowEffect() {

        DropShadow orginal = new DropShadow(20, Color.valueOf("ae44a5"));
        orginal.setRadius(30);
        m.setEffect(orginal);
        m.setStyle("-fx-text-fill:#ff5df1");
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
       
       String sql="SELECT * FROM `student_table` WHERE STUDENT_NAME = ? and STUDENT_ID = ? and PASSWORD = ?";

       try{
            prs=conn.prepareStatement(sql);
            prs.setString(1, studName.getText());
            prs.setString(2, studId.getText());
            prs.setString(3, studPassword.getText());
            
            result = prs.executeQuery();
         if(result.next()){
         
        FXMLLoader fxmlLoader = new FXMLLoader(DashboardController.class.getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
        }else{
          Alert alert=new Alert(AlertType.ERROR);
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
