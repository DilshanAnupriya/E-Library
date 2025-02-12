package com.library.controller;

import com.library.db.DatabaseAccessCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    public AnchorPane context;
    public TextField txtPassword;
    public TextField txtEmail;

    public void openSignInOnAction(ActionEvent actionEvent) throws IOException {
        setUi2("SignUp");
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        try{
            if(DatabaseAccessCode.loginUser(txtEmail.getText(), txtPassword.getText())){
                new Alert(Alert.AlertType.INFORMATION,"Successfully logged in").show();
                setUi("DashboardForm");
            }else {
                 new Alert(Alert.AlertType.WARNING,"invalid email or password").show();
            }
        } catch (ClassNotFoundException | RuntimeException | SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            e.printStackTrace();
        }
    }

    private void setUi2(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(
                new Scene(
                        FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
                )
        );
    }


    private void setUi(String location) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/"+location+".fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) context.getScene().getWindow();
        DashboardFormController controller = loader.getController();
        controller.printLoggedUserEmail(txtEmail.getText());
        stage.setScene(scene);
    }

}
