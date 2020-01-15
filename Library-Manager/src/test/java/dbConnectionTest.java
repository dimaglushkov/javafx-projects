import LibraryManager.Data.DBAObject;
import LibraryManager.Entity.Person;

import java.util.List;

public class dbConnectionTest {
    public static void main(String[] args) {
        DBAObject<Person, Integer> dbaPerson = new DBAObject<Person, Integer>(Person.class);
        List<Person> persons = dbaPerson.findAll();
        for(Person person : persons)
            System.out.println(person.getSecondName());
    }
}
