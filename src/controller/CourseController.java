package controller;

import bo.BoFactory;
import bo.custom.CourseBo;
import dto.CourseDTO;
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
import view.tm.CourseTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CourseController {
    public TextField txtcode;
    public TextField txtcourseName;
    public TextField txtcourseType;
    public TextField txtduration;
    public TextField txtSearch;
    public TableView tableCourse;
    public TableColumn colcode;
    public TableColumn colcourseName;
    public TableColumn colcourseType;
    public TableColumn colduration;
    public TableColumn colOperate;
    public AnchorPane root;
    public ImageView img;
    public Button btnsave;
    CourseBo bo;

    public void initialize() throws Exception {
        bo = BoFactory.getInstance()
                .getBo(BoFactory.BOType.COURSE);

        loadcode();
        colcode.setCellValueFactory(new PropertyValueFactory("code"));
        colcourseName.setCellValueFactory(new PropertyValueFactory("CourseName"));
        colcourseType.setCellValueFactory(new PropertyValueFactory("courseType"));
        colduration.setCellValueFactory(new PropertyValueFactory("duration"));
        colOperate.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllCourses();
        tableCourse.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData((CourseTM) newValue);
                });


    }


    private void loadcode() throws Exception {
        String code = bo.getcode();
        txtcode.setText(code);
    }

    private void setData(CourseTM tm) {
        txtcode.setText(tm.getCode());
        txtcourseName.setText(tm.getCourseName());
        txtcourseType.setText(tm.getCourseType());
        txtduration.setText(tm.getDuration());
    }




        private void loadAllCourses() throws Exception {
            ObservableList<CourseTM> tmList =
                    FXCollections.observableArrayList();
            List<CourseDTO> allCustomers = bo.getAllCourses();
            for (CourseDTO dto : allCustomers
            ) {
                Button btn = new Button("Delete");
                CourseTM tm = new CourseTM(dto.getCode(),dto.getCourseName(),dto.getCourseType(),dto.getDuration());
                tmList.add(tm);
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
                            if (bo.deleteCourse(tm.getCode())) {
                                new Alert(Alert.AlertType.CONFIRMATION,
                                        "Deleted", ButtonType.OK).show();
                                loadAllCourses();
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
            tableCourse.setItems(tmList);

        }

    public void getDataOnAction (ActionEvent actionEvent) throws Exception {
        CourseDTO dto = bo.getCourse(txtcode.getText());
        if (dto != null) {
            txtcode.setText(dto.getCode());
            txtcourseName.setText(dto.getCourseName());
            txtcourseType.setText(dto.getCourseType());
            txtduration.setText(dto.getDuration());
        }

        /*public void newOnAction (ActionEvent actionEvent){
        }

        public void saveOnAction (ActionEvent actionEvent){
            boolean isSaved = bo.saveCourse(
                    new CourseDTO(txtcode.getText(),
                            txtcourseName.getText(),
                            txtcourseType.getText(),
                            txtduration.getText()
                    ));
            System.out.println(isSaved);
        }*/
        /*public void backToHomeOnAction (MouseEvent mouseEvent) throws IOException{
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/MainForm.fxml"))));
        }*/
    }

    public void backOnAction(MouseEvent mouseEvent) throws IOException {
        setUI("MainForm.fxml");
    }
    
    public void setUI(String location) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+location))));
    }

    public void saveOnAction(ActionEvent actionEvent) throws Exception {
        boolean isSaved = bo.saveCourse(
                new CourseDTO(txtcode.getText(),
                        txtcourseName.getText(),
                        txtcourseType.getText(),
                        txtduration.getText())
        );
        if(isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"Success").showAndWait();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccess").showAndWait();
        }
    }

    public void newOnAction(ActionEvent actionEvent) {
    }

    public void backToHomeOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/MainForm.fxml"))));
    }
}





