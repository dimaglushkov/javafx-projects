package REAgency.DAO;

import REAgency.Entity.Manager;

import javax.persistence.*;

public class ManagerDAO extends DAOService<Manager, Long> {
    public ManagerDAO()
    {
        super(Manager.class);
    }

}

