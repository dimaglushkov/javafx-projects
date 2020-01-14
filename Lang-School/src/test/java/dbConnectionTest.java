import Data.BranchEntity;
import Data.GenericDataBaseAccess;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class dbConnectionTest {


    public static void main(String[] args) throws UnsupportedEncodingException, SQLException {
        GenericDataBaseAccess<BranchEntity, Long> dataBaseAccess = new GenericDataBaseAccess<BranchEntity, Long>(BranchEntity.class);
        List<BranchEntity> branchEntities = dataBaseAccess.findAll();
        for (BranchEntity branchEntity : branchEntities){
//            String data = new String(branchEntity.getStreet().getBytes(), "WINDOWS-1252");
//            System.out.println(data);
            System.out.println(branchEntity.getStreet().length() + " " + branchEntity.getStreet());

        }
//        BranchEntity branch = new BranchEntity();
//        branch.setStreet(new String("лул".getBytes(), "UTF-8"));
//        branch.setBuilding(1);
//        branch.setPhone("asd");
//        dataBaseAccess.create(branch);

//            System.out.print((branchEntity.getStreet() + "\n").getBytes("win"));;
    }

}
