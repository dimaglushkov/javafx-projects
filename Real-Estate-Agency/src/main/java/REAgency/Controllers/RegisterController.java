package REAgency.Controllers;

import REAgency.DAO.ManagerDAO;
import REAgency.Entity.Manager;
import REAgency.Converter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    ManagerDAO managerDAO = new ManagerDAO();

    @FXML
    private Label pageNameLabel;

    @FXML
    private HBox inputForm;

    @FXML
    private VBox mainContainer;

    @FXML
    private Button registerButton;

    @FXML
    private TextField nameInput;
    @FXML
    private TextField surnameInput;
    @FXML
    private ChoiceBox<String> specInput;
    @FXML
    private TextField comissionInput;
    @FXML
    private TextField passwordInput;
    @FXML
    private Label wrongInputLabel;

    public void register(ActionEvent event){
        String spec = Converter.convertSpec(specInput.getValue());

        if(!validateField(nameInput.getText())
                || !validateField(surnameInput.getText())
                || spec.equals("none")
                || !validateComission(comissionInput.getText())
                || !validateField(passwordInput.getText())) {
            wrongInputLabel.setVisible(true);
            return;
        }
        else
            wrongInputLabel.setVisible(false);

        Manager manager = new Manager();
        manager.setName(nameInput.getText());
        manager.setSurname(surnameInput.getText());
        manager.setSpec(spec);
        manager.setPassword(Converter.SHA256(passwordInput.getText()));
        manager.setComission(Integer.parseInt(comissionInput.getText()));

        managerDAO.create(manager);

        long userId = manager.getId();
        System.out.print(userId);

        inputForm.setVisible(false);
        inputForm.setManaged(false);
        registerButton.setVisible(false);
        registerButton.setManaged(false);

        Label congrtzLabel = new Label("Вы успешно зарегистрировались в системе! Ваш id: " + userId);
        congrtzLabel.setFont(pageNameLabel.getFont());

        mainContainer.getChildren().add(1, congrtzLabel);




    }

    private boolean validateField(String password){
        return password != null && !password.equals("");
    }

    private boolean validateComission(String comission){
        if (comission == null || comission.equals("")) {
            return false;
        }
        try {
            int d = Integer.parseInt(comission);
            if (d >= 100)
                return false;
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void loginPage(ActionEvent event){
        Stage stage = (Stage) pageNameLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/login.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
