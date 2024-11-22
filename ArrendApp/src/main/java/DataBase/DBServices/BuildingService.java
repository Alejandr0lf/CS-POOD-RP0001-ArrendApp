package DataBase.DBServices;

import java.util.List;

import DataBase.DBObjects.BuildingDAO;
import Model.appObjects.Building;

public class BuildingService {
    BuildingDAO buildingDAO = new BuildingDAO();

    public List<Building> check() {
        return buildingDAO.check();
    }

    // public int crear(User user) {
    // return buildingDAO.create(user);
    // }

    // public int delete(User user) {
    // return buildingDAO.delete(user);
    // }

    // public int update(User user) {
    // return buildingDAO.update(user);
    // }
}
