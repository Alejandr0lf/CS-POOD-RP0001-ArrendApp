package DataBase.DBServices;

import java.util.List;

import DataBase.DBObjects.BuildingDAO;
import Model.User.User;

public class BuildingService {
    public class UserService {
        BuildingDAO buildingDao = new BuildingDAO();

        public List<User> consultar() {
            return buildingDao.consultar();
        }

        public int crear(User user) {
            return buildingDao.create(user);
        }

        public int delete(User user) {
            return buildingDao.delete(user);
        }

        public int update(User user) {
            return buildingDao.update(user);
        }
    }
}
