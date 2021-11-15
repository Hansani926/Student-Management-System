package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFormController {
    public AnchorPane root;
    public ImageView student;
    public ImageView Course;

    public void studentOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("StudentForm.fxml");
    }

    public void initUi(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + location)));
    }

    public void CourseOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("Course.fxml");
    }

    public void RegistrationOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("RegistrationForm.fxml");
    }
}
