package com.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

    public AnchorPane context;

    public void printLoggedUserEmail(String email) {
        System.out.println(email);
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(
                new Scene(
                        FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
                )
        );
    }

    public void logoutOnAction(ActionEvent actionEvent) {
    }

    public void openCustomerFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CustomerForm");
    }

    public void openBookFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("BookForm");
    }

    public void openMembershipOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MembershipForm«");
    }

    public void openUserFormOnAction(ActionEvent actionEvent) {

    }

    public void openBorrwReturnOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Borrow&ReturnForm");
    }

    public void openStatisticsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("StatForm");
    }

    public void openHistoryOnAction(ActionEvent actionEvent) throws IOException {
        setUi("BorrowHistory");
    }
}
