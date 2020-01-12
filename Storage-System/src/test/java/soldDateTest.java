import StorageSystem.DataAccessObjects.DAObject;
import StorageSystem.Entities.Product;

public class soldDateTest {
    public static void main(String[] args){
        DAObject<Product, Integer> daObject = new DAObject(Product.class);
        Product product = daObject.findById(1);
        System.out.print("asd");
    }
}
