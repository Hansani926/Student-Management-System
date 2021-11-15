package controller;

import bo.BoFactory;
import bo.custom.StudentBo;
import com.mysql.jdbc.PreparedStatement;
import db.DBConnection;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.StudentTM;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentFormController {
    public TextField txtId;
    public TextField txtStudentName;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtdob;
    public TextField txtGender;
    public TextField txtSearch;
    public TableView<StudentTM> tableStudent;
    public TableColumn colId;
    public TableColumn colStudentName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn coldob;
    public TableColumn colGender;
    public TableColumn colOperate;
    public ImageView img;
    public AnchorPane root;
    StudentBo bo;

    public void initialize() throws Exception {
        bo = BoFactory.getInstance()
                .getBo(BoFactory.BOType.STUDENT);

        loadId();
        colId.setCellValueFactory(new PropertyValueFactory("Id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory("StudentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        colContact.setCellValueFactory(new PropertyValueFactory("Contact"));
        coldob.setCellValueFactory(new PropertyValueFactory("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory("Gender"));
        colOperate.setCellValueFactory(new PropertyValueFactory("button"));
        loadAllStudents();
        tableStudent.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData((StudentTM) newValue);
                });



    }


    private void loadId() throws Exception {
        String Id = bo.getId();
        txtId.setText(Id);
    }

    private void setData(StudentTM tm) {
        txtId.setText(tm.getId());
        txtStudentName.setText(tm.getStudentName());
        txtAddress.setText(tm.getAddress());
        txtContact.setText(tm.getContact() + "");
        txtdob.setText(tm.getDob());
        txtGender.setText(tm.getGender());


    }

    private void loadAllStudents() throws Exception {
        ObservableList<StudentTM> tmList =
                FXCollections.observableArrayList();
        List<StudentDTO> allStudents = bo.getAllStudents();
        if (allStudents != null) {

            for (StudentDTO dto : allStudents) {
                Button btn = new Button("Delete");
                tmList.add(new StudentTM(dto.getId(), dto.getStudentName(), dto.getAddress(), dto.getContact(), dto.getDob(), dto.getGender(), btn));
                btn.setOnAction((e) -> {
                    try {

                        ButtonType ok = new ButtonType("OK",
                                ButtonBar.ButtonData.OK_DONE);
                        ButtonType no = new ButtonType("NO",
                                ButtonBar.ButtonData.CANCEL_CLOSE);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "Are You Sure ?", ok, no);
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.orElse(no) == ok) {
                            if (bo.deleteStudent(dto.getId())) {
                                new Alert(Alert.AlertType.CONFIRMATION,
                                        "Deleted", ButtonType.OK).show();
                                loadAllStudents();
                                return;
                            }
                            new Alert(Alert.AlertType.WARNING,
                                    "Try Again", ButtonType.OK).show();
                        } else {

                        }


                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
            }
            tableStudent.setItems(tmList);
        }


    }

    public void getDataOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO dto = bo.getStudent(txtId.getText());
        if (dto != null) {
            txtId.setText(dto.getId());
            txtStudentName.setText(dto.getStudentName());
            txtAddress.setText(dto.getAddress());
            txtContact.setText(dto.getContact() + "");
            txtdob.setText(dto.getDob());
            txtGender.setText(dto.getGender());
        }
    }

    public void newOnAction(ActionEvent actionEvent) {
    }

    public void saveOnAction(ActionEvent actionEvent) throws Exception {

        boolean isSaved = bo.saveStudent(
                new StudentDTO(txtId.getText(),
                        txtStudentName.getText(),
                        txtAddress.getText(),
                        Integer.parseInt(txtContact.getText()),
                        txtdob.getText(),
                        txtGender.getText()));

        if(isSaved)  {  new Alert(Alert.AlertType.CONFIRMATION,"Success").showAndWait();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccess").showAndWait();
        }
    }

    public void backToHomeOnAction(MouseEvent mouseEvent) throws IOException{
        setUI("MainForm.fxml");
    }
    public void setUI(String location) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+location))));
    }

}


