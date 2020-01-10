package REAgency.Controllers;

import REAgency.DAO.ManagerDAO;
import REAgency.Entity.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private ManagerDAO managerDAO = new ManagerDAO();

    @FXML
    private Label pageNameLabel;

    @FXML
    private TextField idInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Label wrongInputLabel;

    @FXML
    private Button registerButton;

    public void login(ActionEvent event){

        if (!validateId(idInput.getText()) || !validatePassword(passwordInput.getText())) {
            wrongInputLabel.setVisible(true);
            return;
        }
        else
            wrongInputLabel.setVisible(false);

        Manager manager = managerDAO.findById(Long.parseLong(idInput.getText()));
        if (manager == null || !manager.getPassword().equals(passwordInput.getText())) {
            wrongInputLabel.setVisible(true);
            return;
        }

//        Manager manager = managerDAO.findByManagerId(Long.parseLong(idInput.getText()));
//        System.out.print(manager.getName() + manager.getPassword());
//        Stage stage = (Stage) loginButton.getScene().getWindow();
//        stage.close();
    }

    public void registerPage(ActionEvent event){
        Stage stage = (Stage) pageNameLabel.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/register.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private boolean validateId(String id){
        if (id == null || id.equals("")) {
            return false;
        }
        try {
            long d = Long.parseLong(id);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean validatePassword(String password){
        return password != null && !password.equals("");
    }

}
