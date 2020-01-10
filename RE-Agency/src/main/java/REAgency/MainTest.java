package REAgency;


import REAgency.DAO.ManagerDAO;
import REAgency.Entity.Manager;

public class MainTest {

    public static void main(String[] args) {
        ManagerDAO managerDAO = new ManagerDAO();
        Manager manager = managerDAO.findByManagerId(1);
        System.out.print(manager.getName() + manager.getSurname());
    }
}