package LibraryManager.View;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RentTableContent extends BookTableContent{

    private SimpleStringProperty isRented;
    private SimpleStringProperty rentDay;
    private SimpleStringProperty rentReturnDay;
    private SimpleIntegerProperty rentDaysLeft;
    private SimpleStringProperty customerName;

    /*
             TableColumn<RentTableContent, Integer> col7 = new TableColumn<>("На руках");
        col7.setCellValueFactory(new PropertyValueFactory<>("isRented"));

        TableColumn<RentTableContent, String> col11 = new TableColumn<>("Имя клиента");
        col11.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<RentTableContent, String> col8 = new TableColumn<>("День выдачи");
        col8.setCellValueFactory(new PropertyValueFactory<>("rentDay"));

        TableColumn<RentTableContent, String> col9 = new TableColumn<>("День возврата");
        col9.setCellValueFactory(new PropertyValueFactory<>("rentReturnDay"));

        TableColumn<RentTableContent, String> col10 = new TableColumn<>("Дней осталось");
        col10.setCellValueFactory(new PropertyValueFactory<>("rentDaysLeft"));
     */


    public RentTableContent() {
    }
}
