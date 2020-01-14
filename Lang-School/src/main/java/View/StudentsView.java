package View;

import Data.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentsView  implements Initializable {

    @FXML
    public Text school;
    @FXML
    public Button menuStudents;
    @FXML
    public Button menuGroups;
    @FXML
    public Button doAction;
    @FXML
    public ComboBox<String> action;

    @FXML
    public TextField name;
    @FXML
    public TextField surname;
    @FXML
    public TextField course;
    @FXML
    public TableView<StudentsRaw> studentsTable;
    @FXML
    public Text error;

    private GenericDataBaseAccess<StudentEntity, Long> dbaStudent = new GenericDataBaseAccess<>(StudentEntity.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn<StudentsRaw, Long> idColumn = new TableColumn<>("id Студента");
        TableColumn<StudentsRaw, Long> personIdColumn = new TableColumn<>("id Человека");
        TableColumn<StudentsRaw, String> nameColumn = new TableColumn<>("Имя");
        TableColumn<StudentsRaw, String> surnameColumn = new TableColumn<>("Фамилия");
        TableColumn<StudentsRaw, String> addressColumn = new TableColumn<>("Адрес занятий");
        TableColumn<StudentsRaw, Long> courseColumn = new TableColumn<>("Группа");
        TableColumn<StudentsRaw, String> languageColumn = new TableColumn<>("Язык");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        personIdColumn.setCellValueFactory(new PropertyValueFactory<>("personId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));


        this.action.setItems(FXCollections.observableArrayList("Добавить", "Расширить", "Удалить"));
        this.action.setValue("Добавить");

        studentsTable.getColumns().addAll(idColumn, personIdColumn, nameColumn, surnameColumn, addressColumn, courseColumn, languageColumn);
        updateTable();

    }

    @FXML
    private void updateAction(){
        this.doAction.setText(this.action.getValue());
        this.name.setText("");
        switch (this.action.getValue()) {
            case "Удалить":
                this.surname.setVisible(false);
                this.course.setVisible(false);
                this.name.setPromptText("id студента");
                break;

            case "Добавить":
                this.surname.setVisible(true);
                this.course.setVisible(true);
                this.name.setPromptText("Имя");
                break;

            case "Расширить":
                this.surname.setVisible(false);
                this.name.setPromptText("id человека");
                break;

        }
    }

    private void updateTable(){
        List<StudentEntity> students = dbaStudent.findAll();
        List<StudentsRaw> studentsRaws = new ArrayList<>();

        for(StudentEntity student : students){
            StudentsRaw studentRaw = new StudentsRaw();
            studentRaw.setId(student.getId());
            studentRaw.setPersonId(student.getPerson().getId());
            studentRaw.setName(student.getPerson().getName());
            studentRaw.setSurname(student.getPerson().getSurname());
            studentRaw.setCourseId(student.getCourse().getId());
            studentRaw.setLanguage(student.getCourse().getLanguage());
            BranchEntity branch = student.getCourse().getBranch();
            studentRaw.setAddress(branch.getStreet() + ", " + branch.getBuilding());

            studentsRaws.add(studentRaw);
        }
        ObservableList<StudentsRaw> raws = FXCollections.observableArrayList(studentsRaws);
        studentsTable.setItems(raws);
    }

    public void doAction(ActionEvent event) {
        this.error.setVisible(false);
        switch (this.doAction.getText()) {
            case "Удалить":
                long id;
                StudentEntity student;
                try{
                    id = Long.parseLong(this.name.getText());
                }
                catch (Exception e){
                    this.error.setVisible(true);
                    return;
                }
                student = dbaStudent.findById(id);
                if (student == null){
                    this.error.setVisible(true);
                    return;
                }
                dbaStudent.delete(student);
                break;

            case "Добавить":
                if (this.name.getText().isEmpty() || this.name.getText().equals("")
                        || this.surname.getText().isEmpty() || this.surname.getText().equals("")
                        || this.course.getText().isEmpty() || this.course.getText().equals("")){
                    this.error.setVisible(true);
                    return;
                }
                try{
                    long group = Long.parseLong(this.course.getText());
                    GenericDataBaseAccess<CourseEntity, Long> dbaCourses = new GenericDataBaseAccess<>(CourseEntity.class);
                    GenericDataBaseAccess<PersonEntity, Long> dbaPerson = new GenericDataBaseAccess<>(PersonEntity.class);

                    CourseEntity course = dbaCourses.findById(group);
                    PersonEntity person = new PersonEntity();
                    person.setName(this.name.getText());
                    person.setSurname(this.surname.getText());

                    dbaPerson.create(person);

                    StudentEntity newStudent = new StudentEntity();
                    newStudent.setCourse(course);
                    newStudent.setPerson(person);

                    dbaStudent.create(newStudent);
                }
                catch (Exception e){
                    System.out.print(e.getMessage());
                    this.error.setVisible(true);
                    return;
                }
                break;

            case "Расширить":
                long personId;
                long groupId;
                StudentEntity studentExtend;
                GenericDataBaseAccess<PersonEntity, Long> dbaPerson = new GenericDataBaseAccess<>(PersonEntity.class);
                GenericDataBaseAccess<CourseEntity, Long> dbaCourses = new GenericDataBaseAccess<>(CourseEntity.class);
                try{
                    personId = Long.parseLong(this.name.getText());
                    groupId = Long.parseLong(this.course.getText());
                    PersonEntity personToUpdate = dbaPerson.findById(personId);
                    CourseEntity course = dbaCourses.findById(groupId);
                    StudentEntity newStudent = new StudentEntity();
                    newStudent.setCourse(course);
                    newStudent.setPerson(personToUpdate);
                    dbaStudent.create(newStudent);

                }
                catch (Exception e){
                    this.error.setVisible(true);
                    return;
                }

                break;

        }



        updateTable();
    }


}
