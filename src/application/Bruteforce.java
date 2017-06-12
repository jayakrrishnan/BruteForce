/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author jay
 */
public class Bruteforce extends Application {
	
	
    @Override
    public void start(Stage stage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("FXMLBrute.fxml"));
     
        Stage newstage=new Stage();
        Scene scene = new Scene(root);
        newstage.setScene(scene);
        newstage.initStyle(StageStyle.DECORATED);
        newstage.show();
    }
   
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}


/*
FlowPane pane = new FlowPane();
Button addNode = new Button("Add");
addNode.setOnAction(e -> pane.getChildren().add(new Circle(10));
*/