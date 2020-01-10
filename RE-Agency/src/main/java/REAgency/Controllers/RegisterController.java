package REAgency.Controllers;

import REAgency.DAO.ManagerDAO;
import REAgency.Entity.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    ManagerDAO managerDAO = new ManagerDAO();

    @FXML
    private Label pageNameLabel;

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
        String spec = convertSpec(specInput.getValue());

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
        manager.setPassword(passwordInput.getText());
        manager.setComission(Integer.parseInt(comissionInput.getText()));

        managerDAO.create(manager);
        System.out.print("entity created");

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

    private String convertSpec(String oldSpec){
        switch (oldSpec)
        {
            case "Продажа":
                return "sale";
            case "Покупка":
                return "buy";
            case "Аренда":
                return "rent";
            case "Обмен":
                return "trade";
            default:
                return "none";
        }
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
