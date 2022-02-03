/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.managment.system;

import java.awt.event.MouseEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author W10X64_AUG-2020
 */
public class WelcomController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Hyperlink create_btn;

    @FXML
    private Button login_btn;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Label m;

    @FXML
    private Label m1;

    @FXML
    private PasswordField password;

    @FXML
    private Button signup_btn;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private TextField su_email;

    @FXML
    private Hyperlink su_login_btn;

    @FXML
    private PasswordField su_password;

    @FXML
    private TextField su_username;

    @FXML
    private TextField username;

    private Connection conn;
    private Statement st;
    private PreparedStatement prs;
    private ResultSet result;

    public void exit() {
        System.exit(0);
    }

    public void textfeildDesign() {

        if (username.isFocused()) {

            username.setStyle(" -fx-background-color:#fff;"
                    + "-fx-border-width:2px;");
            password.setStyle(" -fx-background-color:transparent;"
                    + "-fx-border-width:1px;");

        } else if (username.isFocused()) {

            username.setStyle(" -fx-background-color:transparent;"
                    + "-fx-border-width:1px;");
            password.setStyle(" -fx-background-color:#fff;"
                    + "-fx-border-width:2px;");

        }
    }

    public void textfeildDesign1() {

        if (su_username.isFocused()) {

            su_username.setStyle(" -fx-background-color:#fff;"
                    + "-fx-border-width:2px;");
            su_password.setStyle(" -fx-background-color:transparent;"
                    + "-fx-border-width:1px;");
            su_email.setStyle(" -fx-background-color:transparent;"
                    + "-fx-border-width:1px;");

        } else if (su_password.isFocused()) {

            su_username.setStyle(" -fx-background-color:transparent;"
                    + "-fx-border-width:1px;");
            su_password.setStyle(" -fx-background-color:#fff;"
                    + "-fx-border-width:2px;");
            su_email.setStyle(" -fx-background-color:transparent;"
                    + "-fx-border-width:1px;");

        } else if (su_email.isFocused()) {

            su_username.setStyle(" -fx-background-color:transparent;"
                    + "-fx-border-width:1px;");
            su_password.setStyle(" -fx-background-color:transparent;"
                    + "-fx-border-width:2px;");
            su_email.setStyle(" -fx-background-color:#fff;"
                    + "-fx-border-width:1px;");
        }
    }

    public void dropShadowEffect() {

        DropShadow orginal = new DropShadow(20, Color.valueOf("ae44a5"));
        orginal.setRadius(30);
        m.setEffect(orginal);
        m1.setEffect(orginal);
        /*
        m.setOnMouseEntered((MouseEvent event)->{
        
        DropShadow shadow = new DropShadow(20, Color.valueOf("ae44a5"));
        m.setStyle("-fx-text-fill:#ff5df1");
        m.setEffect(orginal);
        
        });
        
        m.setOnMouseExited((MouseEvent event)->{
        
        m.setStyle("-fx-text-fill:#000");
        m.setEffect(orginal);
        });
        
        m1.setOnMouseEntered((MouseEvent event)->{
        
        DropShadow shadow = new DropShadow(20, Color.valueOf("ae44a5"));
        m1.setStyle("-fx-text-fill:#ff5df1");
        m1.setEffect(orginal);
        
        });
        
        m1.setOnMouseExited((MouseEvent event)->{
        
        m1.setStyle("-fx-text-fill:#000");
        m1.setEffect(orginal);
        });*/

    }

    public void changeForm(ActionEvent event) {

        if (event.getSource() == create_btn) {

            signup_form.setVisible(true);
            login_form.setVisible(false);
        } else if (event.getSource() == su_login_btn) {

            login_form.setVisible(true);
            signup_form.setVisible(false);
        }
    }

    public void changeForm2(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(IntroController.class.getResource("intro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void login(ActionEvent event) throws Exception {

        DBConnectionC db = new DBConnectionC();
        conn = db.connMethod();

        String sql = "SELECT * FROM `teacher_table` WHERE TEACHER_NAME = ? and PASSWORD = ?";

        try {
            prs = conn.prepareStatement(sql);
            prs.setString(1, username.getText());
            prs.setString(2, password.getText());
            ;

            result = prs.executeQuery();
            if (result.next()) {

                FXMLLoader fxmlLoader = new FXMLLoader(TeachersDashboardController.class.getResource("TeachersDashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("WRONG ACCOUNT!!");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dropShadowEffect();
    }

}
