/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uweaccommodationsystem.gui;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Connor
 */
public class LoginController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label label;
    @FXML
    private Button Loginbutton;
    @FXML
    private TextField textUsername;
    @FXML
    private PasswordField textPassword;
    
    @FXML
    //button fires off event for log in scene
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()== Loginbutton){
            String username = textUsername.getText();
            String password = textPassword.getText();
            
            // checks log in credentials 
            if(username.equalsIgnoreCase("h")&& password.equalsIgnoreCase("")){
                System.out.println("Login success");
                
                // if details correct open up new scene
                root = FXMLLoader.load(getClass().getResource("FXMLAdminView.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else if(username.equalsIgnoreCase("w")&& password.equalsIgnoreCase("")){            
                // if details correct open up new scene
                root = FXMLLoader.load(getClass().getResource("FXMLWardenView.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else if(username.equalsIgnoreCase("a")&& password.equalsIgnoreCase("")){            
                // if details correct open up new scene
                root = FXMLLoader.load(getClass().getResource("FXMLAllView.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else{
                //error message for wrong input
            System.out.println("Username/Password combination not found");
        }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

