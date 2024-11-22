package DataBase.DBObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DataBase.Connection.DataBaseConnection;
import DataBase.DBServices.DirectionService;
import DataBase.DBServices.ServicesService;
import DataBase.DBServices.UserComercialService;
import Model.User.User_Comercial;
import Model.appObjects.Building;
import Model.appObjects.Direction;
import Model.appObjects.Services;

public class BuildingDAO {

    public static final String SQLCHECK = "SELECT ub.ID as buildingID, ub.landlord, ub.levels, ub.rooms, ub.bathrooms, ub.score, ub.equiped, ub.hasCook, ub.includedServices, ub.available, bd.adress, bd.coordinates, bd.neighborhood, bd.city,uu.name, uu.lastName, uu.phoneNumber, uu.email FROM DB_UserBuildings ub, DB_BuildingsServices bs, DB_BuildingDirection bd, DB_UserComercial uc, DB_UserUsers uu WHERE uu.ID = uc.ID AND ub.services = bs.ID AND ub.direction = bd.coordinates AND uc.ID = ub.landlord";

    public List<Building> check() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        List<Building> buildings = new ArrayList<>();
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCHECK);
            result = ps.executeQuery();
            while (result.next()) {

                /* ---------------------------- crear el Servicio --------------------------- */
                ServicesService srv = new ServicesService();
                Services serv = new Services(result.getLong("buildingID"));
                Services service = srv.checkId(serv);

                /* --------------------------- crear la direccion --------------------------- */
                DirectionService drt = new DirectionService();
                Direction dirt = new Direction(result.getString("coordinates"));
                Direction direction = drt.checkId(dirt);

                /* -------------------------- crear user comercial -------------------------- */
                User_Comercial dbUser = new User_Comercial(String.valueOf(result.getLong("landlord")));
                UserComercialService cService = new UserComercialService();
                User_Comercial comercial = cService.checkId(dbUser);

                /* ---------------------------- Crear el building --------------------------- */
                long id = result.getLong("BuildingID");
                int levels = result.getInt("levels");
                int rooms = result.getInt("rooms");
                int bathrooms = result.getInt("bathrooms");
                int score = result.getInt("score");
                boolean equiped = result.getBoolean("equiped");
                boolean hasCook = result.getBoolean("hasCook");
                boolean includedServices = result.getBoolean("includedServices");
                boolean available = result.getBoolean("available");

                Building building = new Building(id, comercial, direction, levels, rooms, bathrooms, score, equiped,
                        hasCook, includedServices, available, service);

                buildings.add(building);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buildings;
    }
}
