package LibraryManager.View;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DebtorTableContent extends ClientTableContent{
    private SimpleStringProperty isDebtor;
    private SimpleIntegerProperty bookId;
    private SimpleStringProperty rentDay;
    private SimpleIntegerProperty rentOver;

    public DebtorTableContent() {
        isDebtor = new SimpleStringProperty();
        bookId = new SimpleIntegerProperty();
        rentDay = new SimpleStringProperty();
        rentOver = new SimpleIntegerProperty();
    }
}
