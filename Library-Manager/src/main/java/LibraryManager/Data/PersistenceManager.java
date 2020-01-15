package LibraryManager.Data;

import javax.persistence.EntityManagerFactory;

public class PersistenceManager
{
    private static final PersistenceManager INSTANCE = new PersistenceManager();
    protected EntityManagerFactory entityManagerFactory;

    public static PersistenceManager getInstance()
    {
        return INSTANCE;
    }

    private PersistenceManager() {
    }

    public EntityManagerFactory getEntityManagerFactory()
    {

        if (entityManagerFactory == null)
            entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("library-manager");

        return entityManagerFactory;
    }

}