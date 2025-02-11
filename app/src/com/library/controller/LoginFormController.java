package com.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    public AnchorPane context;
    public TextField txtPassword;
    public TextField txtEmail;

    public void openSignInOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUp");
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashboardForm");
    }


    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(
                new Scene(
                        FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
                )
        );
    }

}
