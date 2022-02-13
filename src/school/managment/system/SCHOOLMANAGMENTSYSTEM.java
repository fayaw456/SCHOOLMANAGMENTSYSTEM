/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.managment.system;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author W10X64_AUG-2020
 */

public class SCHOOLMANAGMENTSYSTEM extends Application {

    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(SCHOOLMANAGMENTSYSTEM.class.getResource("intro.fxml"));
        Scene scene = new Scene(root);
        root.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) -> {
        primaryStage.setX(event.getScreenX() - x);
        primaryStage.setY(event.getScreenY() - y);

        });

        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
