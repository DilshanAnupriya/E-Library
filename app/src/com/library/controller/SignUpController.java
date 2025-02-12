package com.library.controller;

import com.library.db.DatabaseAccessCode;
import com.library.entity.SystemUser;
import com.library.util.PasswordGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

public class SignUpController {
    public AnchorPane context;
    public TextField txtfullname;
    public TextField txtNumber;
    public TextField txtEmail;
    public TextField txtPassword;

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(
                new Scene(
                        FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
                )
        );
    }

    public void openLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");

    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        try{
        SystemUser user = new SystemUser(
                UUID.randomUUID().toString(),
                txtfullname.getText(),
                txtEmail.getText(),
                txtNumber.getText(),
                PasswordGenerator.encrypt(txtPassword.getText())
        );

        if(DatabaseAccessCode.createUser(user)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"User saved successfully");
            setUi("LoginForm");
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Something went wrong");
        }
    } catch (ClassNotFoundException | RuntimeException | SQLException | IOException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
        e.printStackTrace();
    }

    }
}
