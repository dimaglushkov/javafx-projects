package StorageSystem.DataAccessObjects;

import StorageSystem.Entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class ProductDAO extends DAObject<Product, Integer>{

    public ProductDAO() {
        super(Product.class);
    }

    public List<Product> findByVendorCode(String vendorCode){

        List<Product> products;
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            Query query = entityManager.createNativeQuery(
                    "SELECT * FROM PRODUCT WHERE VENDOR_CODE = '" + vendorCode + "';", Product.class);

            products = query.getResultList();
        }
        catch (NoResultException e)
        {
            products = null;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return products;
    }

    public List<Product> findByCategory(String category) {
        List<Product> products;
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            Query query = entityManager.createNativeQuery(
                    "SELECT * FROM PRODUCT WHERE CATEGORY = '" + category + "';", Product.class);

            products = query.getResultList();
        }
        catch (NoResultException e)
        {
            products = null;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return products;
    }

    public List<Product> findByDescription(String description) {
        List<Product> products;
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            Query query = entityManager.createNativeQuery(
                    "SELECT * FROM PRODUCT WHERE DESCRIPTION = '" + description + "';", Product.class);

            products = query.getResultList();
        }
        catch (NoResultException e)
        {
            products = null;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return products;
    }

    public List<Product> findByManufacturer(String manufacturer) {
        List<Product> products;
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            Query query = entityManager.createNativeQuery(
                    "SELECT * FROM PRODUCT WHERE MANUFACTURER = '" + manufacturer + "';", Product.class);

            products = query.getResultList();
        }
        catch (NoResultException e)
        {
            products = null;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return products;
    }

    public List<Product> findByLocation(String storageId) {
        List<Product> products;
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        try
        {
            Query query = entityManager.createNativeQuery(
                    "SELECT * FROM PRODUCT WHERE LOCATION = " + storageId + ";", Product.class);

            products = query.getResultList();
        }
        catch (NoResultException e)
        {
            products = null;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return products;
    }
}
