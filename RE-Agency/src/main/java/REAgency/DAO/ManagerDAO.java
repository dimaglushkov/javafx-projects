package REAgency.DAO;

import REAgency.Entity.Manager;

import javax.persistence.*;

public class ManagerDAO extends DAOService<Manager, Long> {
    public ManagerDAO()
    {
        super(Manager.class);
    }

    public Manager findByManagerId(long ManagerId)
    {
        Manager manager;
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM MANAGER WHERE MANAGER_ID = " + ManagerId, Manager.class);

        try
        {
            manager = (Manager) query.getSingleResult();
        }
        catch (NoResultException e)
        {
            manager = null;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return manager;
    }

}

