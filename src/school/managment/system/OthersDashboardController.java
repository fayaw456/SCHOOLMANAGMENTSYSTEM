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
    
    
    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField pass;
        
    private Connection conn;
    private Statement st;
    private PreparedStatement prs;
    private ResultSet result;
    
    
        public void exit1(){
        System.exit(0);
    }
    
        public void LOGOUT(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(OthersloginController.class.getResource("otherslogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

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
       
        OthersloginController ab = new OthersloginController();
        String stt=OthersloginController.getID();
        
        public void show(ActionEvent event) throws Exception {
       
        DBConnectionC db = new DBConnectionC();
       conn = db.connMethod();
   String sql = "SELECT NAME, PASSWORD, ID FROM `others_table` WHERE ID ='"+stt+"'";
        
        try {
            result = conn.createStatement().executeQuery(sql);
            while (result.next()) {
                name.setText(result.getString(1));
                pass.setText(result.getString(2));
                id.setText(result.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        public void edit(ActionEvent event) throws ClassNotFoundException{
            
            DBConnectionC db = new DBConnectionC();
            conn = db.connMethod();
            String sql = "UPDATE `others_table` SET `PASSWORD`= ? WHERE `ID`='"+stt+"'";
                String lbl1 = pass.getText();
                    try { 
                        prs = conn.prepareStatement(sql);
                        prs.setString(1, lbl1);
                        int i = prs.executeUpdate();
                        if (i == 1) {

                     JOptionPane.showMessageDialog(null, "Data Edited succsecfully");
                        }

                    } catch (SQLException ex) {
                        
                     JOptionPane.showMessageDialog(null, "Try again!!");
        }}
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
