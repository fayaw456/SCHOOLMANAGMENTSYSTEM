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
import javafx.scene.control.Alert;
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

    @FXML
    private TextField stud_name;

    @FXML
    private TextField stud_pass;

    @FXML
    private TextField studId;
    
    @FXML
    private TextField stud_class;

    @FXML
    private TextField stud_id;

    private Connection conn;
    private Statement st;
    private PreparedStatement prs;
    private ResultSet result;

    public void exit1() {
        System.exit(0);
    }

    public void frame(ActionEvent event) {

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

    public void LOGOUT(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(StudentloginController.class.getResource("studentlogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    StudentloginController ab = new StudentloginController();
    String stt = StudentloginController.getID();

    public void show(ActionEvent event) throws Exception {

        DBConnectionC db = new DBConnectionC();
        conn = db.connMethod();
        String sql = "SELECT STUDENT_NAME, PASSWORD, STUDENT_ID, STUDENT_CLASS FROM `student_table` WHERE STUDENT_ID ='" + stt + "'";

        try {
            result = conn.createStatement().executeQuery(sql);
            while (result.next()) {
                stud_name.setText(result.getString(1));
                stud_pass.setText(result.getString(2));
                stud_id.setText(result.getString(3));
                stud_class.setText(result.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(ActionEvent event) throws ClassNotFoundException {

        DBConnectionC db = new DBConnectionC();
        conn = db.connMethod();
        String sql = "UPDATE `student_table` SET `PASSWORD`= ? WHERE `STUDENT_ID`='" + stt + "'";
        String lbl1 = stud_pass.getText();
        try {
            prs = conn.prepareStatement(sql);
            prs.setString(1, lbl1);
            int i = prs.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Data Edited succsecfully");
            }

        } catch (SQLException ex) {

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
