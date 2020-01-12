package StorageSystem;

import StorageSystem.DAO.DAOService;
import StorageSystem.Entities.Product;

public class dbtest {

    public static void main(String[] args) {
        DAOService<Product, Long> daoService = new DAOService<>(Product.class);

//        Product product = daoService.findById(1);
//        System.out.print(product.getId());

        Product product1  = new Product();
        product1.setCategory("cat");
        product1.setDescription("desc");
        product1.setVendorCode("code");
        daoService.create(product1);

    }
}
