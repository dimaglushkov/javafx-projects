package StorageSystem;

import StorageSystem.DAO.DAOService;
import StorageSystem.Entities.testEntity;

public class dbtest {

    public static void main(String[] args) {
        DAOService<testEntity, Long> daoService = new DAOService<>(testEntity.class);

        testEntity entity = daoService.findById(1L);

        System.out.print(entity.getId());
    }
}
