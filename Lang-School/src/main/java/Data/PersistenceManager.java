package Data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager
{

    protected EntityManagerFactory entityManagerFactory;
    private static final PersistenceManager persistenceManager = new PersistenceManager();

    public static PersistenceManager getInstance()
    {
        return persistenceManager;
    }

    private PersistenceManager() {
    }

    public EntityManagerFactory getEntityManagerFactory()
    {

        if (entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory("langschool");

        return entityManagerFactory;
    }

    public void closeEntityManagerFactory()
    {
        if (entityManagerFactory != null)
        {
            entityManagerFactory.close();
            entityManagerFactory = null;
        }

    }

}