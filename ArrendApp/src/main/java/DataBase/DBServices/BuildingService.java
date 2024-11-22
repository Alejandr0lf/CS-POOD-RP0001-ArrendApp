package DataBase.DBServices;

import java.util.List;

import DataBase.DBObjects.BuildingDAO;
import Model.appObjects.Building;

public class BuildingService {
    BuildingDAO buildingDAO = new BuildingDAO();

    public List<Building> check() {
        return buildingDAO.check();
    }
}
