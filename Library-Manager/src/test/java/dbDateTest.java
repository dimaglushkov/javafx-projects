import LibraryManager.Data.DBAObject;
import LibraryManager.Entity.Book;
import LibraryManager.Entity.Customer;
import LibraryManager.Entity.Person;
import LibraryManager.Entity.Rent;

import java.sql.Date;
import java.util.List;

public class dbDateTest {
    public static void main(String[] args) {
        DBAObject<Rent, Integer> dbaRent = new DBAObject<Rent, Integer>(Rent.class);
        DBAObject<Book, Integer> dbaBook = new DBAObject<Book, Integer>(Book.class);
        DBAObject<Customer, Integer> dbaCustomer = new DBAObject<Customer, Integer>(Customer.class);
//        Rent rent = new Rent();
//
//        rent.setDay(new Date(System.currentTimeMillis()));
//        rent.setCustomer(dbaCustomer.findById(1));
//        rent.setBook(dbaBook.findById(1));
//        rent.setDuration(10);
//        dbaRent.create(rent);
        Rent rent = dbaRent.findById(1);
        System.out.print(rent.getDay());

    }
}
